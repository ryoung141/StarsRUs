

import java.sql.*;

public class sell extends transaction
{
	int s_id;
	double amount;
	double price;

	public sell()
	{
		super();
	}

	public sell(int id)
	{
		super();
		try
		{
			String query = "SELECT s_id, amount FROM sell WHERE t_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = id;
				this.s_id = rs.getInt("s_id");
				this.amount = rs.getDouble("amount");
				this.amount = rs.getDouble("price");
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}
}