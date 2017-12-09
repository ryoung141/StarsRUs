import java.util.List;
import java.util.ArrayList;

public class AccountController extends Controller
{
	public profileHandle ph;
	public accountHandle ah;

	public AccountController()
	{
		super();
		this.ph = new profileHandle();
		this.ah = new accountHandle();
	}

	public AccountController(int id)
	{
		super();
		this.ph = new profileHandle(id);
		this.ah = new accountHandle(ph.username);
	}

	public List<profileHandle> getCustomers()
	{
		return this.getHandle().getAll();
	}

	public List<stock> getStocksOwned(int account_id)
	{
		stockAccountHandle sh = new stockAccountHandle();
		sh.getStockAccounts(account_id);

		List<stockAccountHandle> stockAcctList = sh.accountList;

		List<stock> ret = new ArrayList<stock>();

		for (stockAccountHandle acct: stockAcctList)
		{
			ret.add(acct.getStock(acct.s_id));
		}

		return ret;
	}

	public double getBalance()
	{
		accountHandle ah = new accountHandle(this.getOwner());
		marketAccountHandle mh = ah.getMarketAccount();

		return mh.getBalance();
	}

	public boolean makeDeposit(double amount)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		marketAccountHandle mh = ah.getMarketAccount();

		return mh.makeDeposit(amount);
	}

	public boolean makeWithdrawal(double amount)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		marketAccountHandle mh = ah.getMarketAccount();

		if(mh.validateBalance(amount))
		{
			return mh.makeWithdrawal(amount);
		}
		else
		{
			return false;
		}
	}

	public boolean buyStock(String symbol, double amount)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		stock s = new stock(symbol);
		double price = s.getCurrentPrice();
		double withdraw = price * amount;

		boolean success = false;

		marketAccountHandle mh = ah.getMarketAccount();
		if(mh.validateBalance(withdraw))
		{
			stockAccountHandle sh = ah.getStockAccounts();
			stockAccountHandle sh1 = sh.getHandle(s.id);
			if(!sh1.equals(null))
			{
				sh1.makePurchase(amount, price);
			}
			else
			{
				sh1 = new stockAccountHandle();
				success = sh1.create(ah.id, s.id);
				if(success)
				{
					sh = ah.getStockAccounts();
					sh1 = sh.getHandle(s.id);
					success = sh1.makePurchase(amount, price);
				}
			}

			if(success)
			{
				success = makeWithdrawal(withdraw);
			}
		}

		return success;
	}

	public boolean sellStock(int s_id, double count)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		stock s = new stock(s_id);
		double price = s.getCurrentPrice();
		double deposit = price * count;
		boolean success = false;

		stockAccountHandle sh = ah.getStockAccounts();
		stockAccountHandle sh1 = sh.getHandle(s_id);
		if(!sh1.equals(null))
		{
			success = sh1.makeSale(count, price);
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

	public profileHandle getHandle()
	{
		return this.ph;
	}



}