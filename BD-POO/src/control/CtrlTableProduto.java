package control;

import java.sql.SQLException;
import java.util.List;
import entity.Produto;

/**
 * Interface que possui os métodos da Table/Produto
 * 
 * @author Hury
 *
 */
public interface CtrlTableProduto {

	/**
	 * Busca um produto a partir de um nome.
	 * 
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	List<Produto> buscaProdutoPorNome(String nome) throws SQLException;

	/**
	 * Consulta um produto a partir de um id.
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Produto concultaProdutoId(String id) throws SQLException;
}
