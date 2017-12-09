import java.sql.*;

public class accrual extends transaction
{
    double rate;
    double avg_daily_balance;

    public accrual()
    {
        super();
    }

    public accrual(int id)
    {
        super();
        try
        {
        String query = "SELECT rate, avg_daily_balance FROM accrue_interest WHERE t_id="+id;
        Statement stmt = this.con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if(rs.next())
        {
        this.id = id;
        this.rate = rs.getDouble("rate");
        this.avg_daily_balance = rs.getDouble("avg_daily_balance");
        }
        this.closeConnection();

        }catch(Exception e){System.out.println(e);}
    }
}
