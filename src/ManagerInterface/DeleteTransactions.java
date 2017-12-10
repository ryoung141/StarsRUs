import java.util.HashMap;
import java.util.Scanner;

//--------------- Delete Transactions -----------------
/*
Description: Delete the list of transactions from each of the accounts, in preparation for a new month of processing.
*/

public class DeleteTransactions {
	private int userInput = -1;
	private int minInput = -1;
	private int maxInput = -1;
	private Scanner scan;


	public DeleteTransactions(){
		print("\n------------------Delete Transactions-------------------------\n");
		DeleteTransactions();
		return;
	}

	public void DeleteTransactions() {
		ManagerController mc = new ManagerController();
		boolean ret = mc.DeleteTransactions();

		if(ret)
		{
			print("All transactions have been deleted");
		}
		else
		{
			print("Error: transaction deletion not successful");
		}
	}

	public static void print(String p){
		System.out.println(p);
	}
}