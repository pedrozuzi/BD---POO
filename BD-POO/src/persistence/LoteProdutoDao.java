package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Lote;
import entity.LoteProduto;

public interface LoteProdutoDao {
	public abstract void insereLoteProduto(LoteProduto lotProd) throws SQLException;

	public abstract void atualizaLoteProduto(LoteProduto lotProd) throws SQLException;

	public abstract void excluiLoteProduto(LoteProduto lotProd) throws SQLException;

	public abstract Lote consultaLoteProduto(LoteProduto lotProd) throws SQLException;

	public abstract List<LoteProduto> listaLoteProduto() throws SQLException;
}
