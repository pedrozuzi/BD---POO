package persistence;

import java.sql.SQLException;

import entity.Servico;

public interface ServicoDao {

	public void adicionarServico(Servico servico) throws SQLException;
	public int buscarNovaEntrada() throws SQLException;
	
}
