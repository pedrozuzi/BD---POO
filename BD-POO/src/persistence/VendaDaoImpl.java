package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Venda;
import entity.VendaProduto;

/**
 * 
 * @author Hury
 *
 */

public class VendaDaoImpl implements VendaDao, VendaProdutoDao {

	private Connection c;

	/**
	 * Construtor da classe.
	 */

	public VendaDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}

	@Override
	public void insereVenda(Venda vend) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO venda (id_cliente,id_funcionario,total) VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, vend.getIdcliente());
		ps.setInt(2, vend.getIdfuncionario());
		ps.setDouble(3, vend.getTotal());
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();

		vend.setId(rs.getInt(1));
		
		ps.close();
	}

	@Override
	public void atualizaVenda(Venda vend) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "venda" + "" + "";
		PreparedStatement ps = c.prepareStatement(sql);

		// ps.set
		ps.execute();
		ps.close();

	}

	@Override
	public void excluiVenda(Venda vend) throws SQLException {
		// TODO Auto-generated method stub

		String query = "delete venda";

		PreparedStatement ps = c.prepareStatement(query);
		// ps.set
		ps.execute();
		ps.close();

	}

	@Override
	public List<Venda> pesquisaVenda(Venda vend) throws SQLException {
		// TODO Auto-generated method stub

		List<Venda> lista = new ArrayList<Venda>();

		String query = "";

		PreparedStatement ps = c.prepareStatement(query);
		// ps.setInt;
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			// vend.set(r);
			// vend.setId(r);

			lista.add(vend);

		}

		ps.close();
		return lista;

	}

	@Override
	public void insereVenda(VendaProduto vendprod) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizaVenda(VendaProduto vendprod) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluiVenda(VendaProduto vendprod) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VendaProduto> pesquisaVenda(VendaProduto vendprod)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
