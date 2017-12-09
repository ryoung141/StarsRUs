import java.util.HashMap;
import java.util.ArrayList;

public class Movie{
	
	public String movieTitle;
	public int productionYear;
	public HashMap<String, String> reviews;
	public HashMap<String, Double> rankings;

	public Movie(String movieTitle, int productionYear, HashMap<String, String> reviews, HashMap<String, Double> rankings){
		this.movieTitle = movieTitle;
		this.productionYear = productionYear;
		this.reviews = reviews;
		this.rankings = rankings;
		return;
	}

}