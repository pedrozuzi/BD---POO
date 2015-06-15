package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Fornecedor;

/**
 * Ineterface para os métodos da classe FornecedorDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface FornecedorDao {
	
	/**
	 * Método para inserção de um novo Fornecedor ao
	 * banco de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exceção do banco de dados
	 */
	void inserirFornecedor(Fornecedor f) throws SQLException;
	
	/**
	 * Método para atualização de um Fornecedor no banco
	 * de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exceção do banco de dados
	 */
	void atualizarFornecedor(Fornecedor f) throws SQLException;
	
	/**
	 * Método para exclusão de um Fornecedor no banco
	 * de dados
	 * @param f Objeto Fornecedor
	 * @throws SQLException exceção do banco de dados
	 */
	void excluirFornecedor(Fornecedor f) throws SQLException;
	
	/**
	 * Método para buscar do banco de dados Objetos
	 * do tipo Fornecedor
	 * @param nome
	 * @return  List<Fornecedor> contendo as informações
	 * @throws SQLException exceção do banco de dados
	 */
	List<Fornecedor> listaFornecedor(String nome) throws SQLException;

}
