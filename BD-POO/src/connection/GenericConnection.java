package connection;

import java.sql.Connection;

/**
 * Interface que possui os metodos de conexão.
 * @author 
 *
 */

public interface GenericConnection {

	public Connection getConnection();
	public void fechaConexao(Connection con);
	
}