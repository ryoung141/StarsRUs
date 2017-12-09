

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class stockAccountHandle extends accountHandle
{
	public int balance;
	public int master_id;
	public int s_id;
	public List<stockAccountHandle> accountList;

	public stockAccountHandle()
	{
		super();
		this.accountList = new ArrayList<stockAccountHandle>();
	}

	public stockAccountHandle(int id)
	{
		this.accountList = new ArrayList<stockAccountHandle>();

		try
		{
			this.openConnection();
			String query = "SELECT master_id, s_id, balance FROM stock_account WHERE a_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.balance = rs.getInt("balance");
				this.id = id;
				this.master_id = rs.getInt("master_id");
				this.s_id = rs.getInt("s_id");
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public boolean create(int master_id, int s_id)
	{
		try
		{
			this.openConnection();
			String query = "INSERT INTO stock_account(master_id, s_id) VALUES ("+master_id+", "+s_id+")";
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

	public void getStockAccounts(int master_id)
	{
		try
		{
			this.openConnection();
			String query = "SELECT a_id FROM stock_account WHERE master_id="+master_id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				this.accountList.add(new stockAccountHandle(rs.getInt("a_id")));
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public stock getStock(int s_id)
	{
		try
		{
			stock s = new stock(s_id);
			return s;

		}catch(Exception e){System.out.println(e);}
		return null;
	}

	public stockAccountHandle getHandle(int s_id)
	{
		if(this.accountList != null)
		{
			for(stockAccountHandle sh:this.accountList)
			{
				if(sh.s_id == s_id)
				{
					return sh;
				}
			}
		}
		return null;
	}

	public boolean makePurchase(double amount, double price)
	{
		try
		{
			this.openConnection();
			double new_balance = this.balance + amount;
			String query = "UPDATE stock_account SET balance="+new_balance+" WHERE a_id="+this.id;
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			transaction t = new transaction();
			boolean ret = t.makeTransaction(this.master_id, "buy", amount, price, this.s_id);

			return ret;

		}catch(Exception e){System.out.println(e);}

		return false;
	}

	public boolean makeSale(double amount, double price)
	{
		try
		{
			this.openConnection();
			double new_balance = this.balance - amount;
			String query = "UPDATE stock_account SET balance="+new_balance+" WHERE a_id="+this.id;
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			transaction t = new transaction();
			boolean ret = t.makeTransaction(this.master_id, "sell", amount, price, this.s_id);

			return ret;

		}catch(Exception e){System.out.println(e);}

		return false;
	}
}