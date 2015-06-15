package control;

import java.sql.SQLException;
import java.util.List;

import entity.Lote;

/**
 * Interface que possui os métodos da Table/Lote
 * 
 * @author Hury
 *
 */

public interface CtrlTableLote {

	/**
	 * Busca todos os lotes relacionados a um produto
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	List<Lote> buscaLotePorProduto(int id) throws SQLException;

	/**
	 * consulta um lote por id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Lote concultaLoteId(String id) throws SQLException;

}
