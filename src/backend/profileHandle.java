import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class profileHandle extends item
{
	public ArrayList<marketAccountHandle> marketAccountList;
	public ArrayList<stockAccountHandle> stockAccountList;
	public String username;
	public String firstname;
	public String lastname;
	public String state_code;
	public String phonenumber;
	public String email;
	public boolean auth = false;

	public profileHandle()
	{
		super();
	}

	public profileHandle(String username)
	{
		super();
		this.marketAccountList = new ArrayList<marketAccountHandle>();
		this.stockAccountList = new ArrayList<stockAccountHandle>();

		try
		{
			Statement stmt = this.con.createStatement();
			String query = "SELECT * FROM customer_profile WHERE username='"+username+"'";
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = rs.getInt("tax_id");
				this.username = rs.getString("username");
				this.firstname = rs.getString("firstname");
				this.lastname = rs.getString("lastname");
				this.state_code = rs.getString("state");
				this.phonenumber = rs.getString("phonenumber");
				this.email = rs.getString("email");
				this.auth = true;
			}
			this.closeConnection();
		}catch(Exception e){System.out.println(e);}
	}

	public profileHandle(String username, String password)
	{
		super();
		this.marketAccountList = new ArrayList<marketAccountHandle>();
		this.stockAccountList = new ArrayList<stockAccountHandle>();
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
		this.marketAccountList = new ArrayList<marketAccountHandle>();
		this.stockAccountList = new ArrayList<stockAccountHandle>();		
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
			
			if(!this.isResultSetEmpty(rs))
			{
				this.id = rs.getInt("tax_id");
				this.username = rs.getString("username");
				this.firstname = rs.getString("firstname");
				this.lastname = rs.getString("lastname");
				this.state_code = rs.getString("state");
				this.phonenumber = rs.getString("phonenumber");
				this.email = rs.getString("email");
				this.auth = true;
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

			boolean success = false;

			if(results > 0)
			{
				accountHandle ah = new accountHandle();
				success = ah.create(username);
				ah = new accountHandle(username);
				if(success)
				{
					marketAccountHandle mh = new marketAccountHandle();
					success = mh.create(ah.id);
				}
			}

			this.closeConnection();

			return success;

		}catch(Exception e){System.out.println(e);}

		return false;
	}

	public ArrayList<profileHandle> getAll()
	{
		ArrayList<profileHandle> phList = new ArrayList<profileHandle>();
		try
		{
			this.openConnection();
			Statement stmt = this.con.createStatement();
			String query = "SELECT tax_id FROM customer_profile";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				profileHandle handle = new profileHandle(rs.getInt("tax_id"));
				phList.add(handle);
			}

			return phList;

		}catch(Exception e){System.out.println(e);}

		return phList;
	}

	public void getSubAccounts()
	{
		try
		{
			this.openConnection();
			Statement stmt = this.con.createStatement();
			String query = "SELECT market_account.a_id FROM market_account INNER JOIN account ON account.a_id = market_account.a_id WHERE account.owner='"+this.username+"'";
			ResultSet rs = stmt.executeQuery(query);	
			while(rs.next())
			{
				marketAccountHandle mh = new marketAccountHandle(rs.getInt("a_id"));
				this.marketAccountList.add(mh);
			}

			stmt = this.con.createStatement();
			query = "SELECT stock_account.a_id FROM stock_account INNER JOIN account ON account.a_id = stock_account.master_id WHERE account.owner='"+this.username+"'";
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				stockAccountHandle sh = new stockAccountHandle(rs.getInt("a_id"));
				this.stockAccountList.add(sh);
			}
		}catch(Exception e){System.out.println(e);}
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