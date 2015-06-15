package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.LoteProduto;

/**
 * Interface com os metodos de Lote de um Produto a serem implementados
 * @author Hury
 *
 */
public interface LoteProdutoDao {
	
	/**
	 * Método para inserção de um novo Lote e Produto ao
	 * banco de dados
	 * @param lotProd
	 * @throws SQLException
	 */
	void insereLoteProduto(LoteProduto lotProd) throws SQLException;

	/**
	 * Método para atualização de um Lote e Produto no banco
	 * de dados
	 * @param lotProd
	 * @throws SQLException
	 */
	void atualizaLoteProduto(LoteProduto lotProd) throws SQLException;

	/**
	 * Método para exclusão de um Lote e Produto no banco
	 * de dados
	 * @param lotProd
	 * @throws SQLException
	 */
	void excluiLoteProduto(LoteProduto lotProd) throws SQLException;

	/**
	 * Método para consulta de um Lote e um Produto
	 * @param lotProd
	 * @return Objeto LoteProduto
	 * @throws SQLException
	 */
	LoteProduto consultaLoteProduto(LoteProduto lotProd) throws SQLException;

	/**
	 * Método para buscar do banco de dados Objetos
	 * do tipo Lote e Produto
	 * @return List<LoteProduto> contendo as informações
	 * @throws SQLException
	 */
	List<LoteProduto> listaLoteProduto() throws SQLException;
}
