import java.sql.*;

public class accrual extends transaction
{
    public static double rate;
    public double amount;
    

    public accrual()
    {
        super();
    }

    public accrual(int id)
    {
        super(id);
        try
        {
        String query = "SELECT amount FROM accrue_interest WHERE t_id="+id;
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
