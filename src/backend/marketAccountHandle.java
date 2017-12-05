

import java.sql.*;
import java.util.Date;

public class marketAccountHandle extends accountHandle
{
	int balance;

	public marketAccountHandle()
	{
		super();
	}

	public marketAccountHandle(int id)
	{
		super();
		try
		{
			String query = "SELECT balance FROM market_account WHERE a_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.balance = rs.getInt("balance");
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

	public boolean makeDeposit(int amount)
	{
		try
		{
			this.openConnection();
			int new_balance = this.balance + amount;
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

	public boolean makeWithdrawal(int amount)
	{
		try
		{
			this.openConnection();
			int new_balance = this.balance - amount;
			System.out.println(new_balance);
			String query = "UPDATE market_account SET balance="+new_balance+" WHERE a_id="+this.id;
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);
			System.out.println("broken here?");

			transaction t = new transaction();
			boolean ret = t.makeTransaction(this.id, "withdrawal", amount);

			return ret;

		}catch(Exception e){System.out.println(e);}

		return false;
	}
}