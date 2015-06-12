package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.ConfiguracoesTela;
import control.CtrlLogin;
import control.CtrlStatus;
import entity.Usuario;

public class FrmLogin {

	private JFrame janela ;
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JButton btnLogar;
	private CtrlLogin controlLogin;
	private JPanel panPrincipal;
	private JLabel lblBarraVermelhaBaixo;
	private JLabel lblBarraVermelhaCima;
	private JLabel lblBarraCinza;
	private JLabel lblStatus;
	private ConfiguracoesTela configTela;
	private JLabel lblLogoLudPet;

	public FrmLogin() {

		janela = new JFrame("Realizar Login");
		
		controlLogin = new CtrlLogin();
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setBackground(SystemColor.info);
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsuario.setBounds(116, 242, 241, 28);
		panPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);

		pwdSenha = new JPasswordField();
		pwdSenha.setBackground(SystemColor.info);
		pwdSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		pwdSenha.setBounds(116, 287, 241, 28);
		panPrincipal.add(pwdSenha);

		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsuario.setBounds(27, 247, 61, 14);
		panPrincipal.add(lblUsuario);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSenha.setBounds(27, 292, 61, 14);
		panPrincipal.add(lblSenha);

		btnLogar = new JButton("Entrar");
		btnLogar.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/login.png")));
		btnLogar.setToolTipText("Realizar Login no Sistema");
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogar.setBounds(259, 327, 103, 28);
		panPrincipal.add(btnLogar);

		lblStatus = new JLabel("");
		lblStatus.setToolTipText("Conexão OFFLINE");
		lblStatus.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/dtbasenull.png"))); //
		lblStatus.setBounds(24, 327, 32, 38);
		panPrincipal.add(lblStatus);

		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/logo.png")));
		lblLogoLudPet.setBounds(73, 31, 241, 205);
		panPrincipal.add(lblLogoLudPet);

		lblBarraCinza = new JLabel("");
		lblBarraCinza.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/teste2.png")));
		lblBarraCinza.setBounds(0, 317, 171, 14);
		panPrincipal.add(lblBarraCinza);

		lblBarraVermelhaBaixo = new JLabel("");
		lblBarraVermelhaBaixo.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/teste.png")));
		lblBarraVermelhaBaixo.setBounds(0, 335, 225, 30);
		panPrincipal.add(lblBarraVermelhaBaixo);

		lblBarraVermelhaCima = new JLabel("");
		lblBarraVermelhaCima.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/teste.png")));
		lblBarraVermelhaCima.setBounds(0, 0, 398, 28);
		panPrincipal.add(lblBarraVermelhaCima);
		
		janela.setContentPane(panPrincipal);
		janela.setSize(403, 404);
		configTela = new ConfiguracoesTela();
		configTela.iconeBarra(janela);
		configTela.tamanho(janela);
		
		btnLogar.addActionListener(e -> {
			if (!validaCampos()) {
				logar();
			}
		});

		status();
	}

	private void logar() {
		
		Usuario u = new Usuario();
		u.setNome(txtUsuario.getText());
		u.setSenha(new String(pwdSenha.getPassword()));
		
		if (controlLogin.realizarLogin(u)) {
			janela.dispose();
			janela = null;
			new FrmPrincipal(u);
		} else {
			JOptionPane.showMessageDialog(null, "Login ou senha incorreto");
			pwdSenha.setText("");
		}

	}

	private boolean validaCampos() {
		return txtUsuario.getText().isEmpty()
				|| pwdSenha.getPassword().equals("");
	}

	public void status() {

		CtrlStatus ctrls = new CtrlStatus();

		if (ctrls.verificaStatus().equals("ONLINE")) {
			lblStatus.setIcon(new ImageIcon(FrmLogin.class
					.getResource("/img/dtbaseok.png")));
			lblStatus.setToolTipText("Conexão ONLINE!");
		} else if (ctrls.verificaStatus().equals("OFFLINE")) {
			lblStatus.setIcon(new ImageIcon(FrmLogin.class
					.getResource("/img/dtbasenull.png")));
			lblStatus.setToolTipText("Conexão OFFLINE!");
		}

	}

	public static void main(String[] args) {
		new FrmLogin();
	}

}
