
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow {

	private JFrame frame;
	public static JPanel mainPanel;
	public static final String LOGIN_PANEL = "Login Screen";
	public static final String CREATE_ACC_PANEL = "Create account";
	public static final String TRADER_INTERFACE = "Trader interface";

	public static JMenuBar menuBar;
	public static JMenu moviesMenu;
	public static JMenu logOutMenu;


	public MainWindow() {

		//Instantiate Frame
		frame = new JFrame();

		mainPanel = new JPanel(new CardLayout());

		JPanel card1 = new LoginPanel();
		JPanel card2 = new CreateAccPanel();
		JPanel card3 = new TraderInterfacePanel();

		mainPanel.add(card1, LOGIN_PANEL);
		mainPanel.add(card2, CREATE_ACC_PANEL);
		mainPanel.add(card3, TRADER_INTERFACE);

		frame.add(mainPanel);

		//Set window propertiers
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("StarsRus");
		frame.setSize(800, 600);
		frame.setVisible(true);

		//MenuBar setup
		menuBar = new JMenuBar();
		moviesMenu = new JMenu("Options");

		logOutMenu = new JMenu("Log Out");
		menuBar.add(moviesMenu);
		menuBar.add(logOutMenu);

		frame.setJMenuBar(menuBar);
		showMenu();
	}	

	public static void hideMenu(){
		menuBar.setVisible(false);
	}

	public static void showMenu(){
		menuBar.setVisible(true);
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