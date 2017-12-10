import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class accountHandle extends item
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
				this.id = id;
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
			String query = "SELECT a_id FROM account WHERE owner='"+owner+"'";
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.owner = owner;
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

	public marketAccountHandle getMarketAccount()
	{
		return new marketAccountHandle(this.id);
	}

	public stockAccountHandle getStockAccounts()
	{
		stockAccountHandle sh = new stockAccountHandle();
		sh.getStockAccounts(this.id);

		return sh;
	}

	public boolean create(String owner)
	{
		try
		{
			this.openConnection();
			Statement stmt = this.con.createStatement();
			String query = "INSERT INTO account(owner) VALUES ('"+owner+"')";
			int rs = stmt.executeUpdate(query);

			this.closeConnection();
			if(rs > 0)
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

	public ArrayList<String> getActiveCustomers()
	{
		ArrayList<String> activeList = new ArrayList<String>();

		try
		{
			this.openConnection();
			String query = "SELECT firstname, lastname FROM customer_profile INNER JOIN (SELECT temp2.owner FROM (SELECT temp.owner, SUM(temp.sell) sales, SUM(temp.buy) purchases FROM (SELECT a.owner, t.t_id, b.amount buy, s.amount sell FROM account a LEFT JOIN transactions t ON t.a_id=a.a_id LEFT JOIN buy b ON b.t_id = t.t_id LEFT JOIN sell s ON s.t_id = t.t_id WHERE t.t_id IS NOT NULL AND (b.amount IS NOT NULL OR s.amount IS NOT NULL)) temp GROUP BY temp.owner) temp2 WHERE temp2.sales+temp2.purchases > 1000 GROUP BY temp2.owner) temp3 on temp3.owner = customer_profile.username";
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				activeList.add(rs.getString("firstname")+" "+rs.getString("lastname"));
			}

			this.closeConnection();

		}catch(Exception e){System.out.println(e);}

		return activeList;
	}

	public String getOwner()
	{
		return this.owner;
	}

}
