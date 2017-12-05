
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TraderInterfacePanel extends JPanel{
	//Define components
	public static JPanel accManagerPanel;
	public static JPanel stockManagerPanel;

	public static SampleData sampleData = new SampleData();

	public TraderInterfacePanel() {
		//JPanel characteristics
		this.setLayout(new GridLayout(1,2));

		//Define different panels
		accManagerPanel = new AccManagerPanel();

		stockManagerPanel = new StockManagerPanel();

		//Add components
		this.add(accManagerPanel);
		this.add(stockManagerPanel);
		
	}	
}