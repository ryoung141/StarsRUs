import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;

public class SetDay {

	private String userInput = "";
	private Scanner scan;

	public SetDay() {
		print("\n------------------Set Day-------------------------\n");
		print("Enter a day to set to");
		getUserInput();
		setDay(userInput);
	
	}

	public void setDay(String input){
		print("Day has been set to " + input);
	}

	public boolean verifyInput(String input) {
		String regex = "^[0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);

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

		if(!verifyInput(userInput)) {
			print("Error: Invalid input. Please enter an input with format MM-DD-YYYY");
			getUserInput();
		}
	}

	public static void print(String p){
		System.out.println(p);
	}
}
