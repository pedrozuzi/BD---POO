package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import control.CtrlLogin;
import entity.Login;


/**
 * 
 * @author Hury
 *
 */

public class FrmLogin {

	private JFrame janela = new JFrame("Realizar Login");
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JButton btnLogar;
	private CtrlLogin controlLogin;

	public FrmLogin(){
		controlLogin = new CtrlLogin();
		JPanel panPrincipal = new JPanel();
		JPanel panForm = new JPanel();
		
		janela.setContentPane( panPrincipal);
		panPrincipal.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsuario.setBounds(95, 61, 241, 28);
		panPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		pwdSenha.setBounds(95, 124, 241, 28);
		panPrincipal.add(pwdSenha);
		
		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 67, 61, 14);
		panPrincipal.add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSenha.setBounds(10, 130, 61, 14);
		panPrincipal.add(lblSenha);
		
		btnLogar = new JButton("Logar");
		btnLogar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLogar.setBounds(247, 174, 89, 43);
		panPrincipal.add(btnLogar);
		janela.setSize(400,281);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
