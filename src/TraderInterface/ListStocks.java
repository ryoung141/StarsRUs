import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;


public class ListStocks {

	private String userInput;
	private Scanner scan;

	private String stockSymbol;
	private int amount;

	public Map<String, stock> stockMap;

	public static Stock stock1 = new Stock("JOA", "Jordan Ang", 1234.22, 3230.14);
	public static Stock stock2 = new Stock("JOH", "John Harm", 3032.22, 10.20);
	public static Stock stock3 = new Stock("KEN", "Kenn Huynh", 55.32, 2022.12);
	public static Stock stock4 = new Stock("KAL", "Kall Allen", 3551.32, 253.12);
	public static Stock stock5 = new Stock("FRE", "Fomo Eagel", 6533.32, 755.12);
	public static Stock stock6 = new Stock("MON", "Moreal Nguyen", 655.32, 85.12);
	public static Stock stock7 = new Stock("TOU", "Tom Uynh", 557.32, 43.12);

	public ListStocks(){
		this.stockMap = getStocks();
		print("\n-----------------Stocks List-------------------\n");
		listStocks();
		return;
	}

	public void listStocks(){

		String leftAlignFormat = "| %-6s | %-15s | %-15s |%n";

		System.out.format("+--------+-----------------+-----------------+%n");
		System.out.format("| Symbol | Stock Name      | Current Price   |%n");
		System.out.format("+--------+-----------------+-----------------+%n");
		
		//stockList = getStocks();

		for(Map.Entry<String, stock> entry: this.stockMap.entrySet())
		{
			String name = entry.getKey();
			stock s = entry.getValue();
			System.out.format(leftAlignFormat, s.stock_symbol, name, Double.toString(s.getCurrentPrice()));
		}

		/*for(stock s: stockList){
			System.out.format(leftAlignFormat, s.symbol, s.name, Double.toString(s.currentPrice));
		}*/


		System.out.format("+--------+-----------------+-----------------+%n");
	}

	public HashMap<String, stock> getStocks() {
		AccountController ac = new AccountController();
		return ac.getStocks();
	}

	public static void print(String p){
		System.out.println(p);
	}
}