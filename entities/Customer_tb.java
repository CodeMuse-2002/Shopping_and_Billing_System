
public class Customer_tb {
	int cust_id;
	String U_Name;
	String U_Email;
	String Password;

	public Customer_tb() {
	}

	public Customer_tb(int cust_id, String u_Name, String u_Email, String password) {
		this.cust_id = cust_id;
		this.U_Name = u_Name;
		this.U_Email = u_Email;
		this.Password = password;
	}

	public Customer_tb(String U_Name, String U_Email, String Password) {
		this.U_Name = U_Name;
		this.U_Email = U_Email;
		this.Password = Password;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public void setU_Name(String u_Name) {
		U_Name = u_Name;
	}

	public void setU_Email(String u_Email) {
		U_Email = u_Email;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getCust_id() {
		return cust_id;
	}

	public String getU_Name() {
		return U_Name;
	}

	public String getU_Email() {
		return U_Email;
	}

	public String getPassword() {
		return Password;
	}

	@Override
	public String toString() {
		return "Customer Id = " + cust_id + ", Name=" + U_Name + ", Email=" + U_Email;
	}

}