package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import persistence.FuncionarioDao;
import persistence.FuncionarioDaoImpl;
import persistence.PessoaDao;
import persistence.PessoaDaoImpl;
import sun.misc.FpUtils;
import entity.Funcionario;

public class CtrlFuncionario extends AbstractTableModel {

	private FuncionarioDao fDao;
	private PessoaDao pDao;
	private String[] nomes = {"Nome", "CPF","Cargo"};
	private Class<?>[] classes = new Class[]{String.class, String.class, String.class};
	
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
		pDao = new PessoaDaoImpl();
		
		try {
			fDao.excluirFuncionario(f);
			pDao.excluiPessoa(f);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
//		fireTableRowsDeleted(indiceLinha, indiceLinha); 
	}
	
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

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		return nomes[column];
	}

	@Override
	public Class<?> getColumnClass(int column) {
		return classes[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		
	}
}
