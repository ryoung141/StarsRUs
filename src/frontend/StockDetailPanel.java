import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;

public class StockDetailPanel extends JPanel{
	private Stock stock;
	private JLabel stockSymbolLabel;
	private JLabel nameLabel;
	private JLabel dailyClosingPriceLabel;
	private JLabel currentPriceLabel;
	private JLabel amountOwnLabel;
	private JButton buyButton;
	private JButton sellButton;
	private JButton profileButton;

	public static JDialog buyDialog;
	public static BuyTransactionPanel buyTransactionPanel;

	public static JDialog sellDialog;
	public static SellTransactionPanel sellTransactionPanel;

	public static JDialog profileDialog;
	public static ProfilePanel profilePanel;

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

		profileButton = new JButton("PROFILE");
		profileButton.setBounds(150, base + 70, 100, 30);
		profileButton.setVisible(false);

		dailyClosingPriceLabel = new JLabel("");
		dailyClosingPriceLabel.setBounds(100, base + 100, 200, 50);
		dailyClosingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		dailyClosingPriceLabel.setFont(dailyClosingPriceLabel.getFont().deriveFont(12.0f));

		currentPriceLabel = new JLabel("");
		currentPriceLabel.setBounds(100, base + 120, 200, 50);
		currentPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		currentPriceLabel.setFont(currentPriceLabel.getFont().deriveFont(12.0f));

		amountOwnLabel = new JLabel("");
		amountOwnLabel.setBounds(100, base + 150, 200, 50);
		amountOwnLabel.setHorizontalAlignment(JLabel.CENTER);
		amountOwnLabel.setFont(currentPriceLabel.getFont().deriveFont(12.0f));

		buyButton = new JButton("BUY");
		buyButton.setBounds(100, base + 200, 90, 50);
		buyButton.setVisible(false);

		sellButton = new JButton("SELL");
		sellButton.setBounds(210, base + 200, 90, 50);
		sellButton.setVisible(false);

		buyDialog = new JDialog();
		buyDialog.setSize(300, 250);
		buyDialog.setVisible(false);

		sellDialog = new JDialog();
		sellDialog.setSize(300, 250);
		sellDialog.setVisible(false);

		profileDialog = new JDialog();
		profileDialog.setSize(400, 500);
		profileDialog.setVisible(false);

		//Event listeners
		buyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(buyTransactionPanel == null){
					buyTransactionPanel = new BuyTransactionPanel(stock);
					buyDialog.add(buyTransactionPanel);
				} else {
					buyTransactionPanel.changeDetails(stock);
				}
				buyDialog.setVisible(true);
			}
		});

		sellButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(sellTransactionPanel == null){
					sellTransactionPanel = new SellTransactionPanel(stock);
					sellDialog.add(sellTransactionPanel);
				} else {
					sellTransactionPanel.changeDetails(stock);
				}
				sellDialog.setVisible(true);
			}
		});

		profileButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(profilePanel == null){
					profilePanel = new ProfilePanel(stock);
					profileDialog.add(profilePanel);
				} else {
					profilePanel.changeDetails(stock);
				}
				profileDialog.setVisible(true);
			}
		});

		//Add components
		this.add(stockSymbolLabel);
		this.add(nameLabel);
		this.add(dailyClosingPriceLabel);
		this.add(currentPriceLabel);
		this.add(amountOwnLabel);
		this.add(buyButton);
		this.add(sellButton);
		this.add(profileButton);

	}

	public void makeVisible(){
		buyButton.setVisible(true);
		sellButton.setVisible(true);
		profileButton.setVisible(true);
	}

	public int getOwned(Stock s){
		//TODO: Get amount of stocks owned as int
		return 797;
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

	public void setAmountOwnedLabel(int owned){
		amountOwnLabel.setText(
			"Stocks Owned: " 
			+ Integer.toString(owned)
			);
	}

	public void changeDetail(Stock s){
		this.stock = s;
		setSymbolLabel(s.getSymbol());
		setNameLabel(s.getName());
		setDailyClosingPriceLabel(s.getDailyClosingPrice());
		setCurrentPriceLabel(s.getCurrentPrice());
		setAmountOwnedLabel(getOwned(s));
	}
}