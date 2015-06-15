package util;

import java.lang.reflect.Method;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import entity.Agenda;
import entity.Coluna;

/**
 * Classe para montar o modelo das Tabelas dinamicamente
 * @author Pedro Zuzi
 *
 */
public class ModeloTabela extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	private final List<?> lista;
	private Class<?> classe;

	/**
	 * Construtor
	 * @param lista, recebe uma lista de uma determinada classe
	 */
	public ModeloTabela(List<?> lista) {
		this.lista = lista;
		this.classe = lista.get(0).getClass();
	}

	/**
	 * M�todo para limpar a Tabela
	 */
	public void clear(){
		lista.clear();
		fireTableRowsDeleted(0, lista.size());
	}
	
	/**
	 * M�todo para retorno do n�mero de linhas da Tabela
	 * @return quantidade de linhas
	 */
	@Override
	public int getRowCount() {
		return lista.size();
	}
	
	/**
	 * M�todo para retorno do n�mero de colunas da Tabela
	 * @return quantidade de colunas
	 */
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

	/**
	 * M�todo para percorrer os m�todos de uma determinada classe
	 * e montar a tabela dinamicamente de acordo com as anota��es
	 * @return valor do m�todo da classe
	 */
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
	
	/**
	 * M�todo para adicionar o nome da coluna de acordo
	 * com a anota��o
	 * @return nome da coluna
	 */
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
	
	/**
	 * M�todo para setar o valor modificado na Tabela
	 */
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		
		if (classe.getName().equalsIgnoreCase("entity.Agenda")) {
			if (coluna == 1) {
				Agenda a = (Agenda) lista.get(linha);
				a.setEscolhaHorario((Boolean) valor);
				fireTableCellUpdated(linha, coluna);
			}
		} 

	}
	
	/**
	 * M�todo para retorno se a tabela vai ser edit�vel
	 * @return true se edit�vel, false se n�o edit�vel
	 */
	@Override
	public boolean isCellEditable(int linha, int coluna) {
		if (classe.getName().equalsIgnoreCase("entity.Agenda")) {
			if (coluna == 1) {
				return coluna == 1;
			}
		}
		return false;
	}
	
	/**
	 * M�todo para retorno da classe da coluna atrav�s do seu
	 * �ndice 
	 * @return classe
	 */
	@Override
	public Class<?> getColumnClass(int coluna) {
		if (classe.getName().equalsIgnoreCase("entity.Agenda")) {
			return getValueAt(0, coluna).getClass();
		}
		return classe;
	}
	
}
