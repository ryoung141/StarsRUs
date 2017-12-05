
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AccManagerPanel extends JPanel{

	public static MarketAccPanel marketAccPanel;
	public static StockAccPanel stockAccPanel;
	public static AccountPanel[] accPanels = {marketAccPanel, stockAccPanel};

	public static final String MARKET_ACC_PANEL = "Market Account";
	public static final String STOCK_ACC_PANEL = "Stock Account";
	public static final String[] accounts = {MARKET_ACC_PANEL, STOCK_ACC_PANEL};

	public AccManagerPanel() {
		//JPanel characteristics
		this.setLayout(new CardLayout());

		//Define different panels
		marketAccPanel = new MarketAccPanel();
		stockAccPanel = new StockAccPanel();

		//Add components
		this.add(marketAccPanel, MARKET_ACC_PANEL);
		this.add(stockAccPanel, STOCK_ACC_PANEL);
	}	
}