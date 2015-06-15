package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.AnimalDao;
import persistence.AnimalDaoImpl;
import entity.Animal;

/**
 * Classe para controle das funcionalidades
 * da tela do animal
 * @author Pedro Afonso
 *
 */
public class CtrlAnimal {
	
	private AnimalDao aDao;
	
	/**
	 * Método para buscar os animais cadastrados 
	 * pelo seu dono
	 * @param idCliente código do cliente 
	 * @return lista de animais do dono
	 * @throws SQLException exceção do banco de dados sql
	 */
	public List<Animal> buscaAnimal(int idCliente) throws SQLException {
		List<Animal> lista = new ArrayList<Animal>();
		aDao = new AnimalDaoImpl();
		lista = aDao.listaAnimal(idCliente);
		return lista;
	}
	
	/**
	 * Método para cadastrar um animal
	 * @param a animal a ser cadastrado
	 * @throws SQLException exceção do banco de dados sql
	 */
	public void inserir( Animal a ) throws SQLException {
		aDao = new AnimalDaoImpl();
		aDao.inserirAnimal(a);
	}
	
	/**
	 * Método para atualizar os dados de um animal cadastrado.
	 * @param a animal a ser atualizado
	 * @throws SQLException exceção do banco de dados sql
	 */
	public void atualiza( Animal a ) throws SQLException {
		aDao = new AnimalDaoImpl();
		aDao.atualizaAnimal(a);
	}
	
	/**
	 * Método para excluir um animal cadastrado
	 * @param a animal a ser excluído
	 * @throws SQLException exceção do banco de dados sql
	 */
	public void excluir ( Animal a ) throws SQLException {
		aDao = new AnimalDaoImpl();
		aDao.excluiAnimal(a);
	}

}
