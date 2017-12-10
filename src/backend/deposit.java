
import java.sql.*;

public class deposit extends transaction
{
	public double amount;

	public deposit()
	{
		super();
	}

	public deposit(int id)
	{
		super(id);
		try
		{
			String query = "SELECT amount FROM deposit WHERE t_id="+id;
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
