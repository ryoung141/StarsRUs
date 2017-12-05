

import java.sql.*;

public class marketAccountHandle extends accountHandle
{
	int balance;

	public marketAccountHandle(int id)
	{
		try
		{
			this.openConnection();
			String query = "SELECT balance FROM market_account WHERE a_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.balance = rs.getInt("balance");
				this.id = id;
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public boolean makeDeposit(int amount)
	{
		try
		{
			this.openConnection();
			String query = "INSERT INTO depost(amount) VALUES ("+amount+")";
			Statment stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				continue;
			}
			else
			{
				break;
			}

			String query = ""

			this.closeConnection();
		}catch(Exception e){System.out.println(e);}

		return false;
	}
}