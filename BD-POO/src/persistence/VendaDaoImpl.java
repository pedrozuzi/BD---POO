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
import entity.Venda;
import entity.VendaProduto;

public class VendaDaoImpl implements VendaDao, VendaProdutoDao {

	private Connection c;

	public VendaDaoImpl() {
		GenericConnection gDao = new ConnectionImpl();
		c = gDao.getConnection();
	}

	@Override
	public void insereVenda(Venda vend) throws SQLException {

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

		String sql = "venda" + "" + "";
		PreparedStatement ps = c.prepareStatement(sql);

		ps.execute();
		ps.close();

	}

	@Override
	public void excluiVenda(Venda vend) throws SQLException {

		String query = "delete venda";

		PreparedStatement ps = c.prepareStatement(query);

		ps.execute();
		ps.close();

	}

	@Override
	public List<Venda> pesquisaVenda(Venda vend) throws SQLException {

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
		
	}

	@Override
	public void atualizaVenda(VendaProduto vendprod) throws SQLException {
		
	}

	@Override
	public void excluiVenda(VendaProduto vendprod) throws SQLException {
		
	}

	@Override
	public List<VendaProduto> pesquisaVenda(VendaProduto vendprod)
			throws SQLException {
		return null;
	}

}
