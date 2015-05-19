package persistence;

import java.sql.Connection;

/**
 * 
 * @author Hury
 *
 */
public interface GenericDao {

	public Connection getConnection();
	public void fechaConexao(Connection con);
	
}
