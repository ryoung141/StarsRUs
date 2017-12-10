

import java.sql.*;

public class withdrawal extends transaction
{
	public double amount;

	public withdrawal()
	{
		super();
	}

	public withdrawal(int id)
	{
		super();
		try
		{
			String query = "SELECT amount FROM withdrawal WHERE t_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = id;
				this.amount = rs.getDouble("amount");
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}
}