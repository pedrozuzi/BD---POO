package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		return null;
	}

}
