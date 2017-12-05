
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel {
	//Define components
	private JLabel title;
	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton createAccButton;

	public static int profile_id;
	public static String username;

	public LoginPanel() {
		this.setLayout(null);
		this.setBackground(Color.GRAY);

		//Styling
		title = new JLabel("StarsRus");
		title.setBounds(200,100,400,200);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(title.getFont().deriveFont(64.0f));

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(200, 250, 75, 25);
		usernameLabel.setHorizontalAlignment(JLabel.CENTER);

		usernameField = new JTextField();
		usernameField.setBounds(300, 250, 300, 25);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(200, 285, 75, 25);
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);

		passwordField = new JPasswordField();
		passwordField.setBounds(300, 285, 300, 25);

		loginButton = new JButton("LOGIN");
		loginButton.setBounds(240, 325, 150, 50);

		createAccButton = new JButton("CREATE ACCOUNT");
		createAccButton.setBounds(410, 325, 150, 50);

		//Event listeners
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String username = usernameField.getText();
				String password = passwordField.getText();

				if(authenticateUser(username, password) == true){
					System.out.println("Access Granted");
					CardLayout c = (CardLayout) (MainWindow.mainPanel.getLayout());
					c.show(MainWindow.mainPanel, MainWindow.TRADER_INTERFACE);
				}
			}
		});
		
		createAccButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout) (MainWindow.mainPanel.getLayout());
				c.show(MainWindow.mainPanel, MainWindow.CREATE_ACC_PANEL);
			}
		});

		//Add components
		this.add(title);
		this.add(usernameLabel);
		this.add(usernameField);
		this.add(passwordLabel);
		this.add(passwordField);
		this.add(loginButton);
		this.add(createAccButton);

	}

	public boolean authenticateUser(String username, String password) {
		UserController u = new UserController();
		boolean ret = u.authenticateUser(username, password);

		this.profile_id = u.getID();
		this.username = u.getUsername();

		return ret;
	}
}