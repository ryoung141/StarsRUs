
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StockManagerPanel extends JPanel{

	public StockListPanel stockListPanel;


	public static final String STOCK_LIST_PANEL = "Stock List";
	public static final String[] stockPanelList = {STOCK_LIST_PANEL};

	public StockManagerPanel() {
		//JPanel characteristics
		this.setLayout(new CardLayout());

		//Define different panels
		stockListPanel = new StockListPanel();

		//Add components
		this.add(stockListPanel, STOCK_LIST_PANEL);
	}	
}