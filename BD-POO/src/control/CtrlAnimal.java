package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.AnimalDao;
import persistence.AnimalDaoImpl;
import entity.Animal;

public class CtrlAnimal {
	
	private AnimalDao aDao;
	
	public List<Animal> buscaCliente(int idCliente) throws SQLException{
		List<Animal> lista = new ArrayList<Animal>();
		aDao = new AnimalDaoImpl();
		lista = aDao.listaAnimal(idCliente);
		return lista;
	}
	
	public void inserir( Animal a ) throws SQLException{
		aDao = new AnimalDaoImpl();
		aDao.inserirAnimal(a);
	}

}
