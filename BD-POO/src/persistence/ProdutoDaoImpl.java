package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Fornecedor;
import entity.Lote;
import entity.LoteProduto;
import entity.Produto;

public class ProdutoDaoImpl implements ProdutoDao, LoteDao, LoteProdutoDao {
	
	private Connection c;
	
	public ProdutoDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}
	

	//Metodos implementados Produto
	@Override
	public int insereProduto(Produto prod) throws SQLException {
		
		String sql = "INSERT INTO produto (nome,descricao,id_fornecedor,valor_venda,valor_compra)"+
		"VALUES(?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, prod.getNome());
		ps.setString(2, prod.getDescricao());
		ps.setInt(3, prod.getId_fornecedor());
		ps.setInt(4, prod.getValor_venda());
		ps.setInt(5, prod.getValor_compra());
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		prod.setId(id);
		ps.close();
		System.out.println("ID produto:"+id+" "+prod.getId());
		return id;
		
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
	public Produto consultaProduto(String id) throws SQLException {
		// TODO Auto-generated method stub
		
		Produto p = new Produto();
		String query = "SELECT id, nome, descricao, id_fornecedor, valor_venda, valor_compra "
				+ "FROM produto WHERE id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1,  Integer.parseInt(id) );
		ResultSet rs = ps.executeQuery();
		if( rs.next() ){
			p.setId(rs.getInt("id"));
		    p.setDescricao(rs.getString("descricao"));
		    p.setId_fornecedor(rs.getInt("id_fornecedor"));
		    p.setValor_venda(rs.getInt("valor_venda"));
		    p.setValor_compra(rs.getInt("valor_compra"));
		}
		ps.close();
		return p;
		
	}

	@Override
	public List<Produto> listaProduto(String nome) throws SQLException {
		// TODO Auto-generated method stub
		Produto p = new Produto();
		List<Produto> lista = new ArrayList<Produto>();
		String query = "SELECT * FROM produto WHERE nome like ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString( 1, "%" + nome + "%" );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			p.setId(rs.getInt("id"));
		    p.setDescricao(rs.getString("descricao"));
		    p.setId_fornecedor(rs.getInt("id_fornecedor"));
		    p.setValor_venda(rs.getInt("valor_venda"));
		    p.setValor_compra(rs.getInt("valor_compra"));
		}
		
		ps.close();
		return lista;
		
	}
	//Metodos implementados Lote
	@Override
	public int insereLote(Lote lot) throws SQLException {
		String sql = "INSERT INTO lote (data_validade)"+
		"VALUES(?)";
		PreparedStatement ps = c.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
		ps.setDate(1, lot.getData_validade());
		ps.execute();
			
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		lot.setId(id);
		ps.close();
		System.out.println("ID Lote:"+id+" "+lot.getId());
		return id;
		
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
//Metodos implementados LoteProduto
	@Override
	public void insereLoteProduto(LoteProduto lotProd) throws SQLException {
		String sql = "INSERT INTO lote_produto (idProduto,idLote)"+
		"VALUES(?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, lotProd.getIdProduto());
		ps.setInt(2, lotProd.getIdLote());
		ps.execute();
		
		ps.close();
		
	}

	@Override
	public void atualizaLoteProduto(LoteProduto lotProd) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluiLoteProduto(LoteProduto lotProd) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoteProduto consultaLoteProduto(LoteProduto lotProd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoteProduto> listaLoteProduto() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
