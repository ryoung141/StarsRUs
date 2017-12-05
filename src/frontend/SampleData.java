import java.util.ArrayList;
import java.util.HashMap;

public class SampleData{
	public static Stock stock1 = new Stock("JOA", "Jordan Ang", 1234.22, 3230.14);
	public static Stock stock2 = new Stock("JOH", "John Harm", 3032.22, 10.20);
	public static Stock stock3 = new Stock("KEN", "Kenn Huynh", 55.32, 2022.12);
	public static Stock stock4 = new Stock("KAL", "Kall Allen", 3551.32, 253.12);
	public static Stock stock5 = new Stock("FRE", "Fomo Eagel", 6533.32, 755.12);
	public static Stock stock6 = new Stock("MON", "Moreal Nguyen", 655.32, 85.12);
	public static Stock stock7 = new Stock("TOU", "Tom Uynh", 557.32, 43.12);

	public static Person person1 = new Person("JOA", "Jordan Ang", "08-30-1996");
	public static Person person2 = new Person("JOH", "John Harm", "02-22-2000");
	public static Person person3 = new Person("KEN", "Kenn Huynh", "01-11-1999");
	public static Person person4 = new Person("KAL", "Kall Allen", "04-44-1993");
	public static Person person5 = new Person("FRE", "Fomo Eagel", "06-63-1976");
	public static Person person6 = new Person("MON", "Moreal Nguyen", "07-77-1936");
	public static Person person7 = new Person("TOU", "Tom Uynh", "11-11-1956");

	public static HashMap<String, Person> personMap = new HashMap<String, Person>();

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

	public SampleData(){
		personMap.put("JOA", person1);
		personMap.put("JOH", person2);
		personMap.put("KEN", person3);
		personMap.put("KAL", person4);
		personMap.put("FRE", person5);
		personMap.put("MON", person6);
		personMap.put("TOU", person7);

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

	return;
	}
}