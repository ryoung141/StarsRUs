import java.util.List;
import java.util.ArrayList;

public class Controller
{
	public Controller()
	{

	}

	public static void main(String[] args)
	{
		//get all customers
		//print market balance
		//print all stock accts balance
		AccountController ac = new AccountController();
		List<profileHandle> ph = ac.getCustomers();

		for(profileHandle p : ph)
		{
			System.out.println(p.username);
			p.getSubAccounts();
			for(marketAccountHandle mh: p.marketAccountList)
			{
				System.out.println(mh.balance);
			}
			for(stockAccountHandle sh: p.stockAccountList)
			{
				System.out.println(sh.balance);
			}
		}


		
	}
}