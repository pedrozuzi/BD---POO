package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Produto;

/**
 * Interface com os metodos a serem implementados de Produto
 * @author Hury
 *
 */
public interface ProdutoDao {

	int insereProduto(Produto prod) throws SQLException;

	void atualizaProduto(Produto prod) throws SQLException;

	void excluiProduto(Produto prod) throws SQLException;

	Produto consultaProduto(String id) throws SQLException; //Produto prod

	List<Produto> listaProduto(String nome) throws SQLException;

}
