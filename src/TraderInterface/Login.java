import java.util.regex.*;
import java.util.Scanner;

public class Login {

	private String userInput;
	private Scanner scan;

	String username;
	String password;

	public Login(){
		
		print("\n****LOGIN****");

		print("\n*Enter username");
		getFormInput();	
		username = userInput;

		print("\n*Enter password");
		getFormInput();	
		password = userInput;

		if(authenticateUser(username, password)) {
			TraderInterface.loggedIn = true;
			TraderInterface.username = username;
			TraderInterface.password = password;
			print("\n****LOGIN SUCCESSFUL****\n");
		} else {
			print("\n****ERROR: INCORRECT USERNAME OR PASSWORD****");
		}

	}

	public void getFormInput() {
		scan = new Scanner(System.in);
		userInput = scan.next();
	}

	public static void print(String p){
		System.out.println(p);
	}

	public boolean authenticateUser(String username, String password) {
		UserController u = new UserController();
		boolean ret = u.authenticateUser(username, password);

		/*this.profile_id = u.getID();
		this.username = u.getUsername();*/

		return true;
	}
	
}