package persistence;

import java.sql.SQLException;
import entity.Pessoa;

/**
 * Interface com os métodos para a classe PessoaDaoImpl
 * @author Pedro Zuzi
 * @author Pedro Afonso
 *
 */
public interface PessoaDao {
	
	/**
	 * Método para inserção de um nova Pessoa ao
	 * banco de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exceção do banco de dados
	 */
	void inserePessoa(Pessoa pes) throws SQLException;
	
	/**
	 * Método para atualização de uma Pessoa no banco
	 * de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exceção do banco de dados
	 */
	void atualizaPessoa(Pessoa pes) throws SQLException;
	
	/**
	 * Método para exclusão de uma Pessoa no banco
	 * de dados
	 * @param pes Objeto Pessoa
	 * @throws SQLException exceção do banco de dados
	 */
	void excluiPessoa(Pessoa pes) throws SQLException;
}
