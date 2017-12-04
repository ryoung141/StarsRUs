package StarsRUSModels;

import java.sql.*;

class actor extends item
{
	int s_id;
	int date_of_birth;
	String firstname;
	String lastname;
	String stock_symbol;

	public actor(int id)
	{
		super();
		try
		{
			String query = "SELECT * FROM actor INNER JOIN stock ON stock.a_id = actor.a_id WHERE actor.a_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = rs.getInt("a_id");
				this.s_id = rs.getInt("s_id");
				this.date_of_birth = rs.getInt("date_of_birth");
				this.firstname = rs.getString("firstname");
				this.lastname = rs.getString("lastname");
				this.stock_symbol = rs.getString("symbol");
			}

		}catch(Exception e){System.out.println(e);}
	}

	public actor(String symbol)
	{
		super();
		try
		{
			String query = "SELECT * FROM actor INNER JOIN stock ON stock.a_id = actor.a_id WHERE stock.symbol='"+symbol+"'";
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = rs.getInt("a_id");
				this.s_id = rs.getInt("s_id");
				this.date_of_birth = rs.getInt("date_of_birth");
				this.firstname = rs.getString("firstname");
				this.lastname = rs.getString("lastname");
				this.stock_symbol = rs.getString("symbol");
			}

		}catch(Exception e){System.out.println(e);}
	}
}