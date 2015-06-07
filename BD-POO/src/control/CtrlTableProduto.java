package control;

import java.sql.SQLException;
import java.util.List;
import entity.Produto;

/**
 * Interface que possui metodos a serem implementados, de tabela.
 * @author Hury
 *
 */

public interface CtrlTableProduto {

	List<Produto> buscaProdutoPorNome(String nome) throws SQLException;
	Produto concultaProdutoId(String id )  throws SQLException;
}
