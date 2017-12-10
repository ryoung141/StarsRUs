

import java.sql.*;

public class contract extends item
{
	public int a_id;
	public int year_released;
	public int total_value;
	public String role;
	public String title;

	public contract(int id)
	{
		super();
		try
		{
			String query = "SELECT * FROM movie_contract WHERE m_id="+id;
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next())
			{
				this.id = id;
				this.a_id = rs.getInt("a_id");
				this.year_released = rs.getInt("year_released");
				this.total_value = rs.getInt("total_value");
				this.role = rs.getString("role");
				this.title = rs.getString("movie_title");
			}
			this.closeConnection();

		}catch(Exception e){System.out.println(e);}
	}
}