package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Lote;
import entity.Produto;

public class ProdutoDaoImpl implements ProdutoDao {
	
	private Connection c;
	
	public ProdutoDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}
	
	

	@Override
	public void insereLote(Lote lot) throws SQLException {
		
		
	}

	@Override
	public void atualizaLote(Lote lot) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluiLote(Lote lot) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lote consultaLote(Lote lot) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lote> listaLote() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
//
	@Override
	public void insereProduto(Produto prod) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizaProduto(Produto prod) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluiProduto(Produto prod) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lote consultaProduto(Produto prod) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listaProduto() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
