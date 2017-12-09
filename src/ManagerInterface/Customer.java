public class Customer {
	String firstName;
	String lastName;
	String stateCode;
	String phoneNum; //000-000-0000
	String email; 
	int taxID;
	String username;
	String password;

	public Customer(String firstName, String lastName, String stateCode, String phoneNum, String email, int taxID, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.stateCode = stateCode;
		this.phoneNum = phoneNum;
		this.email = email;
		this.taxID = taxID;
		this.username = username;
		this.password = password;
	}
}