

import java.sql.*;

public class buy extends transaction
{
	int s_id;
	double amount;
	double price;

	public buy()
	{
		super();
	}

	public buy(int id)
	{
		super();
		try
		{
			String query = "SELECT s_id, amount FROM buy WHERE t_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = id;
				this.s_id = rs.getInt("s_id");
				this.amount = rs.getDouble("amount");
				this.price = rs.getDouble("price");
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}
}