package StarsRUSModels;

import java.sql.*;

class profileHandle extends item
{
	ResultSet accountData;
	accountHandle[] accounts;
	String username;
	String firstname;
	String lastname;
	String state_code;
	String phonenumber;
	String email;


	public profileHandle(String username, String password)
	{
		super();
		try
		{
			String[] arr = {username, password};
			this.authenticate(arr);
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
		
	}

	public profileHandle(int id)
	{
		super();
		try
		{
			String[] arr = {Integer.toString(id)};
			this.authenticate(arr);
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
		
	}

	private void authenticate(String args[])
	{
		try
		{
			this.openConnection();
			Statement stmt = this.con.createStatement();
			String query = "";
			if(args.length > 1)
			{
				query = "SELECT * FROM customer_profile WHERE username='"+args[0]+"' AND password='"+args[1]+"'";
			}
			else
			{
				query = "SELECT * FROM customer_profile WHERE tax_id="+args[0];
			}
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next())
			{
				this.accountData = rs;
				this.id = rs.getInt("tax_id");
				this.username = rs.getString("username");
				this.firstname = rs.getString("firstname");
				this.lastname = rs.getString("lastname");
				this.state_code = rs.getString("state");
				this.phonenumber = rs.getString("phonenumber");
				this.email = rs.getString("email");
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	//uncomment for testing
	public static void main(String args[])
	{
		profileHandle ah = new profileHandle("admin", "admin");
		profileHandle ah1 = new profileHandle(1234);
		System.out.println(ah.firstname);
		System.out.println(ah1.lastname);
		System.out.println(ah.email);
		System.out.println(ah1.phonenumber);

		accountHandle ah2 = new accountHandle("admin");
		System.out.println(ah2.id);
		System.out.println(ah2.owner);

		marketAccountHandle mh = new marketAccountHandle(ah2.id);
		System.out.println(mh.balance);

		stockAccountHandle sh = new stockAccountHandle();
		stockAccountHandle sh1 = new stockAccountHandle(4);
		System.out.println(sh1.id);
		System.out.println(sh1.balance);
		System.out.println(sh1.master_id);
		sh.getStockAccounts(ah2.id);
		for(stockAccountHandle sah: sh.accountList)
		{
			System.out.println(sah.id);
		} 
	}
}