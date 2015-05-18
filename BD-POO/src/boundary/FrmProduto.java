package boundary;



import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FrmProduto {

	private JFrame janela = new JFrame("Produto");

	public FrmProduto(){
		
		JPanel panPrincipal = new JPanel();
		JPanel panForm = new JPanel();
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/BackGround.png")));
		lblNewLabel.setBounds(0, 0, 556, 323);
		panPrincipal.add(lblNewLabel);
		janela.setSize(572,362);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new FrmProduto();
	}
}
