
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StockListPanel extends JPanel{
	//Define components
	private JLabel title;
	private JList stockList;
	private JScrollPane scrollContainer;

	String[] stocks = {"Jordan", "John", "Kenn", "Jose", "George", "Jeff", "Fonee", "Lowry"};

	public StockListPanel() {
		//JPanel characteristics
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		//Styling
		int base = 25;
		title = new JLabel("Stock List");
		title.setBounds(100, base, 200, 50);
		title.setFont(title.getFont().deriveFont(24.0f));
		title.setHorizontalAlignment(JLabel.CENTER);

		stockList = new JList(stocks);
		scrollContainer = new JScrollPane(stockList);
		scrollContainer.setBounds(50, base + 50, 300, 100);
		scrollContainer.setVerticalScrollBar(new JScrollBar());

		//Event listeners
		stockList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				String selectedItem = (String) stockList.getSelectedValue();
				System.out.println(selectedItem);
			}
		});

		stockList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String selectedItem = (String) stockList.getSelectedValue();
					System.out.println(selectedItem);
				}
			}
		});

		//Add components
		this.add(title);
		this.add(scrollContainer);
	}	
}