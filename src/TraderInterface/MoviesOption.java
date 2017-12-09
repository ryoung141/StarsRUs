import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.*;
import java.util.ArrayList;

public class MoviesOption {

	private int chosenOption = -1;
	private String userInput = "";
	private int minInput = -1;
	private int maxInput = -1;
	private boolean open = true;
	private Scanner scan;

	public static HashMap<Integer, String> options;

	public MoviesOption() {
		options = new HashMap<Integer, String>(); 
		options.put(1, "Show movie details");
		options.put(2, "List all movies");
		options.put(3, "List top movies");
		options.put(4, "List movie reviews");
		options.put(5, "Back to Main Menu");


		while(open == true) {
			start();
		}

		return;
	}

	public void start() {
		print("\n----------------------MOVIES MENU---------------------");
		print("Choose an option below");

		minInput = 1;
		maxInput = 5;

		for (int i=minInput; i<=maxInput; i++) {
			String key = Integer.toString(i);
			String val = options.get(i);
			print(key + ". " + val);
		}

		getUserInput(minInput, maxInput);

		switch(chosenOption) {
			case 1: ShowMovieDetail smd = new ShowMovieDetail();
				break;
			case 2: ListAllMovies lam = new ListAllMovies();
				break;
			case 3: ListTopMovies ltm = new ListTopMovies();
				break;
			case 4: print("List movie reviews clicked");
				break;
			case 5: open = false;
				break;
		}

		return;
	}

	public static void print(String p){
		System.out.println(p);
	}

	public boolean verifyInput(String input) {
		String regex = "^[0-9][0-9]?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public void getUserInput(int min, int max) {
		scan = new Scanner(System.in);
		System.out.print("\nInput: ");
		userInput = scan.next();

		if(!verifyInput(userInput)) {
			print("Error: Invalid input. Please enter an input between " + minInput + " and " + maxInput + ".");
			getUserInput(min, max);
		}

		chosenOption = Integer.parseInt(userInput);

		if(chosenOption < min || chosenOption > max) {
			print("Error: Invalid input. Please enter an input between " + minInput + " and " + maxInput + ".");
			getUserInput(min, max);
		} else {
			return;
		} 
	}
}