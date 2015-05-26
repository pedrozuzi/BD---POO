package boundary;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;

import control.ConfigTelas;
import control.CtrlLogin;
import entity.Login;

public class FrmLogin implements ConfigTelas{

	private JFrame janela = new JFrame("Realizar Login");
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JButton btnLogar;
	private CtrlLogin controlLogin;
	private JPanel panPrincipal;
	private JLabel lblLogo;

	public FrmLogin(){
		
		controlLogin = new CtrlLogin();
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setLayout(null);
		
		janela.setContentPane( panPrincipal);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsuario.setBounds(95, 83, 241, 28);
		panPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		pwdSenha.setBounds(95, 146, 241, 28);
		panPrincipal.add(pwdSenha);
		
		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 89, 61, 14);
		panPrincipal.add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSenha.setBounds(10, 152, 61, 14);
		panPrincipal.add(lblSenha);
		
		btnLogar = new JButton("");
		btnLogar.setIcon(new ImageIcon(FrmLogin.class.getResource
				("/img/icon_Login_in.png")));
		btnLogar.setToolTipText("Realizar Login no Sistema");
		btnLogar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLogar.setBounds(281, 194, 55, 57);
		panPrincipal.add(btnLogar);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmLogin.class.getResource
				("/img/ludpetLogin.png")));
		lblLogo.setBounds(33, 11, 326, 61);
		panPrincipal.add(lblLogo);
		
		janela.setSize(400,300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centralizarFrame(janela);
		
		btnLogar.addActionListener(e -> {
			Login l = new Login();
			l.setUsuario(txtUsuario.getText());
			l.setSenha(new String (pwdSenha.getPassword()));
			controlLogin.realizarLogin(l);
		});
	}
	public static void main(String[] args) {
		new FrmLogin();
	}
}
