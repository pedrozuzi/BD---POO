package control;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class ConfiguracoesTela extends JFrame {
	
	private JFrame tela;
	protected static String look="javax.swing.plaf.nimbus.NimbusLookAndFeel";
	protected static int tamanhofonte=16;
	
	public ConfiguracoesTela(JFrame tela) {
		this.tela = tela;
	}
	
	/**
	 * Método que altera o icone das telas
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
	
	public JFrame tamanho(JFrame tela, int x, int y){
		
		//tela.setSize(942, 670);
		tela.setSize(x, y);
		tela.setVisible(true);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return tela;
	}
	
	/**
	 * Método para centralizar as telas no centro
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
	  * Método que seta o estilo de todas as telas
	  */
	  public void estilo(){		  
		  try {
			 UIManager.setLookAndFeel(look);
			 javax.swing.SwingUtilities.updateComponentTreeUI( this );
			} catch (Exception e) {
				System.out.println(e);
			}		  
	  }
	  
		public void selecionaEstilo(int opcEstilo){		//org.jvnet.substance.SubstanceLookAndFeel
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
		}

}
