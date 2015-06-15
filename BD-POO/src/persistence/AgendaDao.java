package persistence;

import java.sql.SQLException;
import java.util.List;
import entity.Agenda;

/**
 * Interface para os métodos da AgendaDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface AgendaDao {
	
	/**
	 * Método para retorno de informações do banco de dados
	 * @return List<Agenda> contendo valores do objeto agenda
	 * @throws SQLException exceção do banco de dados
	 */
	List<Agenda> buscarAgenda() throws SQLException;
	
	/**
	 * Método para atualizar a Agenda
	 * @param a
	 * @throws SQLException
	 */
	void atualizaAgenda( Agenda a) throws SQLException;
	
	/**
	 * Método que encerra a Agenda
	 * @throws SQLException exceção do banco de dados
	 */
	void encerraAgenda() throws SQLException;
}
