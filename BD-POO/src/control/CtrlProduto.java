package control;

import java.sql.SQLException;
import java.util.List;

import entity.Produto;


/**
 * 
 * @author Hury
 *
 */
public interface CtrlProduto {

	public void listaProduto() throws SQLException;
	public List<Produto> listaFinalProduto() 
			throws SQLException;
	
}
