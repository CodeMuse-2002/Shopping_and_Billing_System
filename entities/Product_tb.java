
import java.sql.Date;

public class Product_tb {
	int p_id;
	String P_name;
	Date PurchaseDate;
	double Price;
	int U_id;

	public Product_tb() {
	}

	public Product_tb(int p_id, String p_name, Date purchaseDate, double price, int u_id) {
		super();
		this.p_id = p_id;
		P_name = p_name;
		PurchaseDate = purchaseDate;
		Price = price;
		U_id = u_id;
	}

	public Product_tb(String pname, Date date, double price, int id) {
		P_name = pname;
		PurchaseDate = date;
		Price = price;
		U_id = id;
	}

	public Product_tb(String pname, double price, int id) {
		P_name = pname;
		Price = price;
		U_id = id;
	}

	public Product_tb(int id) {
		p_id = id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public void setP_name(String p_name) {
		P_name = p_name;
	}

	public void setPurchaseDate(Date purchaseDate) {
		PurchaseDate = purchaseDate;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public void setU_id(int u_id) {
		U_id = u_id;
	}

	public int getP_id() {
		return p_id;
	}

	public String getP_name() {
		return P_name;
	}

	public Date getPurchaseDate() {
		return PurchaseDate;
	}

	public double getPrice() {
		return Price;
	}

	public int getU_id() {
		return U_id;
	}

	@Override
	public String toString() {
		return "Product Id = " + p_id + ", Name = " + P_name + ", PurchaseDate = " + PurchaseDate + ", Price = " + Price
				+ ", User Id = " + U_id;
	}

}
