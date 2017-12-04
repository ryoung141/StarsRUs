public class Stock {
	private String symbol;
	private String name;
	private double dailyClosingPrice;
	private double currentPrice;

	public Stock(String symbol, String name, double dailyClosingPrice, double currentPrice){
		this.symbol = symbol;
		this.name = name;
		this.dailyClosingPrice = dailyClosingPrice;
		this.currentPrice = currentPrice;
	}

	public void setSymbol(String s){
		this.symbol = s;
		return;
	}

	public String getSymbol(){
		return this.symbol;
	}

	public void setName(String n){
		this.name = n;
		return;
	}

	public String getName(){
		return this.name;
	}

	public void setDailyClosingPrice(double p){
		this.dailyClosingPrice = p;
		return;
	}

	public double getDailyClosingPrice(double p){
		return this.dailyClosingPrice;
	}

	public void setCurrentPrice(double p){
		this.currentPrice = p;
		return;
	}

	public double getCurrentPrice(){
		return this.currentPrice;
	}
}