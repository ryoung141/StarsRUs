

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import static java.lang.Math.toIntExact;

public class transaction extends item
{
	public static final double interestRate = 0.03;
	public int a_id;
	public long date;
	public ArrayList<buy> buyList;
	public ArrayList<sell> sellList;
	public ArrayList<deposit> depositList;
	public ArrayList<withdrawal> withdrawalList;
	public ArrayList<accrual> accrualList;

	public transaction()
	{
		super();
		buyList = new ArrayList<buy>();
		sellList = new ArrayList<sell>();
		depositList = new ArrayList<deposit>();
		withdrawalList = new ArrayList<withdrawal>();
		accrualList = new ArrayList<accrual>();
	}

	public transaction(int id)
	{
		super();
		buyList = new ArrayList<buy>();
		sellList = new ArrayList<sell>();
		depositList = new ArrayList<deposit>();
		withdrawalList = new ArrayList<withdrawal>();
		accrualList = new ArrayList<accrual>();

		try
		{
			String query = "SELECT a_id, date, system_date FROM transactions WHERE t_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = id;
				this.a_id = rs.getInt("a_id");
				this.system_date = rs.getString("system_date");
				this.date = rs.getLong("date");
			}
			// this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public void getAllTransactions(int a_id)
	{
		try
		{
			this.getAllBuys(a_id);
			this.getAllSells(a_id);
			this.getAllDeposits(a_id);
			this.getAllWithdrawals(a_id);
			this.getAllAccruals(a_id);

		}catch(Exception e){System.out.println(e);}
	}

	public void getAllBuys(int a_id)
	{
		try
		{
			this.openConnection();
			String query = "SELECT * FROM transactions INNER JOIN buy ON transactions.t_id = buy.t_id WHERE a_id="+a_id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				this.buyList.add(new buy(rs.getInt("t_id")));
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public void getAllSells(int a_id)
	{
		try
		{
			this.openConnection();
			String query = "SELECT * FROM transactions INNER JOIN sell ON transactions.t_id = sell.t_id WHERE a_id="+a_id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				this.sellList.add(new sell(rs.getInt("t_id")));
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public void getAllDeposits(int a_id)
	{
		try
		{
			this.openConnection();
			String query = "SELECT * FROM transactions INNER JOIN deposit ON transactions.t_id = deposit.t_id WHERE a_id="+a_id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				this.depositList.add(new deposit(rs.getInt("t_id")));
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public void getAllWithdrawals(int a_id)
	{
		try
		{
			this.openConnection();
			String query = "SELECT * FROM transactions INNER JOIN withdrawal ON transactions.t_id = withdrawal.t_id WHERE a_id="+a_id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				this.withdrawalList.add(new withdrawal(rs.getInt("t_id")));
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public void getAllAccruals(int a_id)
	{
		try
		{
			this.openConnection();
			String query = "SELECT * FROM transactions INNER JOIN accrue_interest ON transactions.t_id = accrue_interest.t_id WHERE a_id="+a_id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				this.accrualList.add(new accrual(rs.getInt("t_id")));
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public boolean makeTransaction(int a_id, String type, double amount)
	{
		try
		{
			this.openConnection();
			long date = System.currentTimeMillis();
 			String query = "INSERT INTO transactions(a_id, system_date, date) VALUES ("+a_id+", '"+this.system_date+"', "+date+")";
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			query = "SELECT t_id FROM transactions WHERE date="+date;
			stmt = this.con.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
			if(rs1.next())
			{
				System.out.println(type);
				boolean success = false;
				switch(type)
				{
					case "deposit":
						query = "INSERT INTO deposit(t_id, amount) VALUES ("+rs1.getInt("t_id")+", "+amount+")";
						stmt = this.con.createStatement();
						rs = stmt.executeUpdate(query);
						this.closeConnection();
						if(rs > 0)
						{
							success = true;
						}
						break;

					case "withdrawal":
						query = "INSERT INTO withdrawal(t_id, amount) VALUES ("+rs1.getInt("t_id")+", "+amount+")";
						stmt = this.con.createStatement();
						rs = stmt.executeUpdate(query);
						this.closeConnection();
						if(rs > 0)
						{
							success = true;
						}
						break;
				}
				this.closeConnection();
				return success;	
			}
		}catch(Exception e){System.out.println(e);}
		return false;
	}

	public boolean makeTransaction(int a_id, String type, double amount, double price, int s_id)
	{
		try
		{
			this.openConnection();
			long date = System.currentTimeMillis();
 			String query = "INSERT INTO transactions(a_id, system_date, date) VALUES ("+a_id+", '"+this.system_date+"', "+date+")";
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			query = "SELECT t_id FROM transactions WHERE date="+date;
			stmt = this.con.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
			if(rs1.next())
			{
				System.out.println(type);
				boolean success = false;
				switch(type)
				{
					case "buy":
						query = "INSERT INTO buy(t_id, s_id, amount, price) VALUES ("+rs1.getInt("t_id")+", "+s_id+", "+amount+", "+price+")";
						stmt = this.con.createStatement();
						rs = stmt.executeUpdate(query);
						this.closeConnection();
						if(rs > 0)
						{
							success = true;
						}
						break;

					case "sell":
						query = "INSERT INTO sell(t_id, s_id, amount, price) VALUES ("+rs1.getInt("t_id")+", "+s_id+", "+amount+", "+price+")";
						stmt = this.con.createStatement();
						rs = stmt.executeUpdate(query);
						this.closeConnection();
						if(rs>0)
						{
							success = true;
						}
						break;
				}
				this.closeConnection();
				return success;	
			}
		}catch(Exception e){System.out.println(e);}
		return false;
	}


	public boolean clearAllTransactions()
	{
		try
		{
			this.openConnection();
			String query = "DELETE FROM transactions WHERE t_id IS NOT NULL";
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			this.closeConnection();

		}catch(Exception e){System.out.println(e);}

		return true;
	}
}

