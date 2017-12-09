public class ShowBalance {
	public ShowBalance() {
		print("\n------------Market Account Balance--------------\n");
		print("Balance: " + Double.toString(getMarketAccountBalance()));
		return;
	}

	public double getMarketAccountBalance() {
		AccountController ac = new AccountController(TraderInterface.username, TraderInterface.password);
		return ac.getBalance();
	}
	
	public static void print(String p){
		System.out.println(p);
	}
}