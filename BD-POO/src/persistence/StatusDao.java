package persistence;

import java.sql.SQLException;

/**
 * Interface com o método para a classe StatusDaoImpl
 * @author Hury
 *
 */
public interface StatusDao {

	/**
	 * Método para verificação da conexão com o banco
	 * @param status
	 * @return String Online ou OffLine
	 * @throws SQLException exceção do banco de dados
	 */
	String status(String status) throws SQLException;

}
