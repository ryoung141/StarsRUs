
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
	public static JMenu optionsMenu;
	public static JMenuItem moviesMenuItem;
	public static JMenuItem logoutMenuItem;

	public static JDialog moviesDialog;


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

		//Movie Dialog
		moviesDialog = new JDialog();
		moviesDialog.setSize(400, 600);
		moviesDialog.setVisible(false);

		//MenuBar setup
		menuBar = new JMenuBar();
		optionsMenu = new JMenu("Options");

		moviesMenuItem = new JMenuItem("Movies");
		moviesMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MoviePanel mp = new MoviePanel();
				moviesDialog.add(mp);
				moviesDialog.setVisible(true);
			}
		});

		logoutMenuItem = new JMenuItem("Log Out");
		logoutMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Log out");
			}
		});

		optionsMenu.add(moviesMenuItem);
		optionsMenu.add(logoutMenuItem);
		menuBar.add(optionsMenu);

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