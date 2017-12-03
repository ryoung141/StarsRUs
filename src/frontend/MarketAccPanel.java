
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MarketAccPanel extends AccountPanel{
	//Define components
	public JComboBox accountsComboBox;

	public MarketAccPanel() {
		//JPanel characteristics
		this.setBackground(Color.RED);
		this.setLayout(null);

		//Styling
		accountsComboBox = new JComboBox(AccManagerPanel.accounts);
		setComboBox();
		accountsComboBox.setBounds(125, 25, 150, 25);

		//Event listeners
		accountsComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String selectedAccount = String.valueOf(accountsComboBox.getSelectedItem());
				CardLayout c = (CardLayout) (TraderInterfacePanel.accManagerPanel.getLayout());
				c.show(TraderInterfacePanel.accManagerPanel, selectedAccount);
				setComboBox();
			}
		});


		//Add components
		this.add(accountsComboBox);
	}	

	public void setComboBox(){
		accountsComboBox.setSelectedItem(AccManagerPanel.MARKET_ACC_PANEL);
	}

}