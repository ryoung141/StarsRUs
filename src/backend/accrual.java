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
        super();
        try
        {
        String query = "SELECT rate, amount FROM accrue_interest WHERE t_id="+id;
        Statement stmt = this.con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if(rs.next())
        {
        this.id = id;
        this.rate = rs.getDouble("rate");
        this.amount = rs.getDouble("amount");
        }
        this.closeConnection();

        }catch(Exception e){System.out.println(e);}
    }
}
