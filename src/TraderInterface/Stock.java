public class Stock {
	public String symbol;
	public String name;
	public double dailyClosingPrice;
	public double currentPrice;

	public Stock(String symbol, String name, double dailyClosingPrice, double currentPrice){
		this.symbol = symbol;
		this.name = name;
		this.dailyClosingPrice = dailyClosingPrice;
		this.currentPrice = currentPrice;
	}

}