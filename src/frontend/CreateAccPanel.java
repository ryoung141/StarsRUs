
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
	private JComboBox StateField;
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
	private JLabel errorMessage;
	

	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

	String[] stateCodes = {
								"AL",
								"AK",
								"AZ",
								"AR",
								"CA",
								"CO",
								"CT",
								"DE",
								"DC",
								"FL",
								"GA",
								"HI",
								"ID",
								"IL",
								"IN",
								"IA",
								"KS",
								"KY",
								"LA",
								"ME",
								"MT",
								"NE",
								"NV",
								"NH",
								"NJ",
								"NM",
								"NY",
								"NC",
								"ND",
								"OH",
								"OK",
								"OR",
								"MD",
								"MA",
								"MI",
								"MN",
								"MS",
								"MO",
								"PA",
								"RI",
								"SC",
								"SD",
								"TN",
								"TX",
								"UT",
								"VT",
								"VA",
								"WA",
								"WV",
								"WI",
								"WY"};

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

		StateField = new JComboBox(stateCodes);
		StateField.setBounds(300, base + 2*(35), 50, 25);

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

		errorMessage = new JLabel();
		errorMessage.setHorizontalAlignment(JLabel.CENTER);
		errorMessage.setBounds(200, base + 9*(35), 400, 50);

		//Event listeners
		createAccButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Get inputs
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String stateCode = String.valueOf(StateField.getSelectedItem());
				String phoneNum = phoneNumField1.getText() + "-" 
								+ phoneNumField2.getText() + "-" 
								+ phoneNumField3.getText();
				String email = emailField.getText();
				String taxID = taxIdField.getText();
				String username = usernameField.getText();
				String password = passwordField.getText();
				String confirmPass = confirmPasswordField.getText();

				//Verify Inputs
				errorMessage.setText("");

				if(!verifyName(firstName)) {
					errorMessage.setText("Error: First name must contain only characters");
				}

				if(!verifyName(lastName)) {
					errorMessage.setText("Error: Last name must contain only characters");
				}

				if(!verifyPhoneNum(phoneNum)) {
					errorMessage.setText("Error: Phone number must be formatted (000) 000-0000");
				}

				if(!verifyEmail(email)) {
					errorMessage.setText("Error: Invalid email");
				}

				if(!verifyTaxId(taxID)) {
					errorMessage.setText("Error: Invalid tax ID");
				}

				if(!verifyUsername(username)) {
					errorMessage.setText("Error: Username can only contain letters and numbers");
				}

				if(!verifySamePass(password, confirmPass)) {
					errorMessage.setText("Error: Passwords do not match");
				}

				//Debug
				System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(stateCode);
				System.out.println(phoneNum);
				System.out.println(email);
				System.out.println(taxID);
				System.out.println(username);
				System.out.println(password);
				System.out.println(confirmPass);
			 }
		});

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
		this.add(errorMessage);


	}

	public boolean verifyName(String name) {
		return true;
	} 

	public boolean verifyPhoneNum(String phoneNum) {
		return true;
	}

	public boolean verifyEmail(String email) {
		return true;
	}

	public boolean verifyTaxId(String taxID) {
		return true;
	}

	public boolean verifyUsername(String username) {
		return true;
	}

	public boolean verifySamePass(String pass1, String pass2) {
		if(pass1.equals(pass2)){
			return true;
		} else {
			return false;
		}
	}

}