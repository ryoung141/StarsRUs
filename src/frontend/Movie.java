import java.util.HashMap;
import java.util.ArrayList;

public class Movie{
	
	private String movieTitle;
	private int productionYear;
	private HashMap<String, String> reviews;
	private HashMap<String, Double> rankings;

	public Movie(String movieTitle, int productionYear, HashMap<String, String> reviews, HashMap<String, Double> rankings){
		this.movieTitle = movieTitle;
		this.productionYear = productionYear;
		this.reviews = reviews;
		this.rankings = rankings;
		return;
	}

	public void setMovieTitle(String movieTitle){
		this.movieTitle = movieTitle;
	}

	public String getMovieTitle(){
		return this.movieTitle;
	}

	public void setProductionYear(int productionYear){
		this.productionYear = productionYear;
	}

	public int getProductionYear(){
		return this.productionYear;
	}

	public void setReviews(HashMap<String, String> reviews){
		this.reviews = reviews;
	}

	public HashMap<String, String> getReviews(){
		return this.reviews;
	}

	public void setRankings(HashMap<String, Double> rankings){
		this.rankings = rankings;
	}

	public HashMap<String, Double> getRankings(){
		return this.rankings;
	}


}