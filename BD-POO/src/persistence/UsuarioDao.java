package persistence;

import java.sql.SQLException;

import entity.Usuario;

public interface UsuarioDao {
	
	public void inserirUsuario(Usuario u) throws SQLException;
	public void alterarUsuario(Usuario u) throws SQLException;
	public void excluirUsuario(Usuario u) throws SQLException;

}
