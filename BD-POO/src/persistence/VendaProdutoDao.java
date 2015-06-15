package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.VendaProduto;

/**
 * Interface que possui os metodos de VendaProduto
 * 
 * @author Hury
 *
 */

public interface VendaProdutoDao {

	/**
	 * Insere um produto a uma venda.
	 * @param vendprod
	 * @throws SQLException
	 */
	void insereVenda(VendaProduto vendprod) throws SQLException;

	/**
	 * Atualiza a relação venda produto;
	 * @param vendprod
	 * @throws SQLException
	 */
	void atualizaVenda(VendaProduto vendprod) throws SQLException;

	/**
	 * Exclui uma relação venda produto.
	 * @param vendprod
	 * @throws SQLException
	 */
	void excluiVenda(VendaProduto vendprod) throws SQLException;

	/**
	 * Pesquisa uma relação entre venda e produtos.
	 * @param vendprod
	 * @return
	 * @throws SQLException
	 */
	List<VendaProduto> pesquisaVenda(VendaProduto vendprod) throws SQLException;

}
