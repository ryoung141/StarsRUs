package StarsRUSControllers;

import StarsRUSModels.*;
import java.util.List;
import java.util.ArrayList;

class AccountController extends Controller
{
	public AccountController()
	{
		super();
	}

	public List<stock> getStocksOwned(int account_id)
	{
		stockAccountHandle sh = new stockAccountHandle();
		sh.getStockAccounts(account_id);

		stockAcctList = sh.accountList;

		List<stock> ret = new ArrayList<stock>();

		for (stockAccountHandle acct: stockAcctList)
		{
			ret.add(acct.getStock(sh.s_id));
		}

		return ret;
	}

}