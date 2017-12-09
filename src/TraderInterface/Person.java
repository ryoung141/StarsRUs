import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Person {
	public String stockSymbol;
	public String name;
	public String dateOfBirth;
	private ArrayList<MovieContract> movieContracts;

	public Person(String stockSymbol, String name, String dob){

		this.stockSymbol = stockSymbol;
		this.name = name;
		this.dateOfBirth = dob;
		this.movieContracts = getMovieContracts();
	}

	public ArrayList<MovieContract> getMovieContracts(){
		//TODO: Implement 
		ArrayList<MovieContract> mc = new ArrayList<MovieContract>();
		return mc;
	}

	public void listMovieContracts() {
		String leftAlignFormat = "| %-16s | %-16s | %-18s | %-4s | %-11s |%n";

		System.out.format("+------------------+------------------+--------------------+------+-------------+%n");
		System.out.format("| Signed By        | Movie Title      | Role               | Year | Total Value |%n");
		System.out.format("+------------------+------------------+--------------------+------+-------------+%n");
		
		//transactionList = getTransaction();

		for (MovieContract mc : TraderInterface.jordanMovieContract) {
			System.out.format(leftAlignFormat, mc.signedBy, mc.movieTitle, mc.role, Integer.toString(mc.year), Double.toString(mc.totalValue));
		}


		System.out.format("+------------------+------------------+--------------------+------+-------------+%n");
	}
}