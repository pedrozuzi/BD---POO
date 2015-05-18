package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Lote;

public interface LoteDao {
	public abstract void insereLote(Lote lot) throws SQLException;

	public abstract void atualizaLote(Lote lot) throws SQLException;

	public abstract void excluiLote(Lote lot) throws SQLException;

	public abstract Lote consultaLote(Lote lot) throws SQLException;

	public abstract List<Lote> listaLote() throws SQLException;
}
