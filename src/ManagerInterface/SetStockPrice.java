import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class SetStockPrice {

	private String userInput;
	private Scanner scan;

	private String stockSymbol;
	private Double amount;

	public SetStockPrice() {

		print("\n--------------Set Stock Price----------------\n");
		print("What stock would you like to set the price for? Format: Stock symbol");
		getUserInput_stockSymbol();
		this.stockSymbol = userInput.toUpperCase();
		print("What price would you like to set " + this.stockSymbol + " to?");
		getUserInput_amount();
		this.amount = Double.parseDouble(userInput);

		ManagerController mc = new ManagerController();
		mc.setStockPrice(this.stockSymbol, this.amount);
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
		String regex = "^[0-9]+(\\.)[0-9][0-9]$";
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
			print("Error: Invalid input. Please enter an appropiate value (format 00.00)");
			getUserInput_amount();
		} else {
			return;
		} 
	}

	public static void print(String p){
		System.out.println(p);
	}
}
