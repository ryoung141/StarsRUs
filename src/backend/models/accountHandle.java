package StarsRUSModels;

import java.sql.*;

class accountHandle
{
	final String connection = "jdbc:mysql://localhost:3306/cs174a";
	ResultSet accountData;
	int id;
	String username;
	String firstname;
	String lastname;
	String state_code;
	String phonenumber;
	String email;


	public accountHandle(String username, String password)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(this.connection);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM customer_profile WHERE username="+username+" AND password="+password;
			ResultSet rs = stmt.executeQuery(query);
			this.accountData = rs;
			this.id = rs.getInt("tax_id");
			this.username = rs.getString("username");
			this.firstname = rs.getString("firstname");
			this.lastname = rs.getString("lastname");
			this.state_code = rs.getString("state");
			this.phonenumber = rs.getString("phonenumber");
			this.email = rs.getString("email");
			con.close();
		}catch(Exception e){System.out.println(e);}
		
	}

	public accountHandle(int id)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(this.connection);
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM customer_profile WHERE tax_id="+id;
			ResultSet rs = stmt.executeQuery(query);
			this.accountData = rs;
			this.id = rs.getInt("tax_id");
			this.username = rs.getString("username");
			this.firstname = rs.getString("firstname");
			this.lastname = rs.getString("lastname");
			this.state_code = rs.getString("state");
			this.phonenumber = rs.getString("phonenumber");
			this.email = rs.getString("email");
			con.close();
		}catch(Exception e){System.out.println(e);}
		
	}

	public static void main(String args[])
	{
		accountHandle ah = new accountHandle("admin", "admin");
		System.out.println(ah.firstname);
	}
}