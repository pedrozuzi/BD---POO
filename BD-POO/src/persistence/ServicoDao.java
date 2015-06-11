package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Servico;

public interface ServicoDao {

	public void adicionarServico(Servico servico) throws SQLException;
	public int buscarNovaEntrada() throws SQLException;
	public List<Servico> buscarServicosAgendados() throws SQLException;
	void adicinaServicoAgenda(Servico s) throws SQLException;
}
