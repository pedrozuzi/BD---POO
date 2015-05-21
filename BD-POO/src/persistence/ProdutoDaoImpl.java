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
	
	/**
	 * create table lote(
id int identity not null,
data_validade datetime not null
primary key(id))

create table produto(
id int identity not null,
nome varchar(60) not null,
descricao varchar(60),
id_fornecedor int not null,
valor_venda int not null,
valor_compra int not null,
id_lote int not null
primary key(id)
foreign key(id_fornecedor) references fornecedor(id),
foreign key(id_lote) references lote(id))

create table lote_produto(
idProduto int not null,
idLote int not null,
primary key(idProduto, idLote),
foreign key(idLote)references lote(id),
foreign key(idProduto)references produto(id))
	 */


//
	@Override
	public void insereProduto(Produto prod) throws SQLException {
	//	String sql = "INSERT INTO materias (nome, carga_horaria)"+
	//			"VALUES(?,?)";
	//	PreparedStatement ps = c.prepareStatement(sql);
	//	ps.setString(1, mat.getNome());
		//ps.setInt(2, mat.getCargaHoraria());
		//ps.execute();
		//ps.close();
		
		String sql = "INSERT INTO produto (nome,descricao,id_fornecedor,valor_venda,valor_compra,)"+
		"VALUES(?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, prod.getNome());
		ps.setString(2, prod.getDescricao());
		ps.setInt(3, prod.getId_fornecedor());
		ps.setInt(4, prod.getValor_venda());
		ps.setInt(5, prod.getValor_compra());
		ps.execute();
		ps.close();
		
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



}
