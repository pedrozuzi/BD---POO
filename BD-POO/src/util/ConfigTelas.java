package util;

import javax.swing.JDialog;
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
	
	static void telaBuscaCliente(JDialog jd){
		jd.setSize(650,300);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
	}
}
