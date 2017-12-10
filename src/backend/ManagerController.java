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

	public ArrayList<String> getActiveCustomers()
	{
		accountHandle ah = new accountHandle();

		return ah.getActiveCustomers();
	}
}