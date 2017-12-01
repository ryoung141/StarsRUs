package StarsRUSModels;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

class transaction extends item
{
	int a_id;
	int date;
	List<transaction> transactionList;

	public transaction()
	{
		super();
		transactionList = new ArrayList<transaction>();
	}

	public transaction(int id)
	{
		super();
		transactionList = new ArrayList<transaction>();

		try
		{
			String query = "SELECT a_id FROM transactions WHERE t_id="+id;
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

	public void getAllTransaction(int a_id)
	{
		try
		{
			this.openConnection();
			String query = "SELECT t_id FROM transactions WHERE a_id="+a_id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				this.transactionList.add(new transaction(rs.getInt("t_id")));
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}
}