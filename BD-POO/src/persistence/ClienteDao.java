package persistence;

import java.sql.SQLException;
import java.util.List;
import entity.Cliente;

public interface ClienteDao {
	
	void inserirCliente(Cliente c) throws SQLException;
	void atualizarCliente(Cliente c) throws SQLException;
	void excluirCliente(Cliente c) throws SQLException;
	List<Cliente> listaCliente(String nome) throws SQLException;

}
