package boundary;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrmPrincipal {

	
	private JFrame janela;
	private JButton btnCadastro;
	private JButton btnAgendarServico;
	private JButton btnRealizarVenda;
	private JButton btnRelatorio;

	public FrmPrincipal(){
		
		JPanel panPrincipal = new JPanel();
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		janela.setSize(400,281);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	public static void main(String[] args) {

		new FrmPrincipal();
	}
	
}
