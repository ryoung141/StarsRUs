
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;

public class StockListPanel extends JPanel{
	//Define components
	private JLabel title;
	private JList stockList;
	private JScrollPane scrollContainer;
	public static StockDetailPanel stockDetailPanel;

	Stock stock1;
	Stock stock2;
	Stock stock3;
	Stock stock4;
	Stock stock5;
	Stock stock6;
	Stock stock7;

	String[] text = {"Hello"};

	public static ArrayList<String> stocks;
	public static HashMap<String, Stock> stocksMap;

	public StockListPanel() {
		stocks = new ArrayList<String>();
		stocksMap = new HashMap<String,Stock>();

		//Sample data
		stock1 = new Stock("JOA", "Jordan Ang", 1234.22, 3230.14);
		stock2 = new Stock("JOH", "John Harm", 3032.22, 10.20);
		stock3 = new Stock("KEN", "Kenn Huynh", 55.32, 2022.12);
		stock4 = new Stock("KAL", "Kall Allen", 3551.32, 253.12);
		stock5 = new Stock("FRE", "Fomo Eagel", 6533.32, 755.12);
		stock6 = new Stock("MON", "Moreal Nguyen", 655.32, 85.12);
		stock7 = new Stock("TOU", "Tom Uynh", 557.32, 43.12);
		addStock(stock1);
		addStock(stock2);
		addStock(stock3);
		addStock(stock4);
		addStock(stock5);
		addStock(stock6);
		addStock(stock7);


		//JPanel characteristics
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		//Styling
		int base = 25;
		title = new JLabel("Stock List");
		title.setBounds(100, base, 200, 50);
		title.setFont(title.getFont().deriveFont(24.0f));
		title.setHorizontalAlignment(JLabel.CENTER);

		stockList = new JList(stocks.toArray());
		scrollContainer = new JScrollPane(stockList);
		scrollContainer.setBounds(50, base + 50, 300, 100);
		scrollContainer.setVerticalScrollBar(new JScrollBar());

		stockDetailPanel = new StockDetailPanel();
		stockDetailPanel.setBounds(0, base + 175, 400, 800 - (base + 175));

		//Event listeners
		stockList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				String selectedItem = (String) stockList.getSelectedValue();
				if(selectedItem != null){
					Stock s = stocksMap.get(selectedItem);
					stockDetailPanel.changeDetail(s);
					stockDetailPanel.makeVisible();
				}
			}
		});

		stockList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String selectedItem = (String) stockList.getSelectedValue();
					if(selectedItem != null){
						Stock s = stocksMap.get(selectedItem);
						stockDetailPanel.changeDetail(s);
						stockDetailPanel.makeVisible();
					}
				}
			}
		});

		//Add components
		this.add(title);
		this.add(scrollContainer);
		this.add(stockDetailPanel);
	}	

	public void addStock(Stock s){
		stocks.add(s.getSymbol());
		stocksMap.put(s.getSymbol(), s);
		return;
	}
}