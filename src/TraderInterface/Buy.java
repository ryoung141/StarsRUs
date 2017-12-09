import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;


public class Buy {

	private String userInput;
	private Scanner scan;

	private String stockSymbol;
	private int amount;

	public Buy(){
		print("\n-----------------Buy-------------------\n");
		print("What stock would you like to buy? Format: Stock symbol");
		getUserInput_stockSymbol();
		stockSymbol = userInput.toUpperCase();
		print("How much would you like to buy? Format: integer");
		getUserInput_amount();
		amount = Integer.parseInt(userInput);
		buyStock(stockSymbol, amount);
		return;
	}

	public void buyStock(String sym, int amo) {
		print("\n" + Integer.toString(amo) + " " + sym + " has been bought!");
		return;
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

	public boolean verifyAmount(String amount) {
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(amount);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public void getUserInput_amount() {
		scan = new Scanner(System.in);
		System.out.print("\nInput: ");
		userInput = scan.next();

		if(!verifyAmount(userInput)) {
			print("Error: Invalid input. Please enter an appropiate value (format: integer)");
			getUserInput_amount();
		} else {
			return;
		} 
	}

	public static void print(String p){
		System.out.println(p);
	}
}