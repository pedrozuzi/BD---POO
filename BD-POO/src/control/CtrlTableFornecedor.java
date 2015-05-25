package control;

import java.sql.SQLException;
import java.util.List;
import entity.Fornecedor;

public interface CtrlTableFornecedor {
	
	public List<Fornecedor> listaFornecedores() throws SQLException;

}
