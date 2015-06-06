package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Funcionario;

public class FuncionarioDaoImpl implements FuncionarioDao {

	public FuncionarioDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	private Connection c;
	
	@Override
	public void inserirFuncionario(Funcionario func) throws SQLException {

		String queryFuncionario = "insert into funcionario (id, cpf, nome, salario, telefone)"
				+ " values(?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement( queryFuncionario );
		ps.setInt(1, func.getId() );
		ps.setString(2, func.getCpf() );
		ps.setString(3, func.getNome() );
		ps.setDouble(4, func.getSalario() );
		ps.setInt(5, func.getTelefone() );
		ps.execute();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Funcionario inserido.",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void atualizarFuncionario(Funcionario func) throws SQLException {
		String query = "update funcionario set "
				+ "cpf = ?,"
				+ "nome = ?,"
				+ "salario= ?,"
				+ "telefone = ? "
				+ "where id = ?";
				
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, func.getCpf() );
		ps.setString(2, func.getNome() );
		ps.setDouble(3, func.getSalario() );
		ps.setInt(4, func.getTelefone() );
		ps.setInt(5, func.getId() );
		ps.execute();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Dados atualizados.",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void excluirFuncionario(Funcionario func) throws SQLException {
		String query = "delete funcionario "
				+ " where id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, func.getId());
		ps.execute();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Funcionario excluido.",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public List<Funcionario> pesquisarFuncionario(String nome)
			throws SQLException {
			List<Funcionario> lista = new ArrayList<Funcionario>();
			
			String query = "select  f.id, f.nome, SUBSTRING(f.cpf,1,9)+'-'+SUBSTRING(f.cpf,10,11)as cpf, f.salario, f.telefone, p.idTipo "
					+ "from funcionario f "
					+ "inner join pessoa p "
					+ "on f.id = p.idPessoa "
					+ "where f.nome like ? ";
			PreparedStatement ps = c.prepareStatement( query );
			ps.setString( 1, "%" + nome + "%" );
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ){
				Funcionario f = new Funcionario();
				f.setId( rs.getInt("id") );
				f.setCpf( rs.getString("cpf") );
				f.setNome( rs.getString("nome") );
				f.setSalario( rs.getDouble("salario"));
				f.setIdTipo( rs.getInt("idTipo") );
				f.setTelefone( rs.getInt("telefone") );
				lista.add(f);
			}
			ps.close();
			return lista;
	}

	@Override
	public List<Funcionario> pesquisarFuncionarioSemUsuario(String nome)
			throws SQLException {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		String query = "select f.id, f.nome, f.cpf, f.salario, f.telefone "
				+ "from funcionario f "
				+ "left outer join usuario u "
				+ "on f.id = u.id "
				+ "where u.id is null";
		
		PreparedStatement ps = c.prepareStatement( query );
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ){
			Funcionario f = new Funcionario();
			f.setId( rs.getInt("id") );
			f.setCpf( rs.getString("cpf") );
			f.setNome( rs.getString("nome") );
			f.setSalario( rs.getDouble("salario"));
			f.setTelefone( rs.getInt("telefone") );
			lista.add(f);
		}
		ps.close();
		return lista;
	}

	



}
