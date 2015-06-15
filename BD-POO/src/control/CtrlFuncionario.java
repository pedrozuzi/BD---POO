package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import persistence.FuncionarioDao;
import persistence.FuncionarioDaoImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import entity.Funcionario;

/**
 * Classe para controle das funcionalidades
 * da tela do funcionário
 * @author Pedro Afonso
 *
 */
public class CtrlFuncionario {

	private FuncionarioDao fDao;
	private PessoaDao pDao;
	
	/**
	 * Método para cadastrar um funcionário
	 * @param f funcionário a ser cadastrado
	 */
	public void incluir(Funcionario f){
		fDao = new FuncionarioDaoImpl();
		pDao = new PessoaDaoImpl();
		try {
			pDao.inserePessoa(f);
			fDao.inserirFuncionario(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método para remover um funcionário cadastrado.
	 * @param f dados do funcionário a ser excluído
	 */
	public void remover(Funcionario f){
		fDao = new FuncionarioDaoImpl();
		pDao = new PessoaDaoImpl();
		
		try {
			fDao.excluirFuncionario(f);
			pDao.excluiPessoa(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * 
	 * @param f
	 */
	public void alterar(Funcionario f){
		fDao = new FuncionarioDaoImpl();
		pDao = new PessoaDaoImpl();
		
		try {
			pDao.atualizaPessoa(f);
			fDao.atualizarFuncionario(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método para pesquisar todos funcionarios cadastrados
	 * no sistema
	 * @param nome do funcionário a ser pesquisado
	 * @return lista de funcionários
	 */
	public List<Funcionario> pesquisarFuncionario( String nome ){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		fDao = new FuncionarioDaoImpl();
		
		try {
			lista = fDao.pesquisarFuncionario(nome);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return lista;
		
	}
	
	/**
	 * Método para pesquisar um funcionário que nao 
	 * tenha cadastro no sistema
	 * @param nome do funcionário a ser pesquisado
	 * @return lista de funcionários.
	 */
	public List<Funcionario> pesquisarFuncionarioSemUsuario(String nome){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		fDao = new FuncionarioDaoImpl();
		
		try {
			lista = fDao.pesquisarFuncionarioSemUsuario(nome);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", 
					JOptionPane.ERROR_MESSAGE);
		}
		
		return lista;
	}
}
