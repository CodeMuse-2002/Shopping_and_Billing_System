
public class Cart_tb {
	int cust_id;
	int p_id;
	double total_bill;

	public Cart_tb() {
	}

	public Cart_tb(int cust_id, int p_id, double total_bill) {
		this.cust_id = cust_id;
		this.p_id = p_id;
		this.total_bill = total_bill;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public void setTotal_bill(double total_bill) {
		this.total_bill = total_bill;
	}

	public int getCust_id() {
		return cust_id;
	}

	public int getP_id() {
		return p_id;
	}

	public double getTotal_bill() {
		return total_bill;
	}

	@Override
	public String toString() {
		return "Customer Id = " + cust_id + ", Product Id = " + p_id + ", Total bill = " + total_bill;
	}
}
