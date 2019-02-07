package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Product;

public class ProductDB implements DAO<Product> {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/mma";
		String username = "mma_user";
		String pwd = "sesame";
		Connection connection = DriverManager.getConnection(
				dbUrl, username, pwd);
		return connection;
	}
	
	@Override
	public Product get(String code)  throws SQLException{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Product"
				+ "	where code = '"+code+"'");
		Product product = null;
		while (rs.next()) {
			product = getProductFromResultSet(rs);
		}
		rs.close();
		return product;
	}

	@Override
	public Product get(int id) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Product	where id = "+id);
		Product product = null;
		while (rs.next()) {
			product = getProductFromResultSet(rs);
		}
		rs.close();
		return product;
	}

	@Override
	public List<Product> getAll() throws SQLException {
		List<Product> products = new ArrayList<Product>();
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Product");
		while (rs.next()) {
			Product pdt = getProductFromResultSet(rs);
			products.add(pdt);
		}
		rs.close();
		return products;
	}

	private Product getProductFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String code = rs.getString(2);
		String desc = rs.getString(3);
		double price = rs.getDouble(4);
		Product pdt = new Product(id, code, desc, price);
		return pdt;
	}

	@Override
	public boolean add(Product pdt) throws SQLException {
		boolean success = false;
		String query = "insert into product (code, description, listprice)" + 
				" values ('" + pdt.getCode() + "', '" + pdt.getDescription()
				+ "', " + pdt.getPrice() + ")";
		Statement stmt = getConnection().createStatement();
		int rowCount = stmt.executeUpdate(query);
		if (rowCount > 0)
			success = true;
		return success;
	}

	@Override
	public boolean update(Product pdt) throws SQLException {
		boolean success = false;
		String query = "update product" + 
				" set description =  '" + pdt.getDescription() + "'" + 
				" where id = " + pdt.getId();
		Statement stmt = getConnection().createStatement();
		int rowCount = stmt.executeUpdate(query);
		if (rowCount > 0)
			success = true;
		return success;
	}

	@Override
	public boolean delete(Product pdt) throws SQLException {
		boolean success = false;
		String query = "delete from product where id = " + pdt.getId();
		Statement stmt = getConnection().createStatement();
		int rowCount = stmt.executeUpdate(query);
		if (rowCount > 0)
			success = true;
		return success;
	}

}
