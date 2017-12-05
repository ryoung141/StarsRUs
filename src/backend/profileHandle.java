

import java.sql.*;

public class profileHandle extends item
{
	ResultSet accountData;
	accountHandle[] accounts;
	String username;
	String firstname;
	String lastname;
	String state_code;
	String phonenumber;
	String email;
	public boolean auth;

	public profileHandle()
	{
		super();
	}


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
			else
			{
				this.auth = false;
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public boolean create(String firstname, String lastname, String phonenumber, String email, int taxID, String username, String password, String state)
	{
		try
		{
			this.openConnection();
			Statement stmt = this.con.createStatement();
			String query = "INSERT INTO customer_profile(tax_id, username, password, firstname, lastname, state, phonenumber, email) VALUES (";
			query = query + taxID + ", '" + username + "', '" + password + "', '" + firstname + "', '" + lastname + "', '" + state + "', '" + phonenumber + "', '" + email + "')";
			int results = stmt.executeUpdate(query);

			this.closeConnection();
			if(results > 0)
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

	//uncomment for testing
	public static void main(String args[])
	{
		//profile testing
		profileHandle ah = new profileHandle("admin", "admin");
		profileHandle ah1 = new profileHandle(1234);
		System.out.println(ah.firstname);
		System.out.println(ah1.lastname);
		System.out.println(ah.email);
		System.out.println(ah1.phonenumber);

		//account handle testing
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

		//actor testing
		actor a = new actor(2);
		System.out.println(a.stock_symbol);
		System.out.println(a.firstname);
		System.out.println(a.s_id);

		//stock testing
		stock s = new stock(2);
		System.out.println(s.stock_symbol);
		System.out.println(s.active);

		//contract testing
		contract c = new contract(2);
		System.out.println(c.total_value);
		System.out.println(c.role);
		System.out.println(c.year_released);

		transaction t = new transaction(1);
		System.out.println(t.date);
		System.out.println(t.a_id);

		t.getAllTransactions(t.a_id);

		System.out.println(t.depositList.get(0).amount);
	}
}