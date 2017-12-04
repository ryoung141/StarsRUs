package StarsRUSModels;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

class stockAccountHandle extends accountHandle
{
	int balance;
	int master_id;
	int s_id;
	List<stockAccountHandle> accountList;

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

	public String getStock(int s_id)
	{
		try
		{
			stock s = new stock(s_id);
			return s.stock_symbol;

		}catch(Exception e){System.out.println(e);}
		return "false";
	}
}