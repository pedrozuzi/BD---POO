package persistence;

import java.sql.SQLException;

import entity.Usuario;

/**
 * Interface para o método da classe LoginDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface LoginDao {
	
	/**
	 * Método para verficar as credenciais do usuário
	 * @param u Objeto Usuário
	 * @return true se usuário existe, false se não existe
	 * @throws SQLException exceção do banco de dados
	 */
	boolean realizarLogin(Usuario u) throws SQLException;

}
