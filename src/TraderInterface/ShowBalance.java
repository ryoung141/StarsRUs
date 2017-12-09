public class ShowBalance {
	public ShowBalance() {
		print("\n------------Market Account Balance--------------\n");
		print("Balance: " + Double.toString(getMarketAccountBalance()));
		return;
	}

	public double getMarketAccountBalance() {
		return 222.22;
	}
	
	public static void print(String p){
		System.out.println(p);
	}
}