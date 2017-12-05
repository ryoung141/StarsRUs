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
		return this.ph.auth;
	}

	public boolean createUser(String firstname, String lastname, String phonenumber, String email, int taxID, String username, String password, String state)
	{
		this.ph = new profileHandle();
		boolean ret = ph.create(firstname, lastname, phonenumber, email, taxID, username, password, state);
		if(ret)
		{
			
		}

		return ret;
	}

	public int getID()
	{
		return this.ph.id;
	}

	public String getUsername()
	{
		return this.ph.username;
	}

}

