public class Transaction {

	public String timestamp;
	public String stockSymbol;
	public String transactionType;
	public String amount;
	
	public Transaction(String timestamp, String stockSymbol, String transactionType, String amount) {
		this.timestamp = timestamp;
		this.stockSymbol = stockSymbol;
		this.transactionType = transactionType;
		this.amount = amount;
	}
}