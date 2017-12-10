import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

//--------------- List Active Customers -----------------
	/*
	Description: Generate a list of all customers who have traded (buy or sell) at least 1,000 shares in the current month
	*/

public class ListActiveCustomers {

	private ArrayList<String> activeCustomerList;


	public ListActiveCustomers(){
		print("\n-------------------Active Customer List-------------------\n");
		listActiveCustomers();
		return;
	}

	public void listActiveCustomers(){
		activeCustomerList = getActiveCustomnerList();
		for(String c: activeCustomerList) {
			print(c);
		}
	}

	public ArrayList<String> getActiveCustomnerList() {
		ManagerController mc = new ManagerController();

		return mc.getActiveCustomers();
	}

	public static void print(String p){
		System.out.println(p);
	}
}