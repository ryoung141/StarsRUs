package StarsRUSModels;

import java.sql.*;

class accountHandle extends item
{
	String owner;

	public accountHandle()
	{
		super();
	}

	public accountHandle(int id)
	{
		super();
		try
		{
			Statement stmt = this.con.createStatement();
			String query = "SELECT owner FROM account WHERE a_id="+id;
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.owner = rs.getString("owner");
			}
		}catch(Exception e){System.out.println(e);}

		this.closeConnection();
	}

	public accountHandle(String owner)
	{
		super();
		try
		{
			Statement stmt = this.con.createStatement();
			String query = "SELECT a_id FROM account WHERE owner="+owner;
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = rs.getInt("a_id");
			}
		}catch(Exception e){System.out.println(e);}
		
		this.closeConnection();
	}

	public accountHandle(int id, String owner)
	{
		super();
		this.id = id;
		this.owner = owner;
	}
}