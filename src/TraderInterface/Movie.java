import java.util.HashMap;
import java.util.ArrayList;

public class Movie{
	
	public String movieTitle;
	public int productionYear;
	public HashMap<String, String> reviews;
	public HashMap<String, Double> rankings;

	public Movie(String movieTitle, int productionYear){
		this.movieTitle = movieTitle;
		this.productionYear = productionYear;
		this.reviews = getReviews();
		this.rankings = getRankings();
		return;
	}

	public HashMap<String, String> getReviews() {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("Clinton", "Very Good");
		m.put("Bush", "Good");
		m.put("Bill", "Not so good");

		return m;
	}

	public HashMap<String, Double> getRankings() {
		HashMap<String, Double> m = new HashMap<String, Double>();
		m.put("Hollywood", 4.0);
		m.put("IMDB", 7.6);
		m.put("Reddit", 11.0);
		return m;
	}


}
