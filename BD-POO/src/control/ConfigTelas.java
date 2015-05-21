package control;

import javax.swing.JFrame;

public interface ConfigTelas {
	
	default void centralizeFrame(JFrame janela) {
        janela.setLocationRelativeTo(null);
    }

}
