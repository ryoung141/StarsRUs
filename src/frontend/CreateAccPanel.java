
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateAccPanel extends JPanel {
	//Define components
	private JLabel title;
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JLabel StateLabel;
	private JTextField StateField;
	private JLabel phoneNumLabel;
	private JTextField phoneNumField1;
	private JTextField phoneNumField2;
	private JTextField phoneNumField3;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel taxIdLabel;
	private JTextField taxIdField;
	private JButton createAccButton;
	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel confirmPasswordLabel;
	private JPasswordField confirmPasswordField;
	

	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

	public CreateAccPanel() {
		this.setLayout(null);
		this.setBackground(Color.green);

		int base = 150;

		//Styling
		title = new JLabel("Create Account");
		title.setBounds(200,0,400,200);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(title.getFont().deriveFont(32.0f));

		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(200, base, 75, 25);
		firstNameLabel.setHorizontalAlignment(JLabel.CENTER);

		firstNameField = new JTextField();
		firstNameField.setBounds(300, base, 300, 25);

		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(200, base + 35, 75, 25);
		lastNameLabel.setHorizontalAlignment(JLabel.CENTER);

		lastNameField = new JTextField();
		lastNameField.setBounds(300, base + 35, 300, 25);

		StateLabel = new JLabel("State Code");
		StateLabel.setBounds(200, base + 2*(35), 75, 25);
		StateLabel.setHorizontalAlignment(JLabel.CENTER);

		StateField = new JTextField();
		StateField.setBounds(300, base + 2*(35), 25, 25);

		phoneNumLabel = new JLabel("Phone #");
		phoneNumLabel.setBounds(350, base + 2*(35), 75, 25);
		phoneNumLabel.setHorizontalAlignment(JLabel.CENTER);

		phoneNumField1 = new JTextField();
		phoneNumField1.setBounds(425, base + 2*(35), 35, 25);

		phoneNumField2 = new JTextField();
		phoneNumField2.setBounds(470, base + 2*(35), 35, 23);

		phoneNumField3 = new JTextField();
		phoneNumField3.setBounds(515, base + 2*(35), 45, 23);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(200, base + 3*(35), 75, 25);
		emailLabel.setHorizontalAlignment(JLabel.CENTER);

		emailField = new JTextField();
		emailField.setBounds(300, base + 3*(35), 300, 25);

		taxIdLabel = new JLabel("Tax ID");
		taxIdLabel.setBounds(200, base + 4*(35), 75, 25);
		taxIdLabel.setHorizontalAlignment(JLabel.CENTER);

		taxIdField = new JTextField();
		taxIdField.setBounds(300, base + 4*(35), 100, 25);

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(200, base + 5*(35), 75, 25);
		usernameLabel.setHorizontalAlignment(JLabel.CENTER);

		usernameField = new JTextField();
		usernameField.setBounds(300, base + 5*(35), 300, 25);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(200, base + 6*(35), 75, 25);
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);

		passwordField = new JPasswordField();
		passwordField.setBounds(300, base + 6*(35), 300, 25);

		confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setBounds(200, base + 7*(35), 75, 25);
		confirmPasswordLabel.setHorizontalAlignment(JLabel.CENTER);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(300, base + 7*(35), 300, 25);

		createAccButton = new JButton("CREATE ACCOUNT");
		createAccButton.setBounds(325, base + 8*(35), 150, 50);

		//Event listeners

		//Add components
		this.add(title);
		this.add(firstNameLabel);
		this.add(firstNameField);
		this.add(lastNameLabel);
		this.add(lastNameField);
		this.add(StateLabel);
		this.add(StateField);
		this.add(phoneNumLabel);
		this.add(phoneNumField1);
		this.add(phoneNumField2);
		this.add(phoneNumField3);
		this.add(emailLabel);
		this.add(emailField);
		this.add(taxIdLabel);
		this.add(taxIdField);
		this.add(usernameLabel);
		this.add(usernameField);
		this.add(passwordLabel);
		this.add(passwordField);
		this.add(confirmPasswordLabel);
		this.add(confirmPasswordField);
		this.add(createAccButton);


	}

}