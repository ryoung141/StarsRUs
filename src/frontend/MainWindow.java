
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow {

	private JFrame frame;
	public static JPanel mainPanel;
	public static final String LOGIN_PANEL = "Login Screen";
	public static final String CREATE_ACC_PANEL = "Create account";
	public static final String TRADER_INTERFACE = "Trader interface";

	public MainWindow() {

		//Instantiate Frame
		frame = new JFrame();

		mainPanel = new JPanel(new CardLayout());

		JPanel card1 = new LoginPanel();
		JPanel card2 = new CreateAccPanel();

		mainPanel.add(card1, LOGIN_PANEL);
		mainPanel.add(card2, CREATE_ACC_PANEL);

		frame.add(mainPanel);

		//Set window propertiers
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("StarsRus Login");
		frame.setSize(800, 600);
		frame.setVisible(true);
	}	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow();
			}
		});
	}

}