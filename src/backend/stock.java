
import java.sql.*;


public class stock extends item
{
	int a_id;
	int closing_price;
	int current_price;
	boolean active;
	String stock_symbol;

	public stock(int id)
	{
		super();
		try
		{
			this.openConnection();
			String query = "SELECT * FROM stock WHERE s_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = id;
				this.a_id = rs.getInt("a_id");
				this.closing_price = rs.getInt("closing_price");
				this.current_price = rs.getInt("current_price");
				this.stock_symbol = rs.getString("symbol");
				if(rs.getString("active").equals("1"))
				{
					this.active = true;
				}
				else
				{
					this.active = false;
				}
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}

	public stock(String symbol)
	{
		super();
		try
		{
			this.openConnection();
			String query = "SELECT * FROM stock WHERE symbol='"+symbol+"'";
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = rs.getInt("s_id");
				this.a_id = rs.getInt("a_id");
				this.closing_price = rs.getInt("closing_price");
				this.current_price = rs.getInt("current_price");
				this.stock_symbol = symbol;
				if(rs.getString("active") == "1")
				{
					this.active = true;
				}
				else
				{
					this.active = false;
				}
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}
}

