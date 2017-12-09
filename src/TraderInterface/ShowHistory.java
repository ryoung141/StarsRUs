import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;


public class ShowHistory {

	private String userInput;
	private Scanner scan;

	public ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

	public ShowHistory(){

		Transaction transaction1 = new Transaction("08-30-196 10:23", "ABA", "Buy", "3");
		Transaction transaction2 = new Transaction("08-30-196 10:23", "ABA", "Buy", "3");
		Transaction transaction3 = new Transaction("08-30-196 10:23", "ABA", "Buy", "3");
		Transaction transaction4 = new Transaction("08-30-196 10:23", "ABA", "Buy", "3");
		Transaction transaction5 = new Transaction("08-30-196 10:23", "ABA", "Buy", "3");
		Transaction transaction6 = new Transaction("08-30-196 10:23", "ABA", "Buy", "3");
		Transaction transaction7 = new Transaction("08-30-196 10:23", "ABA", "Buy", "3");

		transactionList.add(transaction1);
		transactionList.add(transaction2);
		transactionList.add(transaction3);
		transactionList.add(transaction4);
		transactionList.add(transaction5);
		transactionList.add(transaction6);
		transactionList.add(transaction7);
		print("\n-----------------Transactions List-------------------\n");
		showHistory();
		return;
	}

	public void showHistory(){

		String leftAlignFormat = "| %-16s | %-5s | %-16s | %-6s |%n";

		System.out.format("+------------------+-------+------------------+--------+%n");
		System.out.format("| Date             | Stock | Transaction Type | Amount |%n");
		System.out.format("+------------------+-------+------------------+--------+%n");
		
		//transactionList = getTransaction();

		for(Transaction t: transactionList){
			System.out.format(leftAlignFormat, t.timestamp, t.stockSymbol, t.transactionType, t.amount);
		}


		System.out.format("+------------------+-------+------------------+--------+%n");
	}

	public ArrayList<Transaction> getTransaction() {
		return new ArrayList<Transaction>();
	}

	public static void print(String p){
		System.out.println(p);
	}
}
