import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class ShowProfile {

	private String userInput;
	private Scanner scan;

	private String stockSymbol;
	private Person person;

	public ShowProfile() {

		print("\n--------------Stock Profile----------------\n");
		print("What stock profile would you like to view? Format: Stock symbol");
		getUserInput_stockSymbol();
		stockSymbol = userInput.toUpperCase();
		showProfile();
		return;
	}

	public Person getPersonProfile(){
		person = new Person("JOA", "Jordan Ang", "08-30-1996");
		return person;
	}

	public void showProfile(){
		getPersonProfile();
		print("");
		print("Stock Symbol  : " + person.stockSymbol);
		print("Name          : " + person.name);
		print("Date of Birth : " + person.dateOfBirth);
		print("Movie Contracts:");
		person.listMovieContracts();
	}

	public boolean verifyStockSymbol(String ss) {
		String regex = "^[a-zA-Z]{3}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(ss);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public void getUserInput_stockSymbol() {
		scan = new Scanner(System.in);
		System.out.print("\nInput: ");
		userInput = scan.next();

		if(!verifyStockSymbol(userInput)) {
			print("Error: Invalid input. Please enter an appropiate value (format: Stock symbole e.g. AAB, CCB)");
			getUserInput_stockSymbol();
		} else {
			return;
		} 
	}

	public static void print(String p){
		System.out.println(p);
	}
}