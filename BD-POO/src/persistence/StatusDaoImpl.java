package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionImpl;
import connection.GenericConnection;

public class StatusDaoImpl implements StatusDao {

	private Connection c;

	public StatusDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}

	public String status() throws SQLException {
		String status = "OFFLINE";

		String sql = "select name, state_desc from sys.databases where name like ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "ludpet");
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			status= rs.getString("state_desc");
		}

		ps.close();
		System.out.println(status);
		return status;
	}

}
