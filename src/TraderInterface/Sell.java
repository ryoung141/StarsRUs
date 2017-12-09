import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;


public class Sell {

	private String userInput;
	private Scanner scan;

	private String stockSymbol;
	private int amount;

	public Sell(){
		print("\n-----------------Sell-------------------\n");
		print("What stock would you like to sell? Format: Stock symbol");
		getUserInput_stockSymbol();
		stockSymbol = userInput.toUpperCase();
		print("How much would you like to sell? Format: integer");
		getUserInput_amount();
		amount = Integer.parseInt(userInput);
		sellStock(stockSymbol, amount);
		return;
	}

	public void sellStock(String sym, int amo) {
		AccountController ac = new AccountController(TraderInterface.username, TraderInterface.password);
		if(ac.sellStock(sym, (double) amo))
		{
			print("\n" + Integer.toString(amo) + " " + sym + " has been sold!");
		}
		else
		{
			print("Error: Error on the backend, stock sale was not successful.");
		}
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