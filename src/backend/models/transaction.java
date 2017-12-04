package StarsRUSModels;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

class transaction extends item
{
	int a_id;
	int date;
	List<buy> buyList;
	List<sell> sellList;
	List<deposit> depositList;
	List<withdrawal> withdrawalList;
	List<accrual> accrualList;

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
			String query = "SELECT a_id, date FROM transactions WHERE t_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = id;
				this.a_id = rs.getInt("a_id");
				this.date = rs.getInt("date");
			}
			this.closeConnection();

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

}

