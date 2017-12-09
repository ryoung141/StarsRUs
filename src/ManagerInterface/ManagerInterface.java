import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.*;

public class ManagerInterface{

	public static boolean close = false;

	public static  String userInput = "";
	public static  int chosenOption = -1;
	public static  int minInput = -1;
	public static  int maxInput = -1;

	public static HashMap<Integer, String> options;
	public static Scanner scan;

	public static void main(String[] arg){

		options = new HashMap<Integer, String>(); 
		options.put(1, "Add Interest");
		options.put(2, "Generate Monthly Statement");
		options.put(3, "List Active Customers");
		options.put(4, "Generate Government Drug & Tax Evasion Report (DTER)");
		options.put(5, "Generate Customer Report");
		options.put(6, "Delete Transactions");
		options.put(7, "Exit");

		minInput = 1;
		maxInput = 7;

		print("\n--------------Welcome to the Manager Interface------------\n");

		while(close == false) {
			start();
		}

		print("Goodbye");
	}

	public static void start(){
		print("\n-----------------------MAIN MENU--------------------------\n");
		print("Choose an option below");

		for (int i=minInput; i<=maxInput; i++) {
			String key = Integer.toString(i);
			String val = options.get(i);
			print(key + ". " + val);
		}

		getUserInput(minInput, maxInput);

		switch(chosenOption) {
			case 1: AddInterest ai = new AddInterest();
				break;
			case 2: GenerateMonthlyStatement gms = new GenerateMonthlyStatement();
				break;
			case 3: ListActiveCustomers lac = new ListActiveCustomers();
				break;
			case 4: GenerateDter gd = new GenerateDter();
				break;
			case 5: CustomerReport cr = new CustomerReport();
				break;
			case 6: DeleteTransactions dt = new DeleteTransactions();
				break;
			case 7: close = true;
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