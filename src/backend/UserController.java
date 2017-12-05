public class UserController extends Controller
{
	profileHandle ph;

	public UserController()
	{
		super();
	}

	public boolean authenticateUser(String username, String password)
	{
		this.ph = new profileHandle(username, password);
		if(this.ph.auth = false)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public boolean createUser(String firstname, String lastname, String phonenumber, String email, int taxID, String username, String password, String state)
	{
		profileHandle ph = new profileHandle();
		ph.create(firstname, lastname, phonenumber, email, taxID, username, password, state);
		
	}

}

