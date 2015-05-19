package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Hury
 *
 */
public class FrmSobre {

	private JFrame janela = new JFrame("Produto");

	public FrmSobre(){
		
		JPanel panPrincipal = new JPanel();
		JPanel panForm = new JPanel();
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		janela.setSize(400,281);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new FrmSobre();
	}
}
