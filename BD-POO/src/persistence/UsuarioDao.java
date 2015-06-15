package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Usuario;

/**
 * Interface com os métodos para a classe UsuarioDaoImpl
 * @author Pedro Afonso
 *
 */
public interface UsuarioDao {
	
	/**
	 * Método para inserção de um novo Usuário ao
	 * banco de dados
	 * @param u Objeto Usuário
	 * @throws SQLException exceção do banco de dados
	 */
	public void inserirUsuario(Usuario u) throws SQLException;
	
	/**
	 * Método para atualização de um Usuário no banco
	 * de dados
	 * @param u Objeto Usuário
	 * @throws SQLException exceção do banco de dados
	 */
	public void alterarUsuario(Usuario u) throws SQLException;
	
	/**
	 * Método para exclusão de um Usuário no banco
	 * de dados
	 * @param u Objeto Usuário
	 * @throws SQLException exceção do banco de dados
	 */
	public void excluirUsuario(Usuario u) throws SQLException;
	
	/**
	 * Método para verficação da existência de um nome de Usuário
	 * @param nome
	 * @return true nome existe, false nome não existe
	 * @throws SQLException exceção do banco de dados
	 */
	public boolean verificarUsuario(String nome) throws SQLException;
	
	/**
	 * Método para buscar do banco de dados Objetos
	 * do tipo Usuário
	 * @param nome
	 * @return List<Usuario> contendo as informações
	 * @throws SQLException exceção do banco de dados
	 */
	public List<Usuario> pesquisarUsuario(String nome) throws SQLException;

}
