package boundary;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

/**
 * Classe que apresenta informações sobre o desenvolvimento do projeto
 * @author Pedro Afonso
 * @author Pedro Zuzi
 *
 */
public class FrmSobre {

	private JDialog jd;
	private JTextPane txtpnInformacoes;
	private JPanel panPrincipal;
	private JLabel lblBarraVermelhaEmCima;
	private JLabel lblBarraVermelhaEmBaixo;
	private JLabel lblBarraCinzaEmCima;
	private JLabel lblBarraCinzaEmBaixo;
	private JScrollPane spInformacoes;

	public FrmSobre(){
		jd = new JDialog(jd, "Sobre", true);
		
		try {
			BufferedImage image = ImageIO.read(  
			        this.getClass().getResource("/img/icon.png"));
			jd.setIconImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		jd.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
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
		txtpnInformacoes.setText("Projeto desenvolvido na institui\u00E7\u00E3o "
				+ "FATEC da zona leste, no 4\u00BA semestre do curso de "
				+ "an\u00E1lise e desenvolvimento de sistemas do ano de 2015 sob orienta"
				+ "\u00E7\u00E3o dos prof(a) ms. Antonio Rodrigues e Leandro Colevati.\r\n\r\n"
				+ "               \tAlunos:\r\n\tHury Gabriel\r\n\tPedro "
				+ "Afonso\t\r\n\tPedro Zuzi\r\n ");
		
		jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		jd.setContentPane( panPrincipal );
		jd.setSize(400,371);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
	}
}
