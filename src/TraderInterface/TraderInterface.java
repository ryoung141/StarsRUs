import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.*;
import java.util.ArrayList;

public class TraderInterface{

	public static boolean open = true;
	public static boolean loggedIn = false;

	public static  String userInput = "";
	public static  int chosenOption = -1;
	public static  int minInput = -1;
	public static  int maxInput = -1;

	public static HashMap<Integer, String> options;
	public static HashMap<Integer, String> loggedInOptions;

	public static Scanner scan;

	public static MovieContract movieContract1 = new MovieContract("Jordan Ang", "Batman", "Actor", 1998, 232223.22);
	public static MovieContract movieContract2 = new MovieContract("Jordan Ang", "Transformers", "Director", 2001, 4334.22);
	public static MovieContract movieContract3 = new MovieContract("Jordan Ang", "Kingsman", "Actor and Director", 2017, 323.22);
	public static MovieContract movieContract4 = new MovieContract("Jordan Ang", "Spiderman", "Director", 2013, 3232.22);
	public static MovieContract movieContract5 = new MovieContract("Jordan Ang", "Wreck it Ralph", "Actor", 2045, 32222.22);

	public static ArrayList<MovieContract> jordanMovieContract = new ArrayList<MovieContract>();

	public static String username;
	public static String password;

	public static void main(String[] arg){

		//Sample Data
		jordanMovieContract.add(movieContract1);
		jordanMovieContract.add(movieContract2);
		jordanMovieContract.add(movieContract3);
		jordanMovieContract.add(movieContract4);
		jordanMovieContract.add(movieContract5);

		//Main menu settings
		options = new HashMap<Integer, String>(); 
		options.put(1, "Login");
		options.put(2, "Create an account");
		options.put(3, "Exit");

		//Logged in settings
		loggedInOptions = new HashMap<Integer, String>();
		loggedInOptions.put(1, "Deposit");
		loggedInOptions.put(2, "Withdraw");
		loggedInOptions.put(3, "Buy");
		loggedInOptions.put(4, "Sell");
		loggedInOptions.put(5, "Show market account balance");
		loggedInOptions.put(6, "Show transaction history");
		loggedInOptions.put(7, "List stocks");
		loggedInOptions.put(8, "View actor/director profile");
		loggedInOptions.put(9, "Movies");
		loggedInOptions.put(10, "Log out");

		//Begin
		print("\n--------Welcome to the Trader Interface--------");

		while(open == true) {
			start();
			while(loggedIn == true) {
				showInterface();
			}
		}

		print("Goodbye");
	}

	public static void start(){
		print("\n-----MAIN MENU-----");
		print("Choose an option below");

		minInput = 1;
		maxInput = 3;

		for (int i=minInput; i<=maxInput; i++) {
			String key = Integer.toString(i);
			String val = options.get(i);
			print(key + ". " + val);
		}

		getUserInput(minInput, maxInput);

		switch(chosenOption) {
			case 1: Login l = new Login(); //done
				break;
			case 2: CreateAccount gms = new CreateAccount(); //done
				break;
			case 3: open = false;
				break;
		}

		return;
	}

	public static void showInterface() {
		print("\n-----TRADER MAIN MENU-----");
		print("Choose an option below");

		minInput = 1;
		maxInput = 10;

		for (int i=minInput; i<=maxInput; i++) {
			String key = Integer.toString(i);
			String val = loggedInOptions.get(i);
			print(key + ". " + val);
		}

		getUserInput(minInput, maxInput);

		switch(chosenOption) {
			case 1: Deposit d = new Deposit(); //done
				break;
			case 2: Withdraw w = new Withdraw(); //done
				break;
			case 3: Buy b = new Buy(); //done
				break;
			case 4: Sell s = new Sell(); //done
				break;
			case 5: ShowBalance sb = new ShowBalance(); //done
				break;
			case 6: ShowHistory sh = new ShowHistory(); //done
				break;
			case 7: ListStocks ls = new ListStocks(); //done
				break;
			case 8: ShowProfile sp = new ShowProfile(); //done
				break;
			case 9: MoviesOption lm = new MoviesOption();
				break;
			case 10: loggedIn = false;
				break;
		}

		return;
	}

	public static void print(String p){
		System.out.println(p);
	}

	public static boolean verifyInput(String input) {
		String regex = "^[0-9][0-9]?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static void getUserInput(int min, int max) {
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