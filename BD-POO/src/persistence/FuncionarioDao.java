package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Funcionario;

/**
 * Interface para os métodos do FornecedorDaoImpl
 * @author Pedro Afonso
 *
 */
public interface FuncionarioDao {
	
	/**
	 * Método para inserção de um novo Funcionário ao
	 * banco de dados
	 * @param func Objeto Funcionário
	 * @throws SQLException exceção do banco de dados
	 */
	public void inserirFuncionario(Funcionario func) throws SQLException;
	
	/**
	 * Método para atualização de um Funcionário no banco
	 * de dados
	 * @param func Objeto Funcionário
	 * @throws SQLException exceção do banco de dados
	 */
	public void atualizarFuncionario(Funcionario func) throws SQLException;
	
	/**
	 * Método para exclusão de um Funcionário no banco
	 * de dados
	 * @param func Objeto Funcionário
	 * @throws SQLException exceção do banco de dados
	 */
	public void excluirFuncionario(Funcionario func) throws SQLException;
	
	/**
	 * Método para buscar do banco de dados Objetos
	 * do tipo Funcionário
	 * @param nome a ser pesquisado
	 * @return List<Funcionario> contendo as informações
	 * @throws SQLException exceção do banco de dados
	 */
	public List<Funcionario> pesquisarFuncionario(String nome) throws SQLException;
	
	/**
	 * Método para buscar do banco de dados Objetos
	 * do tipo Funcionário que não possuem um usuário cadastrado
	 * @param nome a ser pesquisado
	 * @return List<Funcionario> contendo as informações
	 * @throws SQLException exceção do banco de dados
	 */
	public List<Funcionario> pesquisarFuncionarioSemUsuario(String nome) throws SQLException;
}
