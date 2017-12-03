
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TraderInterfacePanel extends JPanel{
	//Define components
	public static JPanel accManagerPanel;
	public static JPanel rightPanel;

	public TraderInterfacePanel() {
		//JPanel characteristics
		this.setLayout(new GridLayout(1,2));

		//Define different panels
		accManagerPanel = new AccManagerPanel();
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.GREEN);

		//Add components
		this.add(accManagerPanel);
		this.add(rightPanel);
		
	}	
}