package db;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	T get(String code);
	T get(int id);
	List<T> getAll() throws SQLException;
	boolean add(T t);
	boolean update(T t);
	boolean delete(T t);

}
