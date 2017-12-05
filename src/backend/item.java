

import java.sql.*;

public class item
{
	static final String CONNECTION = "jdbc:mysql://cs174a.engr.ucsb.edu:3306/richard_youngDB?useSSL=false";
	static final String USER = "richard_young";
	static final String PASS = "113";
	Connection con;
	public int id;

	public item()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(CONNECTION, USER, PASS);
			this.con = connection;
		}catch(Exception e){System.out.println(e);}
	}

	public void openConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(CONNECTION, USER, PASS);
			this.con = connection;
		}catch(Exception e){System.out.println(e);}
	}

	public void closeConnection()
	{
		try
		{
			this.con.close();

		}catch(Exception e){System.out.println(e);}
	}

	public boolean isResultSetEmpty(ResultSet rs)
	{
		try
		{
			return !rs.first();

		}catch(Exception e){System.out.println(e);}

		return true;
	}
}