package control;

import java.sql.SQLException;
import java.util.List;
import entity.Fornecedor;

public interface CtrlTableFornecedor {
	
	List<Fornecedor> buscaFornecedorPorNome(String nome) throws SQLException;
	Fornecedor consultaFornecedorId(String id) throws SQLException;
}
