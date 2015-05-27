package control;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ModeloTabela implements TableModel {
	
	Object dados[][];
	String[] colunas;


	public ModeloTabela(Object[][] dados, String[] colunas) {
		this.dados = dados;
		this.colunas = colunas;
	}

	@Override
	public int getRowCount() {
		return dados[0].length;
	}

	@Override
	public int getColumnCount() {
		return dados.length;
	}

	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return getValueAt(0, coluna).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		return dados[linha][coluna];
	}

	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		dados[linha][coluna] = valor;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

}
