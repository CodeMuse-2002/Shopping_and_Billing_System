

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sunbeam.entities.Customer_tb;
import com.sunbeam.utils.DbUtil;

public class CustomerDAO implements AutoCloseable{
	private Connection connection;
	
	public CustomerDAO() throws SQLException {
		connection = DbUtil.getConnection();
	}
	
	public void addCustomer(Customer_tb c) throws SQLException {
		String sql = "INSERT INTO customer_tb(U_Name,U_Email,Password) VALUES (?,?,?)";
		try(PreparedStatement insertSt = connection.prepareStatement(sql)){
			insertSt.setString(1, c.getU_Name());
			insertSt.setString(2, c.getU_Email());
			insertSt.setString(3, c.getPassword());
			insertSt.executeUpdate();
		}
	}
	
	public void updateCustomer(String name, int id) throws SQLException {
		String sql = "UPDATE customer_tb SET U_Name = ? WHERE cust_id = ?";
		try(PreparedStatement updateSt = connection.prepareStatement(sql)){
			updateSt.setString(1, name);
			updateSt.setInt(2, id);
			updateSt.executeUpdate();
		}
	}

	@Override
	public void close() throws Exception {
		if(connection != null)
		{
			connection.close();
		}
		
	}
}

