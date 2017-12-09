import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

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
		Movie mov = new Movie("Lord of the Flies", 2002, new HashMap<String, String>(), new HashMap<String, Double>());
		return mov;
	}

	public void showMovieDetail(String movieTitle){
		movie = getMovie(movieTitle);
		print("");
		print("Movie Title    : " + movie.movieTitle);
		print("Production year: "  + Integer.toString(movie.productionYear));
		print("Movie Reviews  : ");
		print("Movie Ranking  : ");
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