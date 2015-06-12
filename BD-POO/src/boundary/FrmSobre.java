package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import entity.Usuario;
import util.ConfiguracoesTela;

public class FrmSobre {

	private JFrame janela;
	private ConfiguracoesTela configTela;
	private JTextPane txtpnInformacoes;
	private JPanel panPrincipal;
	private JButton btnOk;
	private JLabel lblBarraVermelhaEmCima;
	private JLabel lblBarraVermelhaEmBaixo;
	private JLabel lblBarraCinzaEmCima;
	private JLabel lblBarraCinzaEmBaixo;
	private JScrollPane spInformacoes;

	public FrmSobre(Usuario u){
		
		janela = new JFrame("Sobre");
		
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(145, 264, 89, 23);
		panPrincipal.add(btnOk);
		
		lblBarraVermelhaEmCima = new JLabel("");
		lblBarraVermelhaEmCima.setIcon(new ImageIcon(FrmSobre.class.getResource("/img/teste.png")));
		lblBarraVermelhaEmCima.setBounds(0, 11, 362, 14);
		panPrincipal.add(lblBarraVermelhaEmCima);
		
		lblBarraVermelhaEmBaixo = new JLabel("");
		lblBarraVermelhaEmBaixo.setIcon(new ImageIcon(FrmSobre.class.getResource("/img/teste.png")));
		lblBarraVermelhaEmBaixo.setBounds(22, 307, 362, 14);
		panPrincipal.add(lblBarraVermelhaEmBaixo);
		
		lblBarraCinzaEmCima = new JLabel("");
		lblBarraCinzaEmCima.setIcon(new ImageIcon(FrmSobre.class.getResource("/img/teste2.png")));
		lblBarraCinzaEmCima.setBounds(41, 25, 343, 14);
		panPrincipal.add(lblBarraCinzaEmCima);
		
		lblBarraCinzaEmBaixo = new JLabel("");
		lblBarraCinzaEmBaixo.setIcon(new ImageIcon(FrmSobre.class.getResource("/img/teste2.png")));
		lblBarraCinzaEmBaixo.setBounds(0, 293, 343, 14);
		panPrincipal.add(lblBarraCinzaEmBaixo);
		
		spInformacoes = new JScrollPane();
		spInformacoes.setBounds(53, 50, 279, 180);
		panPrincipal.add(spInformacoes);
		
		txtpnInformacoes = new JTextPane();
		spInformacoes.setViewportView(txtpnInformacoes);
		txtpnInformacoes.setEditable(false);
		txtpnInformacoes.setText("Projeto desenvolvido na institui\u00E7\u00E3o FATEC da zona leste, no 4\u00BA semestre do curso de an\u00E1lise e desenvolvimento de sistemas sob orienta\u00E7\u00E3o dos prof(a) ms. Antonio e Leandro.\r\n\r\n               \t  Alunos:\r\n\tHury Gabriel\r\n\tPedro Afonso\t\r\n\tPedro Zuzi\r\n\r\n ");
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		configTela = new ConfiguracoesTela();
		janela.setSize(400,371);
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
		btnOk.addActionListener( e -> {
			janela.dispose();
			janela = null;
			new FrmPrincipal(u);
		});
	}
	
	
	public static void main(String[] args) {

		new FrmSobre(new Usuario());
	}
}
