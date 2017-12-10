import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

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

	public AccountController(String username, String password)
	{
		super();
		this.ph = new profileHandle(username, password);
		this.ah = new accountHandle(ph.username);
	}

	public List<profileHandle> getCustomers()
	{
		return this.getHandle().getAll();
	}

	public HashMap<String, stock> getStocks()
	{
		stock s = new stock();
		return s.getAll();
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
			try
			{
				stockAccountHandle sh1 = sh.getHandle(s.id);
				success = sh1.makePurchase(amount, price);

			}catch(NullPointerException e)
			{
				stockAccountHandle sh1 = new stockAccountHandle();
				success = sh1.create(ah.id, s.id);
				if(success)
				{
					sh = ah.getStockAccounts();
					sh1 = sh.getHandle(s.id);
					success = sh1.makePurchase(amount, price);
					System.out.println(success+" makepurchase accountcontroller 117");
				}
			}

			if(success)
			{
				success = makeWithdrawal(withdraw);
				System.out.println(success+" makewithdrawal accountcontroller 123");
			}
		}

		return success;
	}

	public boolean sellStock(String symbol, double count)
	{
		accountHandle ah = new accountHandle(this.getOwner());
		stock s = new stock(symbol);
		double price = s.getCurrentPrice();
		double deposit = price * count;
		boolean success = false;

		stockAccountHandle sh = ah.getStockAccounts();
		try
		{
			stockAccountHandle sh1 = sh.getHandle(s.id);
			if(sh1.validateBalance(count))
			{
				success = sh1.makeSale(count, price);
			}
		}catch(NullPointerException e){System.out.println("Error: you don't own that stock!");}

		if(success)
		{
			success = makeDeposit(deposit);
		}

		return success;
	}

	public ArrayList<buy> getAllBuys()
	{
		accountHandle ah = new accountHandle(this.getOwner());
		transaction t = new transaction();
		t.getAllBuys(ah.id);

		ArrayList<buy> b = t.buyList;

		return b;
	}

	public ArrayList<sell> getAllSales()
	{
		accountHandle ah = new accountHandle(this.getOwner());
		transaction t = new transaction();
		t.getAllSells(ah.id);

		ArrayList<sell> s = t.sellList;
		return s;
	}

	public ArrayList<deposit> getAllDeposits()
	{
		accountHandle ah = new accountHandle(this.getOwner());
		transaction t = new transaction();
		t.getAllDeposits(ah.id);

		ArrayList<deposit> d = t.depositList;

		return d;
	}

	public ArrayList<withdrawal> getAllWithdrawals()
	{
		accountHandle ah = new accountHandle(this.getOwner());
		transaction t = new transaction();
		t.getAllWithdrawals(ah.id);

		ArrayList<withdrawal> w = t.withdrawalList;
		return w;
	}

	public ArrayList<accrual> getAllAccruals()
	{
		accountHandle ah = new accountHandle(this.getOwner());
		transaction t = new transaction();
		t.getAllAccruals(ah.id);

		ArrayList<accrual> a = t.accrualList;

		return a;
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