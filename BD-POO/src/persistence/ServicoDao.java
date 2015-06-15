package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Servico;

/**
 * Interface para os métodos do ServicoDaoImpl
 * @author Pedro Afonso
 *
 */
public interface ServicoDao {

	/**
	 * Método para inserção de um novo Serviço ao
	 * banco de dados
	 * @param servico
	 * @throws SQLException exceção do banco de dados
	 */
	public void adicionarServico(Servico servico) throws SQLException;
	
	/**
	 * Método para buscar um novo código de serviço
	 * @return Código
	 * @throws SQLException exceção do banco de dados
	 */
	public int buscarNovaEntrada() throws SQLException;
	
	/**
	 * Método para buscar do banco de dados Objetos
	 * do tipo Serviço
	 * @return List<Servico> com as informações
	 * @throws SQLException exceção do banco de dados
	 */ 
	public List<Servico> buscarServicosAgendados() throws SQLException;
	
	/**
	 * Método para adicionar um serviço a Agenda
	 * @param s Objeto Servico
	 * @throws SQLException exceção do banco de dados
	 */
	void adicionaServicoAgenda(Servico s) throws SQLException;
}
