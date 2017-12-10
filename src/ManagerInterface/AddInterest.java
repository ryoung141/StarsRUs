import java.util.HashMap;
import java.util.Scanner;

//--------------- Add Interest -----------------
/*
Description: For all market accounts, add the appropriate amount of monthly interest to the balance. This is usually
done at the end of a month.
*/

public class AddInterest {
	private int userInput = -1;
	private int minInput = -1;
	private int maxInput = -1;
	private Scanner scan;


	public AddInterest(){
		print("\n--------------------Add Interest--------------------------\n");
		AccountController ac = new AccountController();
		ac.accrueInterest();
		print("\n-----------------------Done!------------------------------\n");

		return;
	}

	public void getUserInput(int min, int max) {
		scan = new Scanner(System.in);
		System.out.print("\nInput: ");
		userInput = scan.nextInt();

		if(userInput < min || userInput > max) {
			print("Error: Invalid input. Please enter an input between " + minInput + " and " + maxInput + ".");
			getUserInput(min, max);
		} else {
			return;
		} 
	}

	public static void print(String p){
		System.out.println(p);
	}
}