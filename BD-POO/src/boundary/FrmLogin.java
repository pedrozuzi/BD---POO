package boundary;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

	public FrmLogin(){
		
		controlLogin = new CtrlLogin();
		panPrincipal = new JPanel();
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(SystemColor.info);
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsuario.setBounds(99, 152, 241, 28);
		panPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBackground(SystemColor.info);
		pwdSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		pwdSenha.setBounds(99, 197, 241, 28);
		panPrincipal.add(pwdSenha);
		
		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsuario.setBounds(10, 157, 61, 14);
		panPrincipal.add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSenha.setBounds(10, 202, 61, 14);
		panPrincipal.add(lblSenha);
		
		btnLogar = new JButton("Entrar");
		btnLogar.setToolTipText("Realizar Login no Sistema");
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogar.setBounds(257, 236, 83, 28);
		panPrincipal.add(btnLogar);
		
		lblLogoLudPet = new JLabel("");
		lblLogoLudPet.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/LogoPetShop100.png")));
		lblLogoLudPet.setBounds(-39, 0, 417, 129);
		panPrincipal.add(lblLogoLudPet);
		
		janela.setContentPane( panPrincipal );
		janela.setSize(398,313);
		ConfigTelas.centralizarFrame(janela);
		
		btnLogar.addActionListener(e -> {
			if ( !validaCampos() ) {
				Usuario u = new Usuario();
				u.setNome(txtUsuario.getText());
				u.setSenha(new String (pwdSenha.getPassword()));
				
				if ( controlLogin.realizarLogin(u) ) {
					new FrmPrincipal();
					janela.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
				}
			}
			
		});
	}
	private boolean validaCampos() {
		return txtUsuario.getText().isEmpty() || pwdSenha.getPassword().equals("");
	}
	public static void main(String[] args) {
		new FrmLogin();
	}
}
