
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TraderInterfacePanel extends JPanel{
	//Define components
	public static JPanel accManagerPanel;
	public static JPanel stockManagerPanel;

	public static SampleData sampleData = new SampleData();

	//Sample
	public static MovieContract movieContract1 = new MovieContract("Jordan Ang", "Batman", "Actor", 1998, 232223.22);
	public static MovieContract movieContract2 = new MovieContract("Jordan Ang", "Transformers", "Director", 2001, 4334.22);
	public static MovieContract movieContract3 = new MovieContract("Jordan Ang", "Kingsman", "Actor and Director", 2017, 323.22);
	public static MovieContract movieContract4 = new MovieContract("Jordan Ang", "Spiderman", "Director", 2013, 3232.22);
	public static MovieContract movieContract5 = new MovieContract("Jordan Ang", "Wreck it Ralph", "Actor", 2045, 32222.22);
	public static MovieContract movieContract6 = new MovieContract("John Harm", "Batman", "Actor and Director", 1998, 11111.22);
	public static MovieContract movieContract7 = new MovieContract("John Harm", "Eagels Fly", "Director", 1997, 44323.22);
	public static MovieContract movieContract8 = new MovieContract("Kenn Huynh", "Homerun Home", "Actor", 2005, 22123.22);
	public static MovieContract movieContract9 = new MovieContract("Kenn Huynh", "Hillys", "Actor", 2006, 3324.22);
	public static MovieContract movieContract10 = new MovieContract("Kenn Huynh", "Stranger Things", "Director", 2003, 54.22);
	public static MovieContract movieContract11 = new MovieContract("Kenn Huynh", "Comical Laughter", "Actor and Director", 2002, 11234.22);
	public static MovieContract movieContract12 = new MovieContract("Kenn Huynh", "Do it once", "Director", 2001, 3232.22);
	public static MovieContract movieContract13 = new MovieContract("Fomo Eagel", "Wrangler", "Actor and Director", 2003, 44.22);
	public static MovieContract movieContract14 = new MovieContract("Fomo Eagel", "Muppets", "Actor and Director", 2004, 22.22);
	
	public static ArrayList<MovieContract> jordanMovieContract = new ArrayList<MovieContract>();
	public static ArrayList<MovieContract> johnMovieContract = new ArrayList<MovieContract>();
	public static ArrayList<MovieContract> kennMovieContract = new ArrayList<MovieContract>();
	public static ArrayList<MovieContract> kallMovieContract = new ArrayList<MovieContract>();
	public static ArrayList<MovieContract> fomoMovieContract = new ArrayList<MovieContract>();
	public static ArrayList<MovieContract> morealMovieContract = new ArrayList<MovieContract>();
	public static ArrayList<MovieContract> tomMovieContract = new ArrayList<MovieContract>();
	public static HashMap<String, ArrayList<MovieContract>> movieContractsMap = new HashMap<String, ArrayList<MovieContract>>();


	public TraderInterfacePanel() {
		//Sample
		jordanMovieContract.add(movieContract1);
		jordanMovieContract.add(movieContract2);
		jordanMovieContract.add(movieContract3);
		jordanMovieContract.add(movieContract4);
		jordanMovieContract.add(movieContract5);
		johnMovieContract.add(movieContract6);
		johnMovieContract.add(movieContract7);
		kennMovieContract.add(movieContract8);
		kennMovieContract.add(movieContract9);
		kennMovieContract.add(movieContract10);
		kennMovieContract.add(movieContract11);
		kennMovieContract.add(movieContract12);
		fomoMovieContract.add(movieContract13);
		fomoMovieContract.add(movieContract14);

		movieContractsMap.put("Jordan Ang", jordanMovieContract);
		movieContractsMap.put("John Harm", johnMovieContract);
		movieContractsMap.put("Kenn Huynh", kennMovieContract);
		movieContractsMap.put("Kall Allen", kallMovieContract);
		movieContractsMap.put("Fomo Eagel", fomoMovieContract);
		movieContractsMap.put("Moreal Nguyen", morealMovieContract);
		movieContractsMap.put("Tom Uynh", tomMovieContract);

		//JPanel characteristics
		this.setLayout(new GridLayout(1,2));

		//Define different panels
		accManagerPanel = new AccManagerPanel();

		stockManagerPanel = new StockManagerPanel();

		//Add components
		this.add(accManagerPanel);
		this.add(stockManagerPanel);
		
	}	
}