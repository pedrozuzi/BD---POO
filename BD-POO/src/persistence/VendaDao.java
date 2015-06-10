package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Venda;

/**
 * 
 * @author Hury
 *
 */

public interface VendaDao {
	
	void insereVenda(Venda vend) throws SQLException;
	
	void atualizaVenda(Venda vend) throws SQLException;

	void excluiVenda(Venda vend) throws SQLException;
	
	List <Venda> pesquisaVenda(Venda vend) throws SQLException;
	
}
