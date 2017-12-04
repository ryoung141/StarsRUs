import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.regex.*;
import java.util.ArrayList;

public class BuyTransactionPanel extends JPanel{
	private JLabel titleLabel;
	private JLabel currentPriceLabel;
	private JLabel amountLabel;
	private JTextField amountField;
	private JButton buyButton;
	private JLabel errMsgLabel;
	private JButton cancelButton;
	private JLabel confirmMsgLabel;
	private JButton confirmButton;
	private JButton confirmCancelButton;

	int amount = 0;
	double total = 0;
	Stock stock;

	public static final String TRANSACTION_PANEL = "Transaction Panel";
	public static final String CONFIRMATION_PANEL = "Confirm Panel";

	public BuyTransactionPanel(Stock s){
		this.stock = s;
		this.setLayout(new CardLayout());
		this.setBackground(Color.BLUE);

		/* ------Transaction------- */

		//JPanel characteristics
		JPanel transactionPanel = new JPanel();
		transactionPanel.setLayout(null);

		//Styling
		titleLabel = new JLabel("Buy " + stock.getSymbol());
		titleLabel.setBounds(90, 25, 100, 50);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(20.0f));

		currentPriceLabel = new JLabel("Current Price: $" + Double.toString(stock.getCurrentPrice()));
		currentPriceLabel.setBounds(50, 55, 180, 40);
		currentPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		currentPriceLabel.setFont(currentPriceLabel.getFont().deriveFont(12.0f));

		amountLabel = new JLabel("Amount: ");
		amountLabel.setBounds(90, 90, 50, 25);
		amountLabel.setHorizontalAlignment(JLabel.CENTER);
		amountLabel.setFont(amountLabel.getFont().deriveFont(12.0f));

		amountField = new JTextField();
		amountField.setBounds(150, 90, 40, 25);

		buyButton = new JButton("BUY");
		buyButton.setBounds(50, 125, 80, 35);

		cancelButton = new JButton("CANCEL");
		cancelButton.setBounds(150, 125, 80, 35);

		errMsgLabel = new JLabel("");
		errMsgLabel.setBounds(50, 160, 180, 40);
		errMsgLabel.setHorizontalAlignment(JLabel.CENTER);
		errMsgLabel.setFont(errMsgLabel.getFont().deriveFont(12.0f));

		//Event listeners
		buyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String amountString = amountField.getText();
				System.out.println(amountString);
				errMsgLabel.setText("");
				if(verifyAmount(amountString)){
					amount = Integer.parseInt(amountField.getText());
					total = amount * stock.getCurrentPrice();
					changeConfirmDetail();
					CardLayout c = (CardLayout) (StockDetailPanel.buyTransactionPanel.getLayout());
					c.show(StockDetailPanel.buyTransactionPanel, CONFIRMATION_PANEL);
				} else {
					errMsgLabel.setText("Error: Invalid input");
				}
			}
		});

		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				StockDetailPanel.buyDialog.setVisible(false);
			}
		});

		//Add components
		transactionPanel.add(titleLabel);
		transactionPanel.add(currentPriceLabel);
		transactionPanel.add(amountLabel);
		transactionPanel.add(amountField);
		transactionPanel.add(buyButton);
		transactionPanel.add(cancelButton);
		transactionPanel.add(errMsgLabel);

		/* -------------------------- */

		/* ------Confirmation------- */

		//JPanel characteristics
		JPanel confirmPanel = new JPanel();
		confirmPanel.setLayout(null);

		//Styling
		confirmMsgLabel = new JLabel("Buy " 
			+ Integer.toString(amount) 
			+ " " + stock.getSymbol()
			+ " for "
			+ " $" + Double.toString(total)
			);
		confirmMsgLabel.setBounds(50, 55, 180, 40);
		confirmMsgLabel.setHorizontalAlignment(JLabel.CENTER);
		confirmMsgLabel.setFont(confirmMsgLabel.getFont().deriveFont(12.0f));

		confirmButton = new JButton("CONFIRM");
		confirmButton.setBounds(30, 125, 100, 35);

		confirmCancelButton = new JButton("CANCEL");
		confirmCancelButton.setBounds(150, 125, 80, 35);

		//Event listeners
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(buyStock()){
					errMsgLabel.setText("Bought " 
						+ Integer.toString(amount) 
						+ " " + stock.getSymbol()
						+ " for "
						+ "$" + Double.toString(total)
						);
				} else {
					errMsgLabel.setText("Error: Could not buy");
				}
				CardLayout c = (CardLayout) (StockDetailPanel.buyTransactionPanel.getLayout());
				c.show(StockDetailPanel.buyTransactionPanel, TRANSACTION_PANEL);
			}
		});

		confirmCancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout) (StockDetailPanel.buyTransactionPanel.getLayout());
				c.show(StockDetailPanel.buyTransactionPanel, TRANSACTION_PANEL);
			}
		});

		//Add components
		confirmPanel.add(confirmMsgLabel);
		confirmPanel.add(confirmButton);
		confirmPanel.add(confirmCancelButton);


		/* -------------------------- */

		//CardLayout components
		this.add(transactionPanel, TRANSACTION_PANEL);
		this.add(confirmPanel, CONFIRMATION_PANEL);

	}

	public void changeDetails(Stock s){
		this.stock = s;
		titleLabel.setText("Buy " + this.stock.getSymbol());
		currentPriceLabel.setText("Current Price: $" + Double.toString(this.stock.getCurrentPrice()));
		errMsgLabel.setText("");
		amountField.setText("");
	}

	public void changeConfirmDetail(){
		confirmMsgLabel.setText("Buy " 
			+ Integer.toString(amount) 
			+ " " + this.stock.getSymbol()
			+ " for "
			+ "$" + Double.toString(total)
			);
		errMsgLabel.setText("");
	}

	public boolean verifyAmount(String amount){
		String regex = "[0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(amount);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean buyStock(){
		//TODO: Buy stock function
		return true;
	}
}