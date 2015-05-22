package persistence;

import java.sql.SQLException;
import entity.Funcionario;;

public interface FuncionarioDao {
	
	public void inserirFuncionario(Funcionario func) throws SQLException;
	public void atualizarFuncionario(Funcionario func) throws SQLException;
	public void excluirFuncionario(Funcionario func) throws SQLException;
	public Funcionario consultarFuncionario(Funcionario func) throws SQLException;
	public int pegarCodigo() throws SQLException;	
}
