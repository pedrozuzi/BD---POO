package control;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class ConfiguracoesTela extends JFrame {

	private static final long serialVersionUID = 1L;

	protected static String look = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	protected static int tamanhofonte = 16;

	public JFrame iconeBarra(JFrame tela) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(this.getClass().getResource("/img/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		tela.setIconImage(image);

		return tela;
	}

	public void tamanho(JFrame tela) {

        tela.setLocationRelativeTo(null);
        tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
		
	}

	public void estilo(JFrame tela) {
		try {
			UIManager.setLookAndFeel(look);
			javax.swing.SwingUtilities.updateComponentTreeUI(tela);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String selecionaEstilo(int opcEstilo) { // org.jvnet.substance.SubstanceLookAndFeel
		switch (opcEstilo) {
		case 0:
			look = "javax.swing.plaf.metal.MetalLookAndFeel";
			break;
		case 1:
			look = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
			break;
		case 2:
			look = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			break;
		case 3:
			look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			break;
		case 4:
			look = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
		}

		return look;
	}

}
