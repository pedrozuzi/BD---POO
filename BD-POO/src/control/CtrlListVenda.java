package control;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class CtrlListVenda {

	
	DefaultListModel model = new DefaultListModel();
	JList list = new JList(model);
	 
	
	
	public CtrlListVenda() {
		model.add(0, "item 1");
		model.add(1, "item 2");
		model.add(2, "item 3");
		
		
		//Adicionando dados no final do JList de forma dinâmica:
DefaultListModel model = (DefaultListModel) list.getModel();
model.add(model.getSize(), "item final");

//Adicionando dados no começo do JList de forma dinâmica:

DefaultListModel model = (DefaultListModel) list.getModel();
model.add(0, "item começo");
		
//Inserindo scroll para o JList:

DefaultListModel model = new DefaultListModel();
JList list = new JList(model);
 
// adicionar dados no list
// ..
//scroll
JScrollPane jscroll = new JScrollPane(list);

//Enviando scroll para o final automaticamente:

DefaultListModel model = new DefaultListModel();
JList list = new JList(model);
 
// adicionar dados no list
// ..
//scroll
JScrollPane jscroll = new JScrollPane(list);
 
jscroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
    public void adjustmentValueChanged(AdjustmentEvent e) {  
         e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
}});

//Limpando itens do JList:

// limpando todo o Jlist
list.setModel(new DefaultListModel());
 
// limpando todo o JList de outra forma
DefaultListModel model = (DefaultListModel) list.getModel();
model.clear();
 
// removendo o segundo item do list
mode.remove(1);
 
// removendo o ultimo item do list
int pos = model.getSize() - 1;
if (pos >= 0) {
    model.remove(pos);
}

//Substituíndo itens:

DefaultListModel model = (DefaultListModel) list.getModel();
model.set(0, "Reescrevendo o primeiro item do list");

//Selecionando itens no List:

// selecionando o primeiro item
list.setSelectedIndex(0);
 
// selecionando o ultimo item do list
DefaultListModel model = (DefaultListModel) list.getModel();
list.setSelectedIndex(model.getSize() - 1);
 
//limpando seleções
list.clearSelection();

//Obtendo índices selecinados

// retorna o indice do primeiro item selecioando na lista
int index = list.getSelectedIndex();
 
// retorna array contendo todos os indices selecionados na lista
int[] indexes = list.getSelectedIndices();


	}

	
	
	
}

