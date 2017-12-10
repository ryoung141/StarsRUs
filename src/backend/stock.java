import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;


public class stock extends item
{
	int a_id;
	double closing_price;
	double current_price;
	boolean active;
	String stock_symbol;

	public stock()
	{
		super();
	}

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
				this.closing_price = rs.getDouble("closing_price");
				this.current_price = rs.getDouble("current_price");
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
				this.closing_price = rs.getDouble("closing_price");
				this.current_price = rs.getDouble("current_price");
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

	public HashMap<String, stock> getAll()
	{
		HashMap<String, stock> hm = new HashMap<String, stock>();

		try
		{
			this.openConnection();
			String query = "SELECT stock.s_id, actor.firstname, actor.lastname FROM stock INNER JOIN actor ON actor.s_id = stock.s_id";
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				stock s = new stock(rs.getInt("s_id"));
				String name = rs.getString("firstname")+" "+rs.getString("lastname");
				hm.put(name, s);
			}
			this.closeConnection();

			return hm;

		}catch(Exception e){System.out.println(e);}

		return hm;
	}

	public void setStockPrice(double price)
	{
		try
		{
			this.openConnection();
			String query = "UPDATE stock SET current_price="+price+" WHERE s_id="+this.id;
			Statement stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);

			this.closeConnection();
		}catch(Exception e){System.out.println(e);}
	}

	public double getCurrentPrice()
	{
		return this.current_price;
	}
}

