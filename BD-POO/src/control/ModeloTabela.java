package control;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Agenda;
import entity.Coluna;
import entity.Funcionario;

public class ModeloTabela extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	

	private final List<?> lista;
	private Class<?> classe;

	public ModeloTabela(List<?> lista) {
		this.lista = lista;
		this.classe = lista.get(0).getClass();
	}

	public void clear(){
		lista.clear();
		fireTableRowsDeleted(0, lista.size());
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
	}
	
	@Override
	public int getColumnCount() {
		int colunas = 0;
		
		for ( Method metodo : classe.getDeclaredMethods()) {
			if (metodo.isAnnotationPresent(Coluna.class)) {
				colunas++;
			}
		}
		return colunas;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		try {
			Object objeto = lista.get(linha);
			for (Method metodo : classe.getDeclaredMethods()) {
				if (metodo.isAnnotationPresent(Coluna.class)) {
					Coluna anotacao = metodo.getAnnotation(Coluna.class);
					if (anotacao.posicao() == coluna) {
						return metodo.invoke(objeto);
					}
				}
			}
		} catch (Exception e) {
			return "ERRO";
		}
		return "";
	}
	
	@Override
	public String getColumnName(int coluna) {
		for (Method metodo : classe.getDeclaredMethods()) {
			if (metodo.isAnnotationPresent(Coluna.class)) {
				Coluna anotacao = metodo.getAnnotation(Coluna.class);
				if (anotacao.posicao() == coluna) {
					return anotacao.nome();
				}
			}
		}
		return "";
	}
	
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		if (classe.getName().equalsIgnoreCase("entity.Agenda")) {
			if (coluna == 1) {
				Agenda a = (Agenda) lista.get(linha);
				a.setEscolhaHorario((Boolean) valor);
				fireTableCellUpdated(linha, coluna);
			}
			
		} 
//			System.out.println(classe.getName());
//			System.out.println("TESTE");
//			if (classe.getName() == "entity.Funcionario") {
//				Funcionario f = (Funcionario) lista.get(rowIndex);
//				System.out.println("Entrou");
//			}
//		}
//		Funcionario f = (Funcionario) lista.get(rowIndex);
//		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	@Override
	public boolean isCellEditable(int linha, int coluna) {
		if (classe.getName().equalsIgnoreCase("entity.Agenda")) {
			if (coluna == 1) {
				return coluna == 1;
			}
		}
		return false;
	}
	
	@Override
	public Class<?> getColumnClass(int coluna) {
		if (classe.getName().equalsIgnoreCase("entity.Agenda")) {
			return getValueAt(0, coluna).getClass();
		}
		 return classe;
	}
	
}
