package control;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import entity.Funcionario;

public class CtrlUsuario extends AbstractTableModel{

	private String[] colunas = {"Nome", "CPF","Cargo"};
	private Class<?>[] classes = new Class[]{String.class, String.class, String.class};
	private List<Funcionario> lista = new ArrayList<Funcionario>();
	//  campos = {"nome", "cpf", "cargo"}	
//	private Class<T> tipo;
	private String[] campos;
	
	
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
	
	public CtrlUsuario() {
		
	}
	 
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return String.class;//todas sao String
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
//		Funcionario f = lista.get(linha);
		return lista.get(linha);
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
	
	@Override
	public void fireTableRowsDeleted(int firstRow, int lastRow) {
		super.fireTableRowsDeleted(firstRow, lastRow);
	}

}
