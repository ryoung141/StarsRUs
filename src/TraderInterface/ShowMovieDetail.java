import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Map;

public class ShowMovieDetail {

	private String userInput;
	private Scanner scan;

	private String m;
	private Movie movie;

	public ShowMovieDetail() {

		print("\n--------------Movie Detail----------------\n");
		print("What movie would you like to view? Format: movie title");
		getUserInput();
		showMovieDetail(userInput);
		return;
	}

	public Movie getMovie(String movieTitle){
		Movie mov = new Movie("Lord of the Flies", 2002);
		return mov;
	}

	public void showMovieDetail(String movieTitle){
		movie = getMovie(movieTitle);
		print("");
		print("Movie Title    : " + movie.movieTitle);
		print("Production year: "  + Integer.toString(movie.productionYear));
		print("Movie Reviews  : ");
		for (Map.Entry<String, String> e: movie.reviews.entrySet()) {
			String author = e.getKey();
			String review = e.getValue();
		       	print("   " + author + " - " + review);	
		}
		print("Movie Ranking  : ");
		for (Map.Entry<String, Double> e: movie.rankings.entrySet()) {
                        String author = e.getKey();
                        Double rating = e.getValue();
                        print("   " + author + " - " + Double.toString(rating));
                }

	}

	public void getUserInput() {
		scan = new Scanner(System.in);
		System.out.print("\nInput: ");
		userInput = scan.next();
	}

	public static void print(String p){
		System.out.println(p);
	}
}
