

import java.sql.*;

public class item
{
	static final String CONNECTION = "jdbc:mysql://localhost:3306/cs174a?useSSL=false";
	static final String USER = "root";
	static final String PASS = " ";
	Connection con;
	int id;

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
}