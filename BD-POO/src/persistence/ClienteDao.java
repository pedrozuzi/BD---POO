package persistence;

import java.sql.SQLException;
import java.util.List;
import entity.Cliente;

/**
 * Interface para os métodos do ClienteDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface ClienteDao {
	
	/**
	 * Método para inserção de um novo cliente ao
	 * banco de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exceção do banco de dados
	 */
	void inserirCliente(Cliente c) throws SQLException;
	
	/**
	 * Método para atualização de um cliente no banco
	 * de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exceção do banco de dados
	 */
	void atualizarCliente(Cliente c) throws SQLException;
	
	/**
	 * Método para exclusão de um cliente no banco
	 * de dados
	 * @param c Objeto Cliente
	 * @throws SQLException exceção do banco de dados
	 */
	void excluirCliente(Cliente c) throws SQLException;
	
	/**
	 * Método para buscar do banco de dados Objetos
	 * do tipo Cliente
	 * @param nome
	 * @return List<Cliente> contendo as informações
	 * @throws SQLException exceção do banco de dados
	 */
	List<Cliente> listaCliente(String nome) throws SQLException;

}
