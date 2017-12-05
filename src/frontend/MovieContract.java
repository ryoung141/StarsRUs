public class MovieContract {
	private String signedBy;
	private String movieTitle;
	private String role;
	private int year;
	private double totalValue;

	public MovieContract(String signedBy, String movieTitle, String role, int year, double totalValue){
		this.signedBy = signedBy;
		this.movieTitle = movieTitle;
		this.role = role;
		this.year = year;
		this.totalValue = totalValue;
	}

	public void setSignedBy(String signedBy){
		this.signedBy = signedBy;
	}

	public String getSignedBy(){
		return this.signedBy;
	}

	public void setMovieTitle(String movieTitle){
		this.movieTitle = movieTitle;
	}

	public String getMovieTitle(){
		return this.movieTitle;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return this.role;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return this.year;
	}

	public void setTotalValue(double totalValue){
		this.totalValue = totalValue;
	}

	public double getTotalValue(){
		return this.totalValue;
	}

}