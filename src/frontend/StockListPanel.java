
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
	
	public static ArrayList<String> stocks;
	public static HashMap<String, Stock> stocksMap;

	public StockListPanel() {
		stocks = new ArrayList<String>();
		stocksMap = new HashMap<String,Stock>();

		//Sample data
		addStock(SampleData.stock1);
		addStock(SampleData.stock2);
		addStock(SampleData.stock3);
		addStock(SampleData.stock4);
		addStock(SampleData.stock5);
		addStock(SampleData.stock6);
		addStock(SampleData.stock7);


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