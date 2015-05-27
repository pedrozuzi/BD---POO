package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import control.ConfigTelas;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmCliente {
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JPanel panel;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JLabel lblExcluir;
	private JLabel lblPesquisar;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JLabel lblLogo;
	private JTextField txtNome;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtTelefone;
	private JLabel lblTelefone;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnLupaPesquisar;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	
	public FrmCliente() {
		janela = new JFrame("Cliente");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 649, 186);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(45, 387, 74, 14);
		panPrincipal.add(lblLogradouro);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(45, 339, 46, 14);
		panPrincipal.add(lblNome);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(129, 384, 318, 20);
		panPrincipal.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(129, 336, 318, 20);
		panPrincipal.add(txtNome);
		txtNome.setColumns(10);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(112, 11, 426, 79);
		panPrincipal.add(panel);
		
		btnIncluir = new JButton("");
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setVisible(true);
		panel.add(btnIncluir);
		
		lblIncluir = new JLabel("(F2) Incluir");
		btnIncluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Insert.png")));
		lblIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIncluir.setVisible(true);
		lblIncluir.setBounds(54, 54, 69, 19);
		panel.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setVisible(true);
		panel.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterar.setVisible(true);
		lblAlterar.setBounds(162, 54, 44, 19);
		panel.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setVisible(true);
		panel.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblExcluir.setVisible(true);
		lblExcluir.setBounds(252, 53, 38, 19);
		panel.add(lblExcluir);
		
		lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPesquisar.setVisible(true);
		lblPesquisar.setBounds(336, 53, 59, 19);
		panel.add(lblPesquisar);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/View.png")));
		btnPesquisar.setVisible(true);
		btnPesquisar.setBounds(326, 11, 69, 41);
		panel.add(btnPesquisar);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(495, 531, 96, 31);
		panPrincipal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(285, 531, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(83, 531, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipal.add(btnVoltar);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(479, 322, 65, 31);
		btnLupaPesquisar.setVisible(false);
		panPrincipal.add(btnLupaPesquisar);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(FrmFuncionario.class.getResource
				("/img/LogoLudpet.png")));
		lblLogo.setBounds(45, 154, 546, 199);
		panPrincipal.add(lblLogo);
		
		
		janela.setSize(685,622);
		janela.setContentPane( panPrincipal);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(128, 419, 86, 20);
		panPrincipal.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(290, 419, 269, 20);
		panPrincipal.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(129, 473, 133, 20);
		panPrincipal.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(45, 425, 61, 14);
		panPrincipal.add(lblNumero);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(234, 422, 46, 14);
		panPrincipal.add(lblBairro);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(45, 476, 69, 14);
		panPrincipal.add(lblTelefone);
		ConfigTelas.centralizarFrame(janela);
		
		
		btnLimpar.addActionListener(l -> limpaCampos() );
		
		btnIncluir.addActionListener(l -> {
			btnGravar.setEnabled(true);
			btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
					("/img/MiniSalvar.png")));
			btnGravar.setText("Gravar");
			btnGravar.setActionCommand("Incluir");
			telaInserirFornecedor();
		});
		
		
	}
	
	private void telaInserirFornecedor() {
		//TODO
		
	}

	private void limpaCampos() {
		txtNome.setText("");
		txtLogradouro.setText("");
		txtNumero.setText("");
		txtBairro.setText("");
		txtTelefone.setText("");
	}

	public static void main(String[] args) {
		new FrmCliente();
	}
}
