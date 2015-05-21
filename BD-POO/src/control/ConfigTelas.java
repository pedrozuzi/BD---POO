package control;

import javax.swing.JFrame;
/**
 * 
 * @author Zuzi
 *
 */

public interface ConfigTelas {
	
	default void centralizarFrame(JFrame janela) {
        janela.setLocationRelativeTo(null);
    }

}
