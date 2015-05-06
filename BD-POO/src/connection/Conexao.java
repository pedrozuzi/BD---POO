package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Criado pelo Prof. M.Sc. Leandro Colevati dos Santos
 */
public class Conexao {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection con = DriverManager
					.getConnection(
							"jdbc:jtds:sqlserver://localhost:1433;DatabaseName=pessoas",
							"sa", "senha");
			System.out.println("Conexao ok");
			
			String qry = "SELECT * FROM pessoa";
			PreparedStatement stm = con.prepareStatement( qry );
			ResultSet rs = stm.executeQuery();
			
			int soma = 0;
			
			while ( rs.next()){
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				soma ++;
				System.out.println(id + " -- " + nome);
			}
			
			System.out.println("Retornou " + soma + " registro(s)");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  }
