package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public Product get(String code) {
		Product product = null;
		String sql = "Select * from Product"
				+ "	where code = ?";
		try (Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, code);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = getProductFromResultSet(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product get(int id) {
		
		Product product = null;
		String sql = "Select * from Product	where id = ?";
		try (Connection conn = getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = getProductFromResultSet(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	// NOTE:  Not using a PreparedStatement to retain an example of 
	// using the Statement object
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
    public boolean add(Product p) {
    	boolean success = false;
        String sql = "INSERT INTO Product (code, description, listprice) "
                   + "VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getCode());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            int rowCount = ps.executeUpdate();
            if (rowCount > 0)
            	success = true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return success;
    }

    @Override
    public boolean update(Product p) {
    	boolean success = false;
        String sql = "UPDATE Product SET "
                   + "  Description = ? "
                   + "WHERE Code = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getDescription());
            ps.setString(2, p.getCode());
            int rowCount = ps.executeUpdate();
            if (rowCount > 1)
            	success = true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return success;
    }

    @Override
    public boolean delete(Product p) {
		boolean success = false;
        String sql = "DELETE FROM Product "
                   + "WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, p.getId());
            int rowCount = ps.executeUpdate();
            if (rowCount>1)
            	success = true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return success;
    }


}
