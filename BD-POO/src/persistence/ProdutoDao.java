package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Produto;

/**
 * 
 * @author Hury
 *
 */
public interface ProdutoDao {

	int insereProduto(Produto prod) throws SQLException;

	void atualizaProduto(Produto prod) throws SQLException;

	void excluiProduto(Produto prod) throws SQLException;

	Produto consultaProduto(Produto prod) throws SQLException;

	List<Produto> listaProduto() throws SQLException;

}
