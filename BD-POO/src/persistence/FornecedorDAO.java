package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Fornecedor;

public interface FornecedorDAO {
	
	void inserirFornecedor(Fornecedor f, int id) throws SQLException;
	void atualizarFornecedor(Fornecedor f) throws SQLException;
	void excluirFornecedor(Fornecedor f) throws SQLException;
	Fornecedor consultarFornecedor(Fornecedor f) throws SQLException;
	List<Fornecedor> listaFornecedor(String nome) throws SQLException;

}
