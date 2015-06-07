package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.ConfigTelas;
import control.ConfiguracoesTela;
import control.CtrlLogin;
import control.CtrlStatus;
import entity.Usuario;

public class FrmLogin {

	private JFrame janela = new JFrame("Realizar Login");
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JButton btnLogar;
	private CtrlLogin controlLogin;
	private JPanel panPrincipal;
	private JLabel lblLogoLudPet;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblStatus;

	public FrmLogin() {

		// CONFIGURACOES DE TELA, PODER SER NECESSARIO COMENTAR PARA EDITAR NO
		// WINDONBUILDER
		ConfiguracoesTela configTela = new ConfiguracoesTela(janela);
		configTela.iconeBarra(janela);

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

		janela.setContentPane(panPrincipal);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/teste2.png")));
		label_2.setBounds(0, 317, 171, 14);
		panPrincipal.add(label_2);

		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/teste.png")));
		label.setBounds(0, 335, 225, 30);
		panPrincipal.add(label);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmLogin.class
				.getResource("/img/teste.png")));
		label_1.setBounds(0, 0, 398, 28);
		panPrincipal.add(label_1);
		janela.setSize(403, 404);
		ConfigTelas.centralizarFrame(janela);

		btnLogar.addActionListener(e -> {
			if (!validaCampos()) {
				logar();
			}

		});

		atalho();

		status();
	}

	private void atalho() {
		ActionMap am = panPrincipal.getActionMap();
		InputMap im = panPrincipal.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "logar");

		am.put("logar", new AbstractAction() {
			private static final long serialVersionUID = -4298843843983246541L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!validaCampos()) {
					logar();
				}
			}
		});

	}

	private void logar() {
		Usuario u = new Usuario();
		u.setNome(txtUsuario.getText());
		u.setSenha(new String(pwdSenha.getPassword()));
		if (controlLogin.realizarLogin(u)) {
			if (u.getF().getIdTipo() != 1) {
				new FrmPrincipal(u);
				janela.dispose();
			} else {
				new FrmPrincipalAdm(u);
				janela.dispose();
			}

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
