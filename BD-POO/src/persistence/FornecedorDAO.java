package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Fornecedor;

public interface FornecedorDAO {
	
	void inserirFornecedor(Fornecedor f) throws SQLException;
	void atualizarFornecedor(Fornecedor f) throws SQLException;
	void excluirFornecedor(Fornecedor f) throws SQLException;
	Fornecedor consultarFornecedor(String id) throws SQLException;
	List<Fornecedor> listaFornecedor(String nome) throws SQLException;

}
