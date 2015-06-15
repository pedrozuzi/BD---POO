package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Venda;

/**
 * Interface com os metodos da venda.
 * 
 * @author Hury
 *
 */

public interface VendaDao {

	/**
	 * Insere uma venda.
	 * @param vend
	 * @throws SQLException
	 */
	void insereVenda(Venda vend) throws SQLException;

	/**Atualiza uma venda.
	 * 
	 * @param vend
	 * @throws SQLException
	 */
	void atualizaVenda(Venda vend) throws SQLException;

	/**
	 * Exclui uma venda.
	 * @param vend
	 * @throws SQLException
	 */
	void excluiVenda(Venda vend) throws SQLException;

	/**
	 * Pesquisa uma venda.
	 * @param vend
	 * @return
	 * @throws SQLException
	 */
	List<Venda> pesquisaVenda(Venda vend) throws SQLException;

}
