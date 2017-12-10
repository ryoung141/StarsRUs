

import java.sql.*;

public class item
{
	static final String CONNECTION = "jdbc:mysql://localhost:3306/cs174a?useSSL=false";
	static final String USER = "root";
	static final String PASS = " ";
	public static String top_system_date = "3/16/2013";
	public static int days_since_beginning = 1;
	public String system_date;
	Connection con;
	public int id;

	public item()
	{
		this.system_date = item.top_system_date;
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

	public static void setSystemDay(String date)
	{
		String d = item.top_system_date;
		String temp[] = d.split("/");
		String day = temp[1];
		int dayte = Integer.parseInt(day);

		String temp1[] = date.split("/");
		String day1 = temp1[1];
		int dayte1 = Integer.parseInt(day);

		item.days_since_beginning = dayte1 - dayte;
		
		d = temp[0]+"/"+Integer.toString(dayte)+"/"+temp[2];
		item.top_system_date = date;
	}
}