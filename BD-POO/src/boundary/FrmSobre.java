package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import util.ConfiguracoesTela;

import java.awt.Window.Type;


public class FrmSobre {

	private JFrame janela = new JFrame("Sobre");
	private ConfiguracoesTela configTela;

	public FrmSobre(){
		
		JPanel panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		JPanel panForm = new JPanel();
		janela.setType(Type.UTILITY);
		janela.setResizable(false);
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setBounds(145, 264, 89, 23);
		panPrincipal.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmSobre.class.getResource("/img/teste.png")));
		label.setBounds(0, 11, 362, 14);
		panPrincipal.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(286, 217, 46, 14);
		panPrincipal.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FrmSobre.class.getResource("/img/teste.png")));
		label_2.setBounds(22, 307, 362, 14);
		panPrincipal.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FrmSobre.class.getResource("/img/teste2.png")));
		label_3.setBounds(41, 25, 343, 14);
		panPrincipal.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(FrmSobre.class.getResource("/img/teste2.png")));
		label_4.setBounds(0, 293, 343, 14);
		panPrincipal.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 50, 279, 180);
		panPrincipal.add(scrollPane);
		
		JTextPane txtpnHuryGabrielPedro = new JTextPane();
		scrollPane.setViewportView(txtpnHuryGabrielPedro);
		txtpnHuryGabrielPedro.setEditable(false);
		txtpnHuryGabrielPedro.setText("Projeto desenvolvido na institui\u00E7\u00E3o FATEC da zona leste, no 4\u00BA semestre do curso de an\u00E1lise e desenvolvimento de sistemas sob orienta\u00E7\u00E3o dos prof(a) ms. Antonio e Leandro.\r\n\r\n               \t  Alunos:\r\n\tHury Gabriel\r\n\tPedro Afonso\t\r\n\tPedro Zuzi\r\n\r\n ");
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		configTela = new ConfiguracoesTela();
		janela.setSize(400,371);
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
	}
	
	
	public static void main(String[] args) {

		new FrmSobre();
	}
}
