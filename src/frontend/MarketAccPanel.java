
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.*;
import java.util.HashMap;

public class MarketAccPanel extends AccountPanel{
	//Define components
	private JComboBox accountsComboBox;
	private JLabel titleLabel;
	private JLabel balanceLabel; 
	private JButton depositButton;
	private JButton withdrawButton;
	private JLabel msg;
	private JTextField depositDiagField;
	private JTextField withdrawDiagField;
	private JButton depositDiagButton;
	private JButton withdrawDiagButton;
	private JLabel depositDiagErr;
	private JLabel withdrawDiagErr;

	public MarketAccPanel() {
		//JPanel characteristics
		this.setBackground(Color.RED);
		this.setLayout(null);

		//Styling
		int base = 100;
		accountsComboBox = new JComboBox(AccManagerPanel.accounts);
		accountsComboBox.setBounds(125, 25, 150, 25);
		setComboBox();

		titleLabel = new JLabel("Market Account");
		titleLabel.setBounds(100, base + 100, 200, 25);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));

		balanceLabel = new JLabel("Unitialized");
		setBalance(getBalance());
		balanceLabel.setBounds(100, base + 200, 200, 25);
		balanceLabel.setHorizontalAlignment(JLabel.CENTER);
		balanceLabel.setFont(balanceLabel.getFont().deriveFont(16.0f));

		depositButton = new JButton("Deposit");
		depositButton.setBounds(100, base + 250, 90, 50);

		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(210, base + 250, 90, 50);

		//Event listeners
		accountsComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String selectedAccount = String.valueOf(accountsComboBox.getSelectedItem());
				CardLayout c = (CardLayout) (TraderInterfacePanel.accManagerPanel.getLayout());
				c.show(TraderInterfacePanel.accManagerPanel, selectedAccount);
				setComboBox();
			}
		});

		depositButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialog d = new JDialog();
				d.setSize(225, 150);

				JPanel pan = new JPanel();
				pan.setLayout(null);

				//Styling
				msg = new JLabel("Enter amount to deposit");
				msg.setHorizontalAlignment(JLabel.CENTER);
				msg.setBounds(0, 0, 200, 25);

				depositDiagField = new JTextField();
				depositDiagField.setBounds(50, 30, 100, 25);

				depositDiagButton = new JButton("Deposit");
				depositDiagButton.setBounds(50, 60, 100, 25);

				depositDiagErr = new JLabel("");
				depositDiagErr.setHorizontalAlignment(JLabel.CENTER);
				depositDiagErr.setBounds(0, 80, 200, 25);

				//Evemt Listeners
				depositDiagButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String amount = depositDiagField.getText();
						boolean amountReady = true;

						if(!verifyMoneyInput(amount)) {
							depositDiagErr.setText("Error: Invalid input");
							amountReady = false;
						}

						if(amountReady){
							if(depositMoney(amount)){
								depositDiagErr.setText("$" + amount + " has been deposited!");
								setBalance(getBalance());
							} else {
								depositDiagErr.setText("Error: Unable to deposit");
							}
						}
					}
				});

				//Add components
				pan.add(msg);
				pan.add(depositDiagField);
				pan.add(depositDiagButton);
				pan.add(depositDiagErr);

				d.add(pan);
				d.setVisible(true);
			}
		});

		withdrawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialog d = new JDialog();
				d.setSize(225, 150);

				JPanel pan = new JPanel();
				pan.setLayout(null);

				//Styling
				msg = new JLabel("Enter amount to Withdraw");
				msg.setHorizontalAlignment(JLabel.CENTER);
				msg.setBounds(0, 0, 200, 25);

				withdrawDiagField = new JTextField();
				withdrawDiagField.setBounds(50, 30, 100, 25);

				withdrawDiagButton = new JButton("Withdraw");
				withdrawDiagButton.setBounds(50, 60, 100, 25);

				withdrawDiagErr = new JLabel("																																																				");
				withdrawDiagErr.setHorizontalAlignment(JLabel.CENTER);
				withdrawDiagErr.setBounds(0, 80, 200, 25);

				//Evemt Listeners
				withdrawDiagButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String amount = withdrawDiagField.getText();
						boolean amountReady = true;

						if(!verifyMoneyInput(amount)) {
							withdrawDiagErr.setText("Error: Invalid input");
							amountReady = false;
						}

						if(amountReady){
							if(WithdrawMoney(amount)){
								withdrawDiagErr.setText("$" + amount + " has been withdrawn!");
								setBalance(getBalance());
							} else {
								withdrawDiagErr.setText("Error: Unable to deposit");
							}
						}
					}
				});

				//Add components
				pan.add(msg);
				pan.add(withdrawDiagField);
				pan.add(withdrawDiagButton);
				pan.add(withdrawDiagErr);

				d.add(pan);
				d.setVisible(true);
			}
		});



		//Add components
		this.add(accountsComboBox);
		this.add(titleLabel);
		this.add(balanceLabel);
		this.add(depositButton);
		this.add(withdrawButton);
	}	

	public void setComboBox(){
		accountsComboBox.setSelectedItem(AccManagerPanel.MARKET_ACC_PANEL);
	}

	public double getBalance() {
		AccountController ac = new AccountController(LoginPanel.profile_id);
		return ac.getBalance();
	}

	public void setBalance(int dollars){
		String balance = 
			"Balance: $"
			+ Integer.toString(dollars);

		balanceLabel.setText(balance);
	}

	public boolean verifyMoneyInput(String amount){
		String regex = "[0-9]+([,.][0-9]{1,2})?";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(amount);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean depositMoney(String amount){
		AccountController ac = new AccountController(LoginPanel.profile_id);
		return ac.makeDeposit(Integer.parseInt(amount));
	}

	public boolean WithdrawMoney(String amount){
		AccountController ac = new AccountController(LoginPanel.profile_id);
		return ac.makeWithdrawal(Integer.parseInt(amount));
	}
}