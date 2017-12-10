import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagerController extends Controller
{

	public ManagerController()
	{
		super();
	}

	public boolean DeleteTransactions()
	{
		transaction t = new transaction();

		boolean ret = t.clearAllTransactions();

		return ret;
	}

	public HashMap<profileHandle, String> getDTER()
	{
		accountHandle ah = new accountHandle();

		HashMap<profileHandle, String> hm = ah.getDTER();
		
		return hm;
	}

	public ArrayList<String> getActiveCustomers()
	{
		accountHandle ah = new accountHandle();

		return ah.getActiveCustomers();
	}

	public ArrayList<profileHandle> getCustomers()
	{
		profileHandle ph = new profileHandle();

		// ArrayList<String> cusList = new ArrayList<String>();
		ArrayList<profileHandle> phList = new ArrayList<profileHandle>();

		phList = ph.getAll();

		/*for(profileHandle p: phList)
		{
			cusList.add(p.firstname+" "+p.lastname);
		}*/

		return phList;
	}

	public void setStockPrice(String symbol, double price)
	{
		stock s = new stock(symbol);

		s.setStockPrice(price);
	}

}
