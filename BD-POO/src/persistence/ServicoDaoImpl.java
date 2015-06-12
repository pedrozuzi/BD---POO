package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Animal;
import entity.Cliente;
import entity.Servico;

public class ServicoDaoImpl implements ServicoDao {

	private Connection c;
	
	public ServicoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	@Override
	public void adicionarServico(Servico servico) throws SQLException {
		String query = "insert into servico (id, nome, valor, id_animal, id_cliente_servico) values"
				+ " (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, servico.getCodigo());
		ps.setString(2, servico.getNome());
		ps.setInt(3, servico.getValor());
		ps.setInt(4, servico.getAnimal().getId() );
		ps.setInt(5, servico.getCliente().getId());
		System.out.println(servico.getAnimal().getNome()+"\n"+servico.getAnimal().getId());
		ps.execute();
		ps.close();
		

	}
	
	@Override
	public void adicionaServicoAgenda(Servico servico) throws SQLException {
		String query = "insert into servico (id, nome, id_animal, id_cliente_servico) values"
				+ " (?, ?, ?, ?)";
		
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, servico.getCodigo());
		ps.setString(2, servico.getNome());
		System.out.println(servico.getNome());
		ps.setInt(3, servico.getAnimal().getId() );
		ps.setInt(4, servico.getCliente().getId());
		System.out.println(servico.getAnimal().getNome());
		ps.execute();
		ps.close();
	}

	@Override
	public int buscarNovaEntrada() throws SQLException {
		
		String query = "select max(id) from servico";
		
		PreparedStatement ps = c.prepareStatement( query );

		ResultSet rs = ps.executeQuery();
		rs.next();

		return rs.getInt(1) == 0 ? 1 : rs.getInt(1)+1;
	}

	@Override
	public List<Servico> buscarServicosAgendados() throws SQLException {
		List<Servico> lista = new ArrayList<Servico>();
		
		String query = "select s.id as codigo_servico, s.nome as servico, "
				+ "c.nome as nome_cliente, c.id as codigo_cliente, "
				+ "a.id as codigo_animal, a.nome as nome_animal, a.raca as raca_animal "
				+ "from cliente c "
				+ "inner join animal a "
				+ "on c.id = a.id_cliente "
				+ "inner join servico s "
				+ "on a.id = s.id_animal "
				+ "right outer join agenda ag "
				+ "on s.id = ag.id_servico "
				+ "where hora > CONVERT(CHAR(5), GETDATE()-'10:00', 108) "
				+ "and ag.id_servico is not null";	
		
		PreparedStatement ps = c.prepareStatement( query );
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			System.out.println("ENTROU");
			Servico s = new Servico();
			Cliente c = new Cliente();
			Animal a = new Animal();
			a.setId( rs.getInt("codigo_animal") );
			a.setNome( rs.getString("nome_animal") );
			a.setRaca( rs.getString("raca_animal") );
			s.setAnimal(a);
			c.setId( rs.getInt("codigo_cliente") );
			c.setNome( rs.getString("nome_cliente") );
			s.setCliente(c);
			s.setCodigo( rs.getInt("codigo_servico") );
			s.setNome( rs.getString("servico") );			
			lista.add(s);
		}
		return lista;
	}

}
