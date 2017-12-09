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

		System.out.println("-----------------------------------");


		//tests grabbing all stocks for single account
		ac = new AccountController(ph.get(0).id);
		System.out.println(ac.getBalance());
		System.out.println(ac.ph.firstname);

		List<stock> sl = ac.getStocksOwned(ac.ah.id);
		for(stock s: sl)
		{
			System.out.println(s.stock_symbol);
		}

		System.out.println("-----------------------------------");

		System.out.println(ac.makeDeposit(123.00));
		System.out.println(ac.getBalance());
		System.out.println(ac.makeWithdrawal(123.00));
		System.out.println(ac.getBalance());

		/*System.out.println(ac.buyStock("SKB", 10));
		System.out.println()*/


	}
}