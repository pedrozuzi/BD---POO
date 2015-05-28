package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import persistence.FuncionarioDao;
import persistence.FuncionarioDaoImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import entity.Funcionario;

public class CtrlFuncionario {

	private FuncionarioDao fDao;
	private PessoaDao pDao;
	
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
	
	public void remover(Funcionario f){
		fDao = new FuncionarioDaoImpl();
		
		try {
			fDao.excluirFuncionario(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void alterar(Funcionario f){
		fDao = new FuncionarioDaoImpl();
		
		try {
			fDao.atualizarFuncionario(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
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
}
