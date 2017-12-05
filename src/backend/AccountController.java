import java.util.List;
import java.util.ArrayList;

public class AccountController extends Controller
{
	public profileHandle ph;

	public AccountController(int id)
	{
		super();
		this.ph = new profileHandle(id);
	}

	public List<stock> getStocksOwned(int account_id)
	{
		stockAccountHandle sh = new stockAccountHandle();
		sh.getStockAccounts(account_id);

		List<stockAccountHandle> stockAcctList = sh.accountList;

		List<stock> ret = new ArrayList<stock>();

		for (stockAccountHandle acct: stockAcctList)
		{
			ret.add(acct.getStock(sh.s_id));
		}

		return ret;
	}

	public int getBalance()
	{
		accountHandle ah = new accountHandle(this.getOwner());
		marketAccountHandle mh = ah.getMarketAccount();
		System.out.println(mh.getBalance());

		return mh.getBalance();
	}

	public boolean makeDeposit(int amount)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		marketAccountHandle mh = ah.getMarketAccount();

		return mh.makeDeposit(amount);
	}

	public boolean makeWithdrawal(int amount)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		marketAccountHandle mh = ah.getMarketAccount();

		return mh.makeWithdrawal(amount);
	}

	public boolean buyStock(int s_id, double count)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		stock s = new stock(s_id);
		double amount = count * s.getCurrentPrice();
		int withdraw = (int) amount;

		boolean success = false;

		stockAccountHandle sh = ah.getStockAccounts();
		stockAccountHandle sh1 = sh.getHandle(s_id);
		if(!sh1.equals(null))
		{
			sh1.makePurchase(count);
		}
		else
		{
			sh1 = new stockAccountHandle();
			success = sh1.create(ah.id, s_id);
			if(success)
			{
				sh = ah.getStockAccounts();
				sh1 = sh.getHandle(s_id);
				success = sh1.makePurchase(amount);
			}
		}

		if(success)
		{
			success = makeWithdrawal(withdraw);
		}

		return success;
	}

	public boolean sellStock(int s_id, double count)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		stock s = new stock(s_id);
		double amount = count * s.getCurrentPrice();
		int deposit = (int) amount;

		boolean success = false;

		stockAccountHandle sh = ah.getStockAccounts();
		stockAccountHandle sh1 = sh.getHandle(s_id);
		if(!sh1.equals(null))
		{
			success = sh1.makeSale(count);
		}

		if(success)
		{
			success = makeDeposit(deposit);
		}

		return success;
	}

	public String getOwner()
	{
		return this.ph.username;
	}



}