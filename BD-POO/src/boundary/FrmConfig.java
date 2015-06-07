package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfiguracoesTela;

import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Window.Type;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Hury
 *
 */

public class FrmConfig {

	private JFrame janela = new JFrame("Configurações");
	private JTextField txtIp;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static int estilo=1; //FIXME
	
	public FrmConfig() {

		JPanel panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);

		janela.setContentPane(panPrincipal);
		panPrincipal.setLayout(null);

		// XXX DEL-ME
		 janela.setSize(576,451);
		 janela.setVisible(true);
		 janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// CONFIGURACOES DE TELA, COMENTAR PARA EDITAR NO WINDOW BUILDER!!
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);
		configTela.tamanho(janela, 575, 450);
		configTela.centralizeFrame(janela);
		configTela.selecionaEstilo(estilo); // 1=nimbus
		configTela.estilo(janela);
		// COMENTAR ATÈ AQUI!!

		JPanel panServidor = new JPanel();
		panServidor.setBorder(new TitledBorder(null, "Servidor",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panServidor.setBounds(41, 34, 473, 241);
		panPrincipal.add(panServidor);
		panServidor.setLayout(null);
		panServidor.setOpaque(false);

		JPanel panTema = new JPanel();
		panTema.setBorder(new TitledBorder(null, "Tema", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panTema.setBounds(41, 286, 473, 93);
		panPrincipal.add(panTema);
		panTema.setLayout(null);
		panTema.setOpaque(false);

		@SuppressWarnings("rawtypes")
		JComboBox cmbEstilo = new JComboBox();
		cmbEstilo.setModel(new DefaultComboBoxModel(new String[] { "Metal",
				"Nimbus", "CDE/Motif", "Windows", "Windows classic" }));
		cmbEstilo.setSelectedIndex(1);
		cmbEstilo.setBounds(60, 51, 112, 20);
		panTema.add(cmbEstilo);

		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				estilo= cmbEstilo.getSelectedIndex();
				System.out.println(estilo);
				configTela.selecionaEstilo(estilo); // 1=nimbus
				configTela.estilo(janela);
			}
		});
		btnAplicar.setBounds(350, 50, 89, 23);
		panTema.add(btnAplicar);

		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstilo.setBounds(21, 26, 46, 14);
		panTema.add(lblEstilo);

		txtIp = new JTextField();
		txtIp.setBounds(83, 81, 146, 23);
		panServidor.add(txtIp);
		txtIp.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ip:");
		lblNewLabel.setBounds(31, 84, 20, 14);
		panServidor.add(lblNewLabel);

		JCheckBox chbLocalHost = new JCheckBox("LocalHost");
		chbLocalHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chbLocalHost.isSelected()){
				txtIp.setText("localhost:1433");
				}else{
					txtIp.setText("");
				}
			}
		});
		chbLocalHost.setBounds(234, 80, 86, 23);
		panServidor.add(chbLocalHost);

		textField_1 = new JTextField();
		textField_1.setBounds(83, 137, 119, 23);
		panServidor.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(83, 168, 119, 23);
		panServidor.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(83, 47, 145, 23);
		panServidor.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(31, 50, 46, 14);
		panServidor.add(lblNome);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(31, 140, 53, 14);
		panServidor.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(31, 171, 41, 14);
		panServidor.add(lblSenha);

		JLabel lblInformaesDoServidor = new JLabel(
				"Informa\u00E7\u00F5es do Servidor");
		lblInformaesDoServidor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformaesDoServidor.setBounds(21, 25, 154, 14);
		panServidor.add(lblInformaesDoServidor);

		JLabel lblInformaesDo = new JLabel("Informa\u00E7\u00F5es de Logon");
		lblInformaesDo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformaesDo.setBounds(21, 112, 174, 14);
		panServidor.add(lblInformaesDo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(351, 207, 89, 23);
		panServidor.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(252, 207, 89, 23);
		panServidor.add(btnCancelar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmConfig.class
				.getResource("/img/teste.png")));
		label.setBounds(0, 0, 514, 14);
		panPrincipal.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmConfig.class
				.getResource("/img/teste.png")));
		label_1.setBounds(51, 398, 514, 14);
		panPrincipal.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FrmConfig.class
				.getResource("/img/teste2.png")));
		label_2.setBounds(0, 11, 191, 14);
		panPrincipal.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FrmConfig.class
				.getResource("/img/teste2.png")));
		label_3.setBounds(369, 387, 191, 14);
		panPrincipal.add(label_3);

		try {
			janela.repaint();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {

		new FrmConfig();
	}
}
