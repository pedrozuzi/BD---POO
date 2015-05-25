package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Lote;

/**
 * 
 * @author Hury
 *
 */

public interface LoteDao {
	
	int insereLote(Lote lot) throws SQLException;

	void atualizaLote(Lote lot) throws SQLException;

	void excluiLote(Lote lot) throws SQLException;

	Lote consultaLote(Lote lot) throws SQLException;

	List<Lote> listaLote() throws SQLException;
}
