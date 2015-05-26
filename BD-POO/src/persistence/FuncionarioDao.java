package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Funcionario;;

public interface FuncionarioDao {
	
	public void inserirFuncionario(Funcionario func) throws SQLException;
	public void atualizarFuncionario(Funcionario func) throws SQLException;
	public void excluirFuncionario(Funcionario func) throws SQLException;
	public List<Funcionario> pesquisarFuncionario(String nome) throws SQLException;
}
