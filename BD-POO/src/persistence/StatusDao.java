package persistence;

import java.sql.SQLException;

public interface StatusDao {

	String status(String status) throws SQLException;

}
