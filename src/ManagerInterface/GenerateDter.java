import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

//--------------- Generate Government Drug & Tax Evasion Report (DTER) -----------------
/*
Description: According to the law, each customer who earns more than $10,000 within one month must be reported
to the government. Generate a list of all customers who have made more than $10,000 in the last month,
including earnings from buying/selling stocks and interest. The residence state of each customer should
also be listed.
*/

public class GenerateDter {	
	private int userInput = -1;
	private int minInput = -1;
	private int maxInput = -1;
	private Scanner scan;

	private HashMap<profileHandle, String> DterList;

	//Sample data
	// private Customer customer1 = new Customer("Jordan", "Ang", "CA", "209-598-5978", "jordanang@umail.ucsb.edu", 9012, "jordanang", "myPassword");
	// private Customer customer2 = new Customer("Richard", "Young", "CA", "401-598-5978", "ryoung@umail.ucsb.edu", 7021, "ryoung", "pass123");
	// private Customer customer3 = new Customer("James", "Yang", "CA", "123-554-5978", "jyang@umail.ucsb.edu", 5433, "jyang", "testtt");

	public GenerateDter(){
		print("\n---------Government Drug and Tax Evasion Report-----------\n");
		
		listCustomers();
		return;
	}

	public void listCustomers(){
		String leftAlignFormat = "| %-20s | %-5s | %-15s |%n";

		System.out.format("+----------------------+-------+-----------------+%n");
		System.out.format("| Customer Name        | State | Earnings        |%n");
		System.out.format("+----------------------+-------+-----------------+%n");
		
		DterList = getDterList();

		//sample data
		// DterList.add(customer1);
		// DterList.add(customer2);
		// DterList.add(customer3);

		/*for(Customer c: DterList){
			System.out.format(leftAlignFormat, c.firstName + " " + c.lastName, c.stateCode, "0000000.00");
		}*/

		for(Map.Entry<profileHandle, String> entry: DterList.entrySet())
		{
			profileHandle ph = entry.getKey();
			String earnings = entry.getValue();

			System.out.format(leftAlignFormat, ph.firstname+ " " +ph.lastname, ph.state_code, earnings);
		}

		System.out.format("+----------------------+-------+-----------------+%n");
	}

	public HashMap<profileHandle, String> getDterList() {
		ManagerController mc = new ManagerController();

		HashMap<profileHandle, String> hm = mc.getDTER();

		return hm;
	}

	public static void print(String p){
		System.out.println(p);
	}
}