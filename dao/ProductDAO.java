

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.*;

import com.sunbeam.utils.DbUtil;

public class ProductDAO implements AutoCloseable{
private Connection connection;
	
	public ProductDAO() throws SQLException {
		connection = DbUtil.getConnection();
	}
	
	public List<Product_tb> getProductSorted() throws SQLException{
		String sql = "SELECT * FROM product_tb ORDER BY Price";
		List<Product_tb> prodList = new ArrayList<Product_tb>();
		try(PreparedStatement selectSt = connection.prepareStatement(sql)){
			ResultSet rs = selectSt.executeQuery();
			while(rs.next())
			{
				Product_tb p = new Product_tb(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDouble(4),rs.getInt(5));
				prodList.add(p);
			}
		}
		return prodList;
	}
	
	public void addProduct(Product_tb p) throws SQLException {
		String sql = "INSERT INTO product_tb(P_name,PurchaseDate,Price,U_id) VALUES (?,'2023-09-20',?,?)";
		try(PreparedStatement insertSt = connection.prepareStatement(sql)){
			insertSt.setString(1, p.getP_name());
			insertSt.setDouble(2, p.getPrice());
			insertSt.setInt(3, p.getU_id());
			insertSt.executeUpdate();
		}
	}
	
	public void generateBill(int id) throws SQLException {
		double sum;
		List<Integer> l1 = new ArrayList<Integer>();
		String sql = "SELECT SUM(Price) FROM product_tb WHERE U_id = ?";
		try(PreparedStatement selectSt = connection.prepareStatement(sql))
		{
			selectSt.setInt(1,id);
			ResultSet rs = selectSt.executeQuery();
			while(rs.next())
			{
				sum = rs.getDouble(1);
				System.out.println(sum);
			}
			
			
		}
	}
	
	public List<Product_tb> searchProduct(int id) throws SQLException {
		List<Product_tb> pList = new ArrayList<Product_tb>();
		String sql = "SELECT * FROM product_tb WHERE p_id = ?";
		try(PreparedStatement st = connection.prepareStatement(sql)){
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Product_tb p = new Product_tb(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDouble(4),rs.getInt(5));
				pList.add(p);
			}
		}
		return pList;
	}

	@Override
	public void close() throws Exception {
		if(connection != null)
		{
			connection.close();
		}
		
	}
}
