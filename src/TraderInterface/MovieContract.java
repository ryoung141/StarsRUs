public class MovieContract {
	public String signedBy;
	public String movieTitle;
	public String role;
	public int year;
	public double totalValue;

	public MovieContract(String signedBy, String movieTitle, String role, int year, double totalValue){
		this.signedBy = signedBy;
		this.movieTitle = movieTitle;
		this.role = role;
		this.year = year;
		this.totalValue = totalValue;
	}

}