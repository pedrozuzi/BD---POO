package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfiguracoesTela;

public class FrmServico {

	
	private JFrame janela;
	private JPanel panel;
	private ConfiguracoesTela configTela;

	public FrmServico() {
		
		janela = new JFrame("Servico");
		panel = new JPanel();
		configTela = new ConfiguracoesTela( janela );
		janela.setVisible(true);
		janela.setContentPane(panel);
	
	}
	
	public static void main(String[] args) {
		new FrmServico();
	}
}
