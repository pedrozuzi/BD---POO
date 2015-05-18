package connection;

import java.sql.Connection;

public interface GenericConnection {

	public Connection getConnection();
	public void fechaConexao(Connection con);
	
}