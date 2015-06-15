package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionImpl;
import connection.GenericConnection;

/**
 * Classe para comunicação com o banco para 
 * verificação da conexão com o banco de dados
 * @author Hury
 *
 */
public class StatusDaoImpl implements StatusDao {

	private Connection c;

	/**
	 * Construtor
	 */
	public StatusDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}

	/**
	 * Método para inserção de um novo cliente ao
	 * banco de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exceção do banco de dados
	 */
	@Override
	public String status(String status) throws SQLException {

		String sql = "select name, state_desc from sys.databases where name like ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "ludpet");
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			status= rs.getString("state_desc");
		}

		ps.close();
		return status;
	}

}
