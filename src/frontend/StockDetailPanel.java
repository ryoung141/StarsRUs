import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;

public class StockDetailPanel extends JPanel{
	private JLabel stockSymbolLabel;
	private JLabel nameLabel;
	private JLabel closingPriceLabel;
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
		stockSymbolLabel = new JLabel("STA");
		stockSymbolLabel.setBounds(100, base, 200, 50);
		stockSymbolLabel.setHorizontalAlignment(JLabel.CENTER);
		stockSymbolLabel.setFont(stockSymbolLabel.getFont().deriveFont(24.0f));

		nameLabel = new JLabel("Sandy Tarrel");
		nameLabel.setBounds(100, base + 20, 200, 50);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(nameLabel.getFont().deriveFont(16.0f));

		closingPriceLabel = new JLabel("Daily Closing Price: $2302.32");
		closingPriceLabel.setBounds(100, base + 50, 200, 50);
		closingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		closingPriceLabel.setFont(closingPriceLabel.getFont().deriveFont(12.0f));

		currentPriceLabel = new JLabel("Current Price: $2302.32");
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
		this.add(closingPriceLabel);
		this.add(currentPriceLabel);
		this.add(amountOwnLabel);
		this.add(buyButton);
		this.add(sellButton);
	}
}