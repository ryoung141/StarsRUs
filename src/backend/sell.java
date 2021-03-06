

import java.sql.*;

public class sell extends transaction
{
	public int s_id;
	public double amount;
	public double price;

	public sell()
	{
		super();
	}

	public sell(int id)
	{
		super(id);
		try
		{
			String query = "SELECT s_id, amount, price FROM sell WHERE t_id="+id;
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

	public String getStock()
	{
		stock s = new stock(this.s_id);
		return s.stock_symbol;
	}
}