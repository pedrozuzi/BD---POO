package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Produto;

/**
 * Interface que possui os metodos Dao do produto
 * 
 * @author Hury
 *
 */

public interface ProdutoDao {

	/**
	 * Insere um Produto.
	 * @param prod
	 * @return
	 * @throws SQLException
	 */
	int insereProduto(Produto prod) throws SQLException;

	/**
	 * Atualiza um produto.
	 * @param prod
	 * @throws SQLException
	 */
	void atualizaProduto(Produto prod) throws SQLException;

	/**
	 * Exclui um produto.
	 * @param prod
	 * @throws SQLException
	 */
	void excluiProduto(Produto prod) throws SQLException;

	/**
	 * Consulta um produto a partir de um id;
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Produto consultaProduto(String id) throws SQLException;

	/**
	 * Lista produtos a partir de um nome.
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	List<Produto> listaProduto(String nome) throws SQLException;

}
