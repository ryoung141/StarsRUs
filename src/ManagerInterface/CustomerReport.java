import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;

//--------------- Customer Report -----------------
/*
Description: Generate a list of all accounts associated with a particular customer and the current balance.
*/

public class CustomerReport {
	
	private String userInput = "";
	private int chosenOption = -1;
	private int minInput = -1;
	private int maxInput = -1;
	private Scanner scan;

	private ArrayList<Customer> customerList;

	//Sample data
	private Customer customer1 = new Customer("Jordan", "Ang", "CA", "209-598-5978", "jordanang@umail.ucsb.edu", 9012, "jordanang", "myPassword");
	private Customer customer2 = new Customer("Richard", "Young", "CA", "401-598-5978", "ryoung@umail.ucsb.edu", 7021, "ryoung", "pass123");
	private Customer customer3 = new Customer("James", "Yang", "CA", "123-554-5978", "jyang@umail.ucsb.edu", 5433, "jyang", "testtt");

	public CustomerReport(){
		print("\n------------------Customer Report-------------------------\n");
		print("Choose a customer");
		listCustomers();
		getUserInput(minInput, maxInput);
		showCustomerReport(chosenOption);
		return;
	}

	public void showCustomerReport(int input) {
		Customer customer = customerList.get(input);
		print(" THis is a list of all account associated with " + customer.firstName + " " + customer.lastName);
		return;
	}

	public void listCustomers(){
		//fill list with customer objects
		customerList = getCustomerList();

		//sample data
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);

		minInput = 1;
		maxInput = customerList.size();

		if(minInput > maxInput) {
			print("There are no customers!");
		} else {
			for(int i=minInput; i<=maxInput; i++) {
				String key = Integer.toString(i);
				String val = customerList.get(i-1).firstName + " " + customerList.get(i-1).lastName;
				print(key + ". " + val);
			}
		}
		
		return;
	}

	public ArrayList<Customer> getCustomerList() {
		return new ArrayList<Customer>();
	}

	public boolean verifyInput(String input) {
		String regex = "^[0-9][0-9]?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public void getUserInput(int min, int max) {
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

	public static void print(String p){
		System.out.println(p);
	}
}