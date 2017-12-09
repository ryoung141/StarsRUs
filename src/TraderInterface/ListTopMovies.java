import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;


public class ListTopMovies {

	private String userInput;
	private Scanner scan;

	public ArrayList<String> movieList = new ArrayList<String>();

	public ListTopMovies(){

		movieList.add("Lord of the flies");
		movieList.add("Batman ");
		movieList.add("Kingsman ");
		movieList.add("Avengers ");
		movieList.add("JK FIlms the movie");
		movieList.add("Kenn is vietnamese III");

		print("\n---------------Top Movies List-------------------\n");
		listTopMovies();
		return;
	}

	public void listTopMovies(){

		String leftAlignFormat = "| %-42s |%n";

		System.out.format("+--------------------------------------------+%n");
		System.out.format("| Movie Title                                |%n");
		System.out.format("+--------------------------------------------+%n");
		
		//movieList = getTopMovies();

		for(String m: movieList){
			System.out.format(leftAlignFormat, m);
		}


		System.out.format("+--------------------------------------------+%n");
	}

	public ArrayList<String> getTopMovies() {
		return new ArrayList<String>();
	}

	public static void print(String p){
		System.out.println(p);
	}
}