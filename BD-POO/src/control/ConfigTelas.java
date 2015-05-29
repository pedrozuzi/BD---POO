package control;

import javax.swing.JFrame;
/**
 * 
 * @author Zuzi
 *
 */

public interface ConfigTelas {
	
	static void centralizarFrame(JFrame janela) {
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	static void telaBuscaCliente(JFrame janela){
		janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	


}
