import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;

public class StockDetailPanel extends JPanel{
	private JLabel stockSymbolLabel;
	private JLabel nameLabel;
	private JLabel dailyClosingPriceLabel;
	private JLabel currentPriceLabel;
	private JLabel amountOwnLabel;
	private JButton buyButton;
	private JButton sellButton;

	public StockDetailPanel(){
		//JPanel characteristics
		this.setLayout(null);
		this.setBackground(Color.ORANGE);

		//Styling
		int base = 50;
		stockSymbolLabel = new JLabel("");
		stockSymbolLabel.setBounds(100, base, 200, 50);
		stockSymbolLabel.setHorizontalAlignment(JLabel.CENTER);
		stockSymbolLabel.setFont(stockSymbolLabel.getFont().deriveFont(24.0f));

		nameLabel = new JLabel("");
		nameLabel.setBounds(100, base + 20, 200, 50);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(nameLabel.getFont().deriveFont(16.0f));

		dailyClosingPriceLabel = new JLabel("");
		dailyClosingPriceLabel.setBounds(100, base + 50, 200, 50);
		dailyClosingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		dailyClosingPriceLabel.setFont(dailyClosingPriceLabel.getFont().deriveFont(12.0f));

		currentPriceLabel = new JLabel("");
		currentPriceLabel.setBounds(100, base + 70, 200, 50);
		currentPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		currentPriceLabel.setFont(currentPriceLabel.getFont().deriveFont(12.0f));

		amountOwnLabel = new JLabel("Stocks Owned: 123");
		amountOwnLabel.setBounds(100, base + 150, 200, 50);
		amountOwnLabel.setHorizontalAlignment(JLabel.CENTER);
		amountOwnLabel.setFont(currentPriceLabel.getFont().deriveFont(12.0f));

		buyButton = new JButton("BUY");
		buyButton.setBounds(100, base + 200, 90, 50);

		sellButton = new JButton("SELL");
		sellButton.setBounds(210, base + 200, 90, 50);

		//Event listeners

		//Add components
		this.add(stockSymbolLabel);
		this.add(nameLabel);
		this.add(dailyClosingPriceLabel);
		this.add(currentPriceLabel);
		this.add(amountOwnLabel);
		this.add(buyButton);
		this.add(sellButton);
	}

	public void setSymbolLabel(String symbol){
		stockSymbolLabel.setText(symbol);
	}

	public void setNameLabel(String name){
		nameLabel.setText(name);
	}

	public void setDailyClosingPriceLabel(double dailyClosingPrice){
		dailyClosingPriceLabel.setText(
			"Daily Closing Price: $"
			+ Double.toString(dailyClosingPrice)
			);
	}

	public void setCurrentPriceLabel(double currentPrice){
		currentPriceLabel.setText(
			"Current Price: $" 
			+ Double.toString(currentPrice)
			);
	}

	public void changeDetail(Stock s){
		setSymbolLabel(s.getSymbol());
		setNameLabel(s.getName());
		setDailyClosingPriceLabel(s.getDailyClosingPrice());
		setCurrentPriceLabel(s.getCurrentPrice());
	}
}