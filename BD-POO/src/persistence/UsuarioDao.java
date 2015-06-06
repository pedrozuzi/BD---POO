package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Funcionario;
import entity.Usuario;

public interface UsuarioDao {
	
	public void inserirUsuario(Usuario u) throws SQLException;
	public void alterarUsuario(Usuario u) throws SQLException;
	public void excluirUsuario(Usuario u) throws SQLException;
	public boolean verificarUsuario(String nome) throws SQLException;
	public List<Usuario> pesquisarUsuario(String nome) throws SQLException;

}
