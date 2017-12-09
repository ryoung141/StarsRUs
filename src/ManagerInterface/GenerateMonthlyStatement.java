import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Scanner;

//--------------- Generate Monthly Statement -----------------
/*
Description: Given a customer, do the following for each account she/he owns: generate a list of all transactions
that have occurred in the current month. This statement should list the name and email address of the
customer.
The initial and final account balance is to be included, so are the total earning/loss (including interest)
this month and the total amount of commissions paid.
The statement will be displayed in your interface.
*/

public class GenerateMonthlyStatement {

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

	public GenerateMonthlyStatement(){
		print("\n-----------------Generate Monthly Statement---------------\n");
		print("Choose a customer");
		listCustomers();
		getUserInput(minInput, maxInput);
		getMonthlyStatement(chosenOption);
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

	public Customer getCustomer(String name) {
		String firstName = name.split(" ")[0];
		String lastName = name.split(" ")[1];

		//TODO: Grab customer from database using firstname and lastname
		//Customer customer = new Customer(firstName, lastName ......);

		return customer1;
	}

	public void getMonthlyStatement(int input){
		Customer customer = customerList.get(input - 1);
		print("Generate monthly statement for " + customer.firstName + " " + customer.lastName + "\n");
		print("Name                 : " + customer.firstName + " " + customer.lastName);
		print("Email                : " + customer.email);
		print("Initial balance      : ");
		print("Final balance        : ");
		print("Total earning/loss   : ");
		print("Total commission paid: ");
		print("List of transactions : ");
		printTransactionList();

		//TODO: Complete

		return;
	}

	public void printTransactionList() {
		String leftAlignFormat = "| %-16s | %-5s | %-16s | %-6s |%n";

		System.out.format("+------------------+-------+------------------+--------+%n");
		System.out.format("| Date             | Stock | Transaction Type | Amount |%n");
		System.out.format("+------------------+-------+------------------+--------+%n");
		
		ArrayList<Transaction> transactionList = getTransactionList();

		for(Transaction t: transactionList){
			System.out.format(leftAlignFormat, t.timestamp, t.stockSymbol, t.transactionType, t.amount);
		}


		System.out.format("+------------------+-------+------------------+--------+%n");
	}

	public ArrayList<Transaction> getTransactionList() {
		return new ArrayList<Transaction>();
	}

	public static void print(String p){
		System.out.println(p);
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
}