package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistence.UsuarioDao;
import persistence.UsuarioDaoImpl;
import entity.Usuario;

public class CtrlUsuario {

	private UsuarioDao uDao;
	
//	private String[] colunas = {"Nome", "CPF","Cargo"};
//	private Class<?>[] classes = new Class[]{String.class, String.class, String.class};
//	private List<Funcionario> lista = new ArrayList<Funcionario>();
//	campos = {"nome", "cpf", "cargo"}	
//	private Class<T> tipo;
//	private String[] campos;
	
	
//	public CtrlUsuario(Class<T> tipo, String[] campos) { 
//		this.tipo = tipo;
//		this.campos = campos;
//		for (String campo : campos) { 
//			Method[] metodos = tipo.getDeclaredMethods();
//			for (Method m : metodos) { 
//				if (m.getName().equals( "get" + campo )) { 
//					Class<?> classe = m.getReturnType();
//					Object valor = m.invoke( /*instancia do objeto*/, new Object[] {});
//				}
//			}
//		}
//	}
	
	public void adicionarUsuario(Usuario us){
		uDao = new UsuarioDaoImpl();
		
		try {
			uDao.inserirUsuario(us);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean verificarNomeUsuario(String nome){
		uDao = new UsuarioDaoImpl();
		
		try {
			if(uDao.buscarUsario(nome)){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	public void alterarUsuario(Usuario us){
		
	}
	
	public void deletarUsuario(Usuario us){
		
	}

}
