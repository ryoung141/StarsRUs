
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.*;

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
	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel confirmPasswordLabel;
	private JPasswordField confirmPasswordField;
	private JButton createAccButton;
	private JButton cancelButton;
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
		this.setBackground(Color.GRAY);

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
		phoneNumField2.setBounds(470, base + 2*(35), 35, 25);

		phoneNumField3 = new JTextField();
		phoneNumField3.setBounds(515, base + 2*(35), 45, 25);

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
		createAccButton.setBounds(240, base + 8*(35), 150, 50);

		cancelButton = new JButton("CANCEL");
		cancelButton.setBounds(410, base + 8*(35), 150, 50);

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
				boolean accReadyForCreation = true;
				errorMessage.setText("");

				if(!verifyName(firstName)) {
					errorMessage.setText("Error: First name must contain only characters");
					accReadyForCreation = false;
				}

				if(!verifyName(lastName)) {
					errorMessage.setText("Error: Last name must contain only characters");
					accReadyForCreation = false;
				}

				if(!verifyPhoneNum(phoneNum)) {
					errorMessage.setText("Error: Phone number must be formatted (000) 000-0000");
					accReadyForCreation = false;
				}

				if(!verifyEmail(email)) {
					errorMessage.setText("Error: Invalid email");
					accReadyForCreation = false;
				}

				if(!verifyTaxId(taxID)) {
					errorMessage.setText("Error: Invalid tax ID");
					accReadyForCreation = false;
				}

				if(!verifyUsername(username)) {
					errorMessage.setText("Error: Username can only contain letters and numbers");
					accReadyForCreation = false;
				}

				if(!verifySamePass(password, confirmPass)) {
					errorMessage.setText("Error: Passwords do not match");
					accReadyForCreation = false;
				}

				//Add to Datebase
				if(accReadyForCreation) {
					if(createUser(firstName, lastName, phoneNum, email, taxID, username, password)) {
						JDialog d = new JDialog();
						d.setSize(200, 100);
						JLabel msg = new JLabel("Account Created!");
						msg.setHorizontalAlignment(JLabel.CENTER);
						d.add(msg);
						d.setVisible(true);

						CardLayout c = (CardLayout) (MainWindow.mainPanel.getLayout());
						c.show(MainWindow.mainPanel, MainWindow.LOGIN_PANEL);

						//Clear inputs
						firstNameField.setText("");
						lastNameField.setText("");
						StateField.setSelectedIndex(0);
						phoneNumField1.setText(""); 
						phoneNumField2.setText(""); 
						phoneNumField3.setText("");
						emailField.setText("");
						taxIdField.setText("");
						usernameField.setText("");
						passwordField.setText("");
						confirmPasswordField.setText("");
					}
				}

				//Debug
				/*System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(stateCode);
				System.out.println(phoneNum);
				System.out.println(email);
				System.out.println(taxID);
				System.out.println(username);
				System.out.println(password);
				System.out.println(confirmPass);*/
			 }
		});

		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Clear inputs
				firstNameField.setText("");
				lastNameField.setText("");
				StateField.setSelectedIndex(0);
				phoneNumField1.setText(""); 
				phoneNumField2.setText(""); 
				phoneNumField3.setText("");
				emailField.setText("");
				taxIdField.setText("");
				usernameField.setText("");
				passwordField.setText("");
				confirmPasswordField.setText("");

				CardLayout c = (CardLayout) (MainWindow.mainPanel.getLayout());
				c.show(MainWindow.mainPanel, MainWindow.LOGIN_PANEL);
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
		this.add(cancelButton);
		this.add(errorMessage);


	}

	public boolean verifyName(String name) {
		String regex = "[a-zA-Z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	} 

	public boolean verifyPhoneNum(String phoneNum) {
		String regex = "[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNum);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEmail(String email) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTaxId(String taxID) {
		//TODO: Implement tax id
		return true;
	}

	public boolean verifyUsername(String username) {
		String regex = "[a-zA-Z0-9]+";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(username);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifySamePass(String pass1, String pass2) {
		if(pass1.equals(pass2)){
			return true;
		} else {
			return false;
		}
	}

	public boolean createUser(String firstName, String lastName, String phoneNum, String email, String taxID, String username, String password, String state){
		UserController u = new UserController();
		boolean ret = u.createUser(firstName, lastName, phoneNum, email, taxID, username, password, state);

		return ret;
	}

}