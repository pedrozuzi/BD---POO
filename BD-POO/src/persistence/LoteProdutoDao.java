package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.LoteProduto;



public interface LoteProdutoDao {
	
	void insereLoteProduto(LoteProduto lotProd) throws SQLException;

	void atualizaLoteProduto(LoteProduto lotProd) throws SQLException;

	void excluiLoteProduto(LoteProduto lotProd) throws SQLException;

	LoteProduto consultaLoteProduto(LoteProduto lotProd) throws SQLException;

	List<LoteProduto> listaLoteProduto() throws SQLException;
}
