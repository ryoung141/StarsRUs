import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Person {
	private String stockSymbol;
	private String name;
	private String dateOfBirth;
	private ArrayList<MovieContract> movieContracts;

	public Person(String stockSymbol, String name, String dob){

		this.stockSymbol = stockSymbol;
		this.name = name;
		this.dateOfBirth = dob;
		this.movieContracts = getMovieContracts();
	}

	public void setStockSymbol(String stockSymbol){
		this.stockSymbol = stockSymbol;
	}

	public String getStockSymbol(){
		return this.stockSymbol;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setDateOfBirth(String dob){
		this.dateOfBirth = dob;
	}

	public String getDateOfBirth(){
		return this.dateOfBirth;
	}

	public void setMovieContracts(ArrayList<MovieContract> movieContracts){
		this.movieContracts = movieContracts;
	}

	public ArrayList<MovieContract> getMovieContracts(){
		//TODO: Implement 
		ArrayList<MovieContract> mc = new ArrayList<MovieContract>();
		if(TraderInterfacePanel.movieContractsMap != null ){
			mc = TraderInterfacePanel.movieContractsMap.get(this.name);
		}
		return mc;
	}
}