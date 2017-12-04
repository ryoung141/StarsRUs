public class Person {
	private String stockSymbol;
	private String name;
	private String dateOfBirth;
	private String[] movieContracts;

	public Person(String stockSymbol, String name, String dob){
		this.stockSymbol = stockSymbol;
		this.name = name;
		this.dateOfBirth = dob;
		getMovieContracts();
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

	public void getMovieContracts(){
		//TODO: Implement contracts
		return;
	}
}