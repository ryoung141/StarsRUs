import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.regex.*;
import java.util.ArrayList;

public class ProfilePanel extends JPanel{
	private Stock stock;
	private JLabel titleLabel;
	private JLabel stockSymbolLabel;
	private JLabel nameLabel;
	private JLabel birthLabel;
	private JLabel contractsLabel;
	private JList contractsList;
	private JScrollPane scrollContainer;

	public static String[] contracts = {"Batman", "Ben10", "Transformers", "Harry Potter", "Ronnie and the Dweebs"};
	public static MovieContractDetailPanel movieContractDetailPanel;

	public ProfilePanel(Stock s){
		this.stock = s;
		this.setLayout(null);

		//Styling
		titleLabel = new JLabel("Profile");
		titleLabel.setBounds(150, 25, 100, 50);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(20.0f));

		stockSymbolLabel = new JLabel("Stock Symbol: ABA");
		stockSymbolLabel.setBounds(100, 75, 200, 25);
		stockSymbolLabel.setHorizontalAlignment(JLabel.CENTER);
		stockSymbolLabel.setFont(stockSymbolLabel.getFont().deriveFont(12.0f));

		nameLabel = new JLabel("Name: Abraham Ahana");
		nameLabel.setBounds(100, 100, 200, 25);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(nameLabel.getFont().deriveFont(12.0f));

		birthLabel = new JLabel("Date of Birth: 01-23-98");
		birthLabel.setBounds(100, 125, 200, 25);
		birthLabel.setHorizontalAlignment(JLabel.CENTER);
		birthLabel.setFont(birthLabel.getFont().deriveFont(12.0f));

		contractsLabel = new JLabel("Movie Contracts Signed");
		contractsLabel.setBounds(100, 175, 200, 25);
		contractsLabel.setHorizontalAlignment(JLabel.CENTER);
		contractsLabel.setFont(contractsLabel.getFont().deriveFont(12.0f));

		contractsList = new JList(contracts);
		scrollContainer = new JScrollPane(contractsList);
		scrollContainer.setBounds(50, 200, 300, 70);
		scrollContainer.setVerticalScrollBar(new JScrollBar());
		
		movieContractDetailPanel = new MovieContractDetailPanel();
		movieContractDetailPanel.setBounds(0, 300, 400, 200);

		//Event listeners

		//Add components
		this.add(titleLabel);
		this.add(stockSymbolLabel);
		this.add(nameLabel);
		this.add(birthLabel);
		this.add(contractsLabel);
		this.add(scrollContainer);
		this.add(movieContractDetailPanel);
	}

	public void changeDetails(Stock s){
		this.stock = s;
	}

	public void setSymbol(String symbol){
		stockSymbolLabel.setText("Stock Symbol: " + symbol);
	}

	public void setName(String name){
		nameLabel.setText("Name: " + name);
	}

	public void setBirth(String dob){
		birthLabel.setText("Date of Birth: " + dob);
	}

	public void getContracts(){
		//TODO: Implement contracts
		return;
	}
}