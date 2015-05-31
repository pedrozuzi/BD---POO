package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Animal;

public interface AnimalDao {
	
	List<Animal> listaAnimal(int idCliente) throws SQLException;

}
