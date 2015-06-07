package control;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * Classe que possui os metodos de configura��es de tela
 * @author Hury
 *
 */

public class ConfiguracoesTela extends JFrame {
	
	private JFrame tela;
	protected static String look="javax.swing.plaf.nimbus.NimbusLookAndFeel";
	protected static int tamanhofonte=16;
	
	/**
	 * Construtor
	 * @param tela
	 */
	
	public ConfiguracoesTela(JFrame tela) {
		this.tela = tela;
	}
	
	/**
	 * M�todo que altera o icone das telas
	 * @return 
	 */
	
	public JFrame iconeBarra(JFrame tela){
	     BufferedImage image = null;  
	        try {  
	            image = ImageIO.read(  
	            this.getClass().getResource("/img/icon.png"));  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        tela.setIconImage(image);
	                
	        return tela;
	}
	
	/**
	 * Metodo que altera o tamanho do JFrame
	 * @param tela Recebe o JFrame
	 * @param x Largura
	 * @param y Altura
	 * @return O JFrame apropriadamente configurado
	 */
	
	public JFrame tamanho(JFrame tela, int x, int y){
		
		tela.setSize(x, y);
		tela.setVisible(true);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return tela;
	}
	
	/**
	 * M�todo para centralizar as telas no centro
	 * @return 
	 */
	
	  public JFrame centralizeFrame( JFrame tela ){
	        int x,y;
	        Rectangle scr=tela.getGraphicsConfiguration().getBounds();
	        Rectangle form=tela.getBounds();
	        x= (int) (scr.getWidth() - form.getWidth())/2;
	        y=(int) (scr.getHeight()-form.getHeight())/2;
	        tela.setLocation(x, y);
	        
	        return tela;
	    }
	  
	 /**
	  * M�todo que seta o estilo de todas as telas
	  */
	  
	  public void estilo(JFrame janela){		  
		  try {
			 UIManager.setLookAndFeel(look);
			 javax.swing.SwingUtilities.updateComponentTreeUI( janela );
			} catch (Exception e) {
				System.out.println(e);
			}		  
	  }
	  
	  /**
	   * A Partir deste metodo � possivel selecionar o estilo da tela
	   * @param opcEstilo um n�mero de 0 a 4 que ir� selecionar o estilo da tela
	   */
	  
		public String selecionaEstilo(int opcEstilo){		//org.jvnet.substance.SubstanceLookAndFeel
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
