package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Animal;

/**
 * Interface para os métodos da AnimalDaoImpl
 * @author Pedro Zuzi
 *
 */
public interface AnimalDao {
	
	/**
	 * Método para retorno de informações do banco de dados
	 * @param idCliente id do cliente
	 * @return List<Animal> contendo informações do objeto Animal
	 * @throws SQLException exceção do banco de dados
	 */
	List<Animal> listaAnimal(int idCliente) throws SQLException;
	
	/**
	 * Método para inserção no banco de dados um novo
	 * registro de um Objeto Animal
	 * @param a Objeto Animal
	 * @throws SQLException exceção do banco de dados
	 */
	void inserirAnimal( Animal a ) throws SQLException;
	
	/**
	 * Método para atualização das informações no banco
	 * de dados de um objeto Animal
	 * @param a Objeto Animal
	 * @throws SQLException exceção do banco de dados
	 */
	void atualizaAnimal ( Animal a ) throws SQLException;
	
	/**
	 * Método para exclusão de um objeto Animal do banco
	 * de dados
	 * @param a Objeto Animal
	 * @throws SQLException exceção do banco de dados
	 */
	void excluiAnimal( Animal a ) throws SQLException;
}
