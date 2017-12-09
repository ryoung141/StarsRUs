import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;


public class Withdraw {

	private String userInput;
	private Scanner scan;

	public Withdraw(){
		print("\n-----------------Withdraw-------------------\n");
		print("How much would you like to withdraw? Format: 0000.00");
		getUserInput();
		withdraw(Double.parseDouble(userInput));
		return;
	}

	public void withdraw(double amount) {
		AccountController ac = new AccountController(TraderInterface.username, TraderInterface.password);
		if(ac.makeWithdrawal(amount))
		{
			print("\n" + Double.toString(amount) + " has been withdrawn!");
		}
		else
		{
			print("Error: Deposit failed on the backend!");
		}
		return;
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

	public void getUserInput() {
		scan = new Scanner(System.in);
		System.out.print("\nInput: ");
		userInput = scan.next();

		if(!verifyAmount(userInput)) {
			print("Error: Invalid input. Please enter an appropiate value (format 00.00)");
			getUserInput();
		} else {
			return;
		} 
	}

	public static void print(String p){
		System.out.println(p);
	}
}