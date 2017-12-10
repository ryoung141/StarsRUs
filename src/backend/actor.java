import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class actor extends item
{
	int s_id;
	public String date_of_birth;
	public String firstname;
	public String lastname;
	public String stock_symbol;

	public actor(int id)
	{
		super();
		try
		{
			String query = "SELECT * FROM actor INNER JOIN stock ON stock.a_id = actor.a_id WHERE actor.a_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = rs.getInt("a_id");
				this.s_id = rs.getInt("s_id");
				this.date_of_birth = rs.getString("date_of_birth");
				this.firstname = rs.getString("firstname");
				this.lastname = rs.getString("lastname");
				this.stock_symbol = rs.getString("symbol");
			}

		}catch(Exception e){System.out.println(e);}
	}

	public actor(String symbol)
	{
		super();
		try
		{
			String query = "SELECT * FROM actor INNER JOIN stock ON stock.a_id = actor.a_id WHERE stock.symbol='"+symbol+"'";
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = rs.getInt("a_id");
				this.s_id = rs.getInt("s_id");
				this.date_of_birth = rs.getString("date_of_birth");
				this.firstname = rs.getString("firstname");
				this.lastname = rs.getString("lastname");
				this.stock_symbol = rs.getString("symbol");
			}

		}catch(Exception e){System.out.println(e);}
	}

	public ArrayList<contract> getAllMovieContracts()
	{
		ArrayList<contract> cList = new ArrayList<contract>();

		try
		{
			this.openConnection();

			String query = "SELECT m_id FROM movie_contract WHERE a_id = "+this.id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				contract c = new contract(rs.getInt("m_id"));
				cList.add(c);
			}
			this.closeConnection();

			return cList;

		}catch(Exception e){System.out.println(e+" LINE 74 OF actor.java");}

		return cList;
	}
}