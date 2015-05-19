package boundary;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

public class FrmFuncionario {

	private JFrame janela = new JFrame("Cadastro de Funcionário");
	private JTextField txtCod;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTextField txtSalario;

	public FrmFuncionario() {
		
		JPanel panPrincipal = new JPanel();
		JPanel panForm = new JPanel();
		
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		JLabel lblCod = new JLabel("Código: ");
		lblCod.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCod.setBounds(10, 41, 54, 18);
		panPrincipal.add(lblCod); //////////////////
		
		txtCod = new JTextField();
		txtCod.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCod.setBounds(74, 38, 86, 27);
		txtCod.setColumns(10);
		panPrincipal.add(txtCod);    /////////////////
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCpf.setBounds(10, 88, 46, 14);
		panPrincipal.add(lblCpf);     ///////////////////
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCpf.setBounds(74, 79, 124, 27);
		panPrincipal.add(txtCpf);        ///////
		txtCpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNome.setBounds(10, 123, 46, 14);
		panPrincipal.add(lblNome);    //////////////
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNome.setBounds(74, 117, 350, 27);
		panPrincipal.add(txtNome);  ///////////
		txtNome.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCargo.setBounds(10, 162, 46, 18);
		panPrincipal.add(lblCargo); //////////
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCargo.setBounds(74, 159, 350, 27);
		panPrincipal.add(txtCargo); /////////////
		txtCargo.setColumns(10);
		
		JLabel lblSalrio = new JLabel("Salário:");
		lblSalrio.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSalrio.setBounds(10, 200, 62, 17);
		panPrincipal.add(lblSalrio);   /////////////
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSalario.setBounds(74, 196, 107, 27);
		panPrincipal.add(txtSalario);  /////////////
		txtSalario.setColumns(10);
		
		JLabel lblBackGround = new JLabel();
		lblBackGround.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/BackGround.png")));
		lblBackGround.setBounds(0, 0, 450, 341);
		panPrincipal.add(lblBackGround); ///////////
		
		janela.setSize(450,341);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new FrmFuncionario();
	}
}
