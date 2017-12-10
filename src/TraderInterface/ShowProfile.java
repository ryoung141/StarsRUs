import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class ShowProfile {

	private String userInput;
	private Scanner scan;

	private String stockSymbol;
	private actor person;

	public ShowProfile() {

		print("\n--------------Stock Profile----------------\n");
		print("What stock profile would you like to view? Format: Stock symbol");
		getUserInput_stockSymbol();
		this.stockSymbol = userInput.toUpperCase();
		showProfile();
		return;
	}

	public String getPersonProfile(){
		ActorController ac = new ActorController();
		actor a = ac.getActor(this.stockSymbol);

		this.person = a;

		return ac.getActorName();
	}

	public void showProfile(){
		String name = getPersonProfile();
		print("");
		print("Stock Symbol  : " + person.stock_symbol);
		print("Name          : " + name);
		print("Date of Birth : " + person.date_of_birth);
		print("Movie Contracts:");
		listMovieContracts();
	}

	public void listMovieContracts() {
		String leftAlignFormat = "| %-16s | %-16s | %-18s | %-4s | %-11s |%n";

		System.out.format("+------------------+------------------+--------------------+------+-------------+%n");
		System.out.format("| Signed By        | Movie Title      | Role               | Year | Total Value |%n");
		System.out.format("+------------------+------------------+--------------------+------+-------------+%n");
		
		ActorController ac = new ActorController(this.person.id);
		ArrayList<contract> cList = ac.getAllContracts();

		for(contract c: cList)
		{
			System.out.format(leftAlignFormat, ac.getActorName(), c.title, c.role, Integer.toString(c.year_released), Integer.toString(c.total_value));
		}

		System.out.format("+------------------+------------------+--------------------+------+-------------+%n");
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