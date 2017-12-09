import java.util.regex.*;
import java.util.Scanner;

public class CreateAccount {

	private String userInput;
	private Scanner scan;

	String firstName;
	String lastName;
	String stateCode;
	String phoneNum;
	String email;
	int taxID;
	String username;
	String password;
	String confirmPass;

	boolean validInput;

	public CreateAccount(){
		
		print("\n****CREATE ACCOUNT****");

		print("\n*Enter first name");
		validInput = false;
		while(validInput == false) {
			getFormInput();
			if(verifyName(userInput)) {
				validInput = true;
			} else {
				print("Error: Please enter a name containing only letters");
			}
		}

		print("\n*Enter last name");
		validInput = false;
		while(validInput == false) {
			getFormInput();
			if(verifyName(userInput)) {
				validInput = true;
			} else {
				print("Error: Please enter a name containing only letters");
			}
		}

		print("\n*Enter two character state code");
		validInput = false;
		while(validInput == false) {
			getFormInput();
			if(verifyStateCode(userInput)) {
				validInput = true;
			} else {
				print("Error: Please enter a two character state code");
			}
		}

		print("\n*Enter phone number (format: 000-000-0000)");
		validInput = false;
		while(validInput == false) {
			getFormInput();
			if(verifyPhoneNum(userInput)) {
				validInput = true;
			} else {
				print("Error: Please enter a phone number (format: 000-000-0000)");
			}
		}

		print("\n*Enter email address");
		validInput = false;
		while(validInput == false) {
			getFormInput();
			if(verifyEmail(userInput)) {
				validInput = true;
			} else {
				print("Error: Please enter a proper email address");
			}
		}

		print("\n*Enter tax ID");
		validInput = false;
		while(validInput == false) {
			getFormInput();
			if(verifyTaxId(userInput)) {
				validInput = true;
			} else {
				print("Error: Please enter a valid tax ID");
			}
		}

		print("\n*Enter username");
		validInput = false;
		while(validInput == false) {
			getFormInput();
			if(verifyUsername(userInput)) {
				validInput = true;
			} else {
				print("Error: Please enter a username containg only letters and numbers");
			}
		}

		print("\n*Enter password");
		validInput = false;
		while(validInput == false) {
			getFormInput();
			if(verifyPassword(userInput)) {
				validInput = true;
			} else {
				print("Error: Please enter a password containg only letters and numbers");
			}
		}

		if(createUser(firstName, lastName, phoneNum, email, taxID, username, password, stateCode)) {
			print("\n****ACCOUNT HAS BEEN CREATED****\n");
		} else {
			print("\n****ERROR: COULD NOT CREATE ACCOUNT****");
		}

	}

	public void getFormInput() {
		scan = new Scanner(System.in);
		userInput = scan.next();
	}

	public static void print(String p){
		System.out.println(p);
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

	public boolean verifyStateCode(String stateCode) {
		String regex = "[a-zA-Z][a-zA-Z]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(stateCode);

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
		String regex = "[0-9]+";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(taxID);

		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
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

	public boolean verifyPassword(String password) {
		String regex = "[a-zA-Z0-9]+";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(password);

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

	public boolean createUser(String firstName, String lastName, String phoneNum, String email, int taxID, String username, String password, String state){
		/*UserController u = new UserController();
		boolean ret = u.createUser(firstName, lastName, phoneNum, email, Integer.parseInt(taxID), username, password, state);*/

		return true;
	}
}