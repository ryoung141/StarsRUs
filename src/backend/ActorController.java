import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ActorController extends Controller
{
	public int a_id;

	public ActorController()
	{
		super();
	}

	public ActorController(int a_id)
	{
		super();
		this.a_id = a_id;
	}

	public actor getActor(String symbol)
	{
		actor a = new actor(symbol);
		this.a_id = a.id;

		return a;
	}

	public String getActorName()
	{
		actor a = new actor(this.a_id);

		String name = a.firstname+" "+a.lastname;
		return name;
	}

	public ArrayList<contract> getAllContracts()
	{
		actor a = new actor(this.a_id);

		ArrayList<contract> cList = a.getAllMovieContracts();
		return cList;
	}
}