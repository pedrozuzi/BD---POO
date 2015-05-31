package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import boundary.Especie;
import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Animal;

public class AnimalDaoImpl implements AnimalDao{
	
	private Connection c;
	
	public AnimalDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public List<Animal> listaAnimal(int idCliente) throws SQLException {
		
		List<Animal> lista = new ArrayList<Animal>();
		String query = "select an.nome, an.rga, an.raca, an.especie, an.sexo, an.cor "
						+ "from cliente cli "
						+ "inner join animal an "
						+ "on cli.id = an.id_cliente "
						+ "where cli.id = ?";
		PreparedStatement ps = c.prepareStatement( query );
		ps.setInt(1, idCliente);
		ResultSet rs = ps.executeQuery();
		
		if ( rs.next() ) {
			Animal a = new Animal();
			a.setNome( rs.getString("nome") );
			a.setRga( rs.getString("rga") );
			a.setRaca( rs.getString("raca") );
			a.setEspecie((rs.getString("especie")));
			a.setSexo( rs.getString("sexo") );
			a.setCor( rs.getString("cor") );
			lista.add(a);
		}
		ps.close();
		return lista;
	}

}
