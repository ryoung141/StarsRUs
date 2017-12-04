package StarsRUSModels;

import java.sql.*;

class marketAccountHandle extends accountHandle
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
}