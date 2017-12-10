import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Date;

public class marketAccountHandle extends accountHandle
{
	double balance;
	double avg_daily_balance;

	public marketAccountHandle()
	{
		super();
	}

	public marketAccountHandle(int id)
	{
		super();
		try
		{
			String query = "SELECT balance, avg_daily_balance FROM market_account WHERE a_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.balance = rs.getDouble("balance");
				this.avg_daily_balance = rs.getDouble("avg_daily_balance");
				this.id = id;
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public boolean create(int a_id)
	{
		try
		{
			this.openConnection();
			String query = "INSERT INTO market_account(a_id, balance) VALUES ("+a_id+", 1000)";
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			if(rs > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e){System.out.println(e);}

		return false;
	}

	public void makeAccrual()
	{
		double new_balance = this.balance + (avg_daily_balance/item.days_since_beginning) * transaction.interestRate;
		double amount = new_balance - this.balance;

		try 
		{
			this.openConnection();

			long date = System.currentTimeMillis();
 			String query = "INSERT INTO transactions(a_id, system_date, date) VALUES ("+this.id+", '"+this.system_date+"', "+date+")";
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			query = "SELECT t_id FROM transactions WHERE date="+date;
			stmt = this.con.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
			if(rs1.next())
			{
				query = "INSERT INTO accrue_interest(t_id, amount) VALUES ("+rs1.getInt("t_id")+", "+amount+")";
				stmt = this.con.createStatement();
				rs = stmt.executeUpdate(query);
			}

			query = "UPDATE market_account SET balance="+new_balance+" WHERE a_id="+this.id;
			stmt = this.con.createStatement();
			rs = stmt.executeUpdate(query);

			query = "UPDATE market_account SET avg_daily_balance=0 WHERE a_id="+this.id;
			stmt = this.con.createStatement();
			rs = stmt.executeUpdate(query);

			this.closeConnection();
		}catch(Exception e){System.out.println(e);}
	}

	public void accrueAll()
	{
		ArrayList<marketAccountHandle> mh = new ArrayList<marketAccountHandle>();

		try
		{
			this.openConnection();
			String query = "SELECT a_id FROM market_account";
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				marketAccountHandle m = new marketAccountHandle(rs.getInt("a_id"));
				mh.add(m);
			}

		}catch(Exception e){System.out.println(e);}

		for(marketAccountHandle mh1: mh)
		{
			mh1.makeAccrual();
		}
	}

	public boolean makeDeposit(double amount)
	{
		try
		{
			this.openConnection();
			double new_balance = this.balance + amount;
			String query = "UPDATE market_account SET balance="+new_balance+" WHERE a_id="+this.id;
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			if(rs > 0)
			{
				transaction t = new transaction();
				boolean ret = t.makeTransaction(this.id, "deposit", amount);
				return ret;
			}
			else
			{
				return false;
			}
			
		}catch(Exception e){System.out.println(e);}

		return false;
	}

	public boolean makeWithdrawal(double amount)
	{
		try
		{
			this.openConnection();
			double new_balance = this.balance - amount;
			String query = "UPDATE market_account SET balance="+new_balance+" WHERE a_id="+this.id;
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			transaction t = new transaction();
			boolean ret = t.makeTransaction(this.id, "withdrawal", amount);

			return ret;

		}catch(Exception e){System.out.println(e);}

		return false;
	}

	public void incrementDay()
	{
		double new_avg = this.avg_daily_balance + this.balance;
		try
		{
			this.openConnection();
			String query = "UPDATE market_account SET avg_daily_balance="+new_avg+" WHERE a_id="+this.id;
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

		}catch(Exception e){System.out.println(e);}
	}

	public void incrementAll()
	{
		ArrayList<marketAccountHandle> mh = new ArrayList<marketAccountHandle>();

		try
		{
			this.openConnection();
			String query = "SELECT a_id FROM market_account";
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				marketAccountHandle m = new marketAccountHandle(rs.getInt("a_id"));
				mh.add(m);
			}

		}catch(Exception e){System.out.println(e);}

		for(marketAccountHandle m: mh)
		{
			m.incrementDay();
		}
	}

	public double getBalance()
	{
		return this.balance;
	}

	public boolean validateBalance(double subtract)
	{
		return (this.balance - subtract) > 0;
	}

}