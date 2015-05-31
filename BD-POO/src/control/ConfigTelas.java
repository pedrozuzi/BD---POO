package control;

import java.text.ParseException;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
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
