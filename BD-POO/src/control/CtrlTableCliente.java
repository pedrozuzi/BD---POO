package control;

import java.sql.SQLException;
import java.util.List;

import entity.Cliente;

public interface CtrlTableCliente {
	
	List<Cliente> buscaClientePorNome(String nome) throws SQLException;

}
