import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Date;


public class ShowHistory {

	private String userInput;
	private Scanner scan;

	public ShowHistory(){

/*		Transaction transaction1 = new Transaction("08-30-196 10:23", "ABA", "Buy", "3");
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
		transactionList.add(transaction7);*/
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

/*		for(Transaction t: transactionList){
			System.out.format(leftAlignFormat, t.timestamp, t.stockSymbol, t.transactionType, t.amount);
		}*/

		ArrayList<buy> bList = getBuys();
		ArrayList<sell> sList = getSales();
		ArrayList<deposit> dList = getDeposits();
		ArrayList<withdrawal> wList = getWithdrawals();
		ArrayList<accrual> aList = getAccruals();

		for(buy b: bList)
		{
			System.out.format(leftAlignFormat, b.system_date, b.getStock(), "buy", b.amount);
		}

		for(sell s: sList)
		{
			System.out.format(leftAlignFormat, s.system_date, s.getStock(), "sale", s.amount);
		}

		for(deposit dep: dList)
		{
			System.out.format(leftAlignFormat, dep.system_date, "N/A", "deposit", dep.amount);
		}

		for(withdrawal w: wList)
		{
			System.out.format(leftAlignFormat, w.system_date, "N/A", "withdrawal", w.amount);
		}

		for(accrual a: aList)
		{
			System.out.format(leftAlignFormat, a.system_date, "N/A", "accrual", a.amount);
		}


		System.out.format("+------------------+-------+------------------+--------+%n");
	}

	public ArrayList<buy> getBuys()
	{
		AccountController ac = new AccountController(TraderInterface.username, TraderInterface.password);
		ArrayList<buy> b = ac.getAllBuys();
		return b;
	}

	public ArrayList<sell> getSales()
	{
		AccountController ac = new AccountController(TraderInterface.username, TraderInterface.password);
		ArrayList<sell> s = ac.getAllSales();
		return s;
	}


	public ArrayList<deposit> getDeposits()
	{
		AccountController ac = new AccountController(TraderInterface.username, TraderInterface.password);
		ArrayList<deposit> d = ac.getAllDeposits();
		return d;
	}


	public ArrayList<withdrawal> getWithdrawals()
	{
		AccountController ac = new AccountController(TraderInterface.username, TraderInterface.password);
		ArrayList<withdrawal> w = ac.getAllWithdrawals();
		return w;
	}


	public ArrayList<accrual> getAccruals()
	{
		AccountController ac = new AccountController(TraderInterface.username, TraderInterface.password);
		ArrayList<accrual> a = ac.getAllAccruals();
		return a;
	}



	public static void print(String p){
		System.out.println(p);
	}
}
