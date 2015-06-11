package persistence;

import java.sql.SQLException;
import java.util.List;


import entity.VendaProduto;

/**
 * 
 * @author Hury
 *
 */

public interface VendaProdutoDao {

	void insereVenda(VendaProduto vendprod) throws SQLException;
	
	void atualizaVenda(VendaProduto vendprod) throws SQLException;

	void excluiVenda(VendaProduto vendprod) throws SQLException;
	
	List <VendaProduto> pesquisaVenda(VendaProduto vendprod) throws SQLException;
	
	
}
