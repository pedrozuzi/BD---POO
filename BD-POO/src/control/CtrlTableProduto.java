package control;

import java.sql.SQLException;
import java.util.List;
import entity.Produto;

public interface CtrlTableProduto {

	List<Produto> BuscaProdutoPorNome(String nome) throws SQLException;
	Produto concultaProdutoId(String id )  throws SQLException;
}
