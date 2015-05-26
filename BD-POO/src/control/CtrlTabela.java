package control;

import javax.swing.table.DefaultTableModel;

public class CtrlTabela extends DefaultTableModel {

	private static final long serialVersionUID = 8665332737558983591L;

	public CtrlTabela(Object[][] dados, String[] cabecalho){
		super.setDataVector(dados, cabecalho);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
