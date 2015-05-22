package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Funcionario;

public class FuncionarioDaoImpl implements FuncionarioDao {

	private Connection c;
	
	public FuncionarioDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	@Override
	public void inserirFuncionario(Funcionario func) throws SQLException {
		String query = "insert into funcionario (cpf, nome, cargo, salario)"
				+ " values(?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, func.getCpf() );
		ps.setString(2, func.getNome() );
		ps.setString(3, func.getCargo() );
		ps.setDouble(4, func.getSalario() );
		ps.execute();
		System.out.println("Funcionario inserido com sucesso");
		ps.close();
	}

	@Override
	public void atualizarFuncionario(Funcionario func) throws SQLException {
		String query = "update funcionario set "
				+ "cpf = ?,"
				+ "nome = ?,"
				+ "cargo = ?,"
				+ "salario= ?"
				+ "where id = ?";
				
		PreparedStatement ps = c.prepareStatement( query );
		ps.setString(1, func.getCpf() );
		ps.setString(2, func.getNome() );
		ps.setString(3, func.getCargo() );
		ps.setDouble(4, func.getSalario() );
		ps.setInt(5, func.getId() );
		ps.execute();
		System.out.println("Dados atualizados");
		ps.close();
	}

	@Override
	public void excluirFuncionario(Funcionario func) throws SQLException {
		String query = "delete funcionario "
				+ " where id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, func.getId());
		ps.execute();
		System.out.println("Funcionario removido com sucesso");
		ps.close();
	}

	@Override
	public Funcionario consultarFuncionario(Funcionario func)
			throws SQLException {
		
		String query = "select id, cpf, nome, cargo, salario "
				+ "from funcionario where id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1,  func.getId() );
		ResultSet rs = ps.executeQuery();
		if( rs.next() ){
			func.setId( rs.getInt("id") );
			func.setCpf( rs.getString("cpf") );
			func.setNome( rs.getString("nome") );	
			func.setCargo( rs.getString("cargo"));
			func.setSalario( rs.getDouble("salario"));
		}
		ps.close();
		return func;
	}

	@Override
	public int pegarCodigo() throws SQLException {
		String query = "select IDENT_CURRENT ('tipo') as codigo";
		PreparedStatement ps = c.prepareStatement( query );
		ResultSet rs = ps.executeQuery();
		return rs.getInt("codigo");
	}

}
