package control;

import java.sql.SQLException;
import java.util.List;

import entity.Lote;

/**
 * Interface que possui metodos a serem implementados, de tabela.
 * @author Hury
 *
 */

public interface CtrlTableLote {

	List<Lote> buscaLotePorProduto(int id) throws SQLException;
	Lote concultaLoteId(String id )  throws SQLException;
	
}
