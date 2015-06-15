package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Lote;

/**
 * Interface com os metodos de Lote a serem implementados
 * @author Hury
 *
 */

public interface LoteDao {
	
	/**
	 * Método para inserção de um novo Lote ao
	 * banco de dados
	 * @param lot
	 * @return 
	 * @throws SQLException exceção do banco de dados
	 */
	int insereLote(Lote lot) throws SQLException;

	/**
	 * Método para atualização de um Lote no banco
	 * de dados
	 * @param lot
	 * @throws SQLException exceção do banco de dados
	 */
	void atualizaLote(Lote lot) throws SQLException;

	/**
	 * Método para exclusão de um Lote no banco
	 * de dados
	 * @param lot
	 * @throws SQLException exceção do banco de dados
	 */
	void excluiLote(Lote lot) throws SQLException;

	/**
	 * Método para consulta de um lote
	 * @param lot
	 * @return
	 * @throws SQLException exceção do banco de dados
	 */
	Lote consultaLote(Lote lot) throws SQLException;

	/**
	 * Método para buscar do banco de dados Objetos
	 * do tipo Lote
	 * @param id
	 * @return List<Lote> contendo as informações
	 * @throws SQLException exceção do banco de dados
	 */
	List<Lote> listaLote(int id) throws SQLException;
}
