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
		
		//inserindo tipo
		String queryTipo = "insert into tipo (id, descricao)"
				+ " values(?, ?)";
		PreparedStatement ps = c.prepareStatement( queryTipo );
		if(func.getCargo().equals("Administrador")){
			ps.setInt(1, 1);
			ps.setString(2, func.getCargo());
		}else if(func.getCargo().equals("Atendente")){
			ps.setInt(1, 2);
			ps.setString(2, func.getCargo());
		}else if(func.getCargo().equals("Banhista/Tosador")){
			ps.setInt(1, 3);
			ps.setString(2, func.getCargo());
		}
		ResultSet rs = ps.executeQuery();
		
		//inserindo pessoa
		String queryPessoa = "insert into pessoa (idTipo)"
				+ " values(?)";
		ps = c.prepareStatement( queryPessoa );
		ps.setInt(1, rs.getInt("id") );
		rs = ps.executeQuery();
		System.out.println(rs.getInt("id"));
		func.setId(rs.getInt("id"));
		
		//inserindo funcionario
		String queryFuncionario = "insert into funcionario (id, cpf, nome, cargo, salario)"
				+ " values(?, ?, ?, ?, ?)";
		ps = c.prepareStatement( queryPessoa );
		ps.setInt(1, func.getId() );
		ps.setString(1, func.getCpf() );
		ps.setString(1, func.getNome() );
		ps.setString(1, func.getCargo() );
		ps.setDouble(1, func.getSalario() );
		
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


}
