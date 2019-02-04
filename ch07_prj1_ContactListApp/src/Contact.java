
public class Contact {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public Contact() {
		super();
	}

	public Contact(String firstName, String lastName, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	
	public String displayContact() {
		String s = "--------------------------------------------\r\n" + 
				"---- Current Contact -----------------------\r\n" + 
				"--------------------------------------------\r\n" + 
				"Name:           "+firstName+" "+lastName+"\r\n" + 
				"Email Address:  "+email+"\r\n" + 
				"Phone Number:   "+phone+"\r\n" + 
				"--------------------------------------------\r\n" + 
				"";
		return s;
	}
	
}
