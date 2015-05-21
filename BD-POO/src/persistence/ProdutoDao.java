package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Lote;
import entity.Produto;

/**
 * 
 * @author Hury
 *
 */
public interface ProdutoDao {
	
	public abstract void insereProduto(Produto prod) throws SQLException;

	public abstract void atualizaProduto(Produto prod) throws SQLException;

	public abstract void excluiProduto(Produto prod) throws SQLException;

	public abstract Lote consultaProduto(Produto prod) throws SQLException;

	public abstract List<Produto> listaProduto() throws SQLException;
	

}
