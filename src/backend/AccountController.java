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

	public String getOwner()
	{
		return this.ph.username;
	}



}