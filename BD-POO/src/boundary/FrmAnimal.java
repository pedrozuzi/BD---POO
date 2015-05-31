package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import control.ConfigTelas;
import control.CtrlAnimal;
import control.CtrlCliente;
import control.ModeloTabela;
import entity.Animal;
import entity.Cliente;

public class FrmAnimal extends MouseAdapter {
	
	private JFrame janelaAnimal;
	private JPanel panPrincipalAnimal;
	private JPanel panelAnimal;
	private JButton btnIncluir;
	private JLabel lblIncluir;
	private JButton btnAlterar;
	private JLabel lblAlterar;
	private JButton btnExcluir;
	private JLabel lblExcluir;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JButton btnLupaPesquisar;
	private JTextField txtNome;
	private JTextField txtRga;
	private JTextField txtRaca;
	private JTextField txtCor;
	private JTable tableAnimal;
	private JTable tableBusca;
	private JLabel lblCliente;
	private static JTextField txtCliente;
	private JLabel lblEspecie;
	private JComboBox<String> comboBoxEspecie;
	private JScrollPane scrollPane;
	private JLabel lblRaca;
	private JLabel lblCor;
	private JLabel lblSexo;
	private JLabel lblRga;
	private JComboBox<String> comboBoxSexo;
	private ModeloTabela modelo;
	private CtrlCliente controlCliente;
	private List<Cliente> listaCliente;
	private List<Animal> listaAnimal;
	private JPanel panPrincipalBusca;
	private JScrollPane scrollPaneBusca;
	private JButton btnLupaPesquisarBusca;
	private JTextField txtBuscaCliente;
	private JLabel lblNome;
	private int idCliente;
	private CtrlAnimal controlAnimal;
	
	public FrmAnimal() {
		janelaAnimal = new JFrame();
		janelaAnimal.setTitle("Animal");
		panPrincipalAnimal = new JPanel();
		panPrincipalAnimal.setBackground(SystemColor.text);
		panPrincipalAnimal.setForeground(Color.WHITE);
		panPrincipalAnimal.setLayout(null);
		
		panelAnimal = new JPanel();
		panelAnimal.setLayout(null);
		panelAnimal.setForeground(Color.WHITE);
		panelAnimal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAnimal.setBackground(Color.WHITE);
		panelAnimal.setBounds(112, 11, 343, 79);
		panPrincipalAnimal.add(panelAnimal);
		
		btnIncluir = new JButton("");
		btnIncluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Insert.png")));
		btnIncluir.setBounds(49, 11, 69, 41);
		btnIncluir.setVisible(true);
		panelAnimal.add(btnIncluir);
		
		lblIncluir = new JLabel("(F2) Incluir");
		lblIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblIncluir.setVisible(true);
		lblIncluir.setBounds(54, 54, 69, 19);
		panelAnimal.add(lblIncluir);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Edit.png")));
		btnAlterar.setBounds(143, 11, 69, 41);
		btnAlterar.setVisible(true);
		panelAnimal.add(btnAlterar);
		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlterar.setVisible(true);
		lblAlterar.setBounds(162, 54, 44, 19);
		panelAnimal.add(lblAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/Delete.png")));
		btnExcluir.setBounds(232, 11, 69, 41);
		btnExcluir.setVisible(true);
		panelAnimal.add(btnExcluir);
		
		lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblExcluir.setVisible(true);
		lblExcluir.setBounds(252, 53, 38, 19);
		panelAnimal.add(lblExcluir);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniSalvar.png")));
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setVisible(false);
		btnGravar.setBounds(406, 543, 96, 31);
		panPrincipalAnimal.add(btnGravar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniClear.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(247, 543, 96, 31);
		btnLimpar.setVisible(false);
		panPrincipalAnimal.add(btnLimpar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(FrmFornecedor.class.getResource
				("/img/MiniBack.png")));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(83, 543, 96, 31);
		btnVoltar.setVisible(false);
		panPrincipalAnimal.add(btnVoltar);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(422, 288, 65, 31);
		panPrincipalAnimal.add(btnLupaPesquisar);
		
		txtNome = new JTextField();
		txtNome.setBounds(155, 341, 238, 20);
		panPrincipalAnimal.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(81, 344, 46, 14);
		panPrincipalAnimal.add(lblNome);
		
		txtRga = new JTextField();
		txtRga.setBounds(155, 382, 128, 20);
		panPrincipalAnimal.add(txtRga);
		txtRga.setColumns(10);
		
		lblRga = new JLabel("RGA:");
		lblRga.setBounds(81, 382, 46, 14);
		panPrincipalAnimal.add(lblRga);
		
		txtRaca = new JTextField();
		txtRaca.setBounds(155, 420, 138, 20);
		panPrincipalAnimal.add(txtRaca);
		txtRaca.setColumns(10);
		
		lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setBounds(81, 423, 46, 14);
		panPrincipalAnimal.add(lblRaca);
		
		lblCor = new JLabel("Cor:");
		lblCor.setBounds(313, 423, 46, 14);
		panPrincipalAnimal.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setBounds(356, 420, 86, 20);
		panPrincipalAnimal.add(txtCor);
		txtCor.setColumns(10);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(81, 457, 46, 14);
		panPrincipalAnimal.add(lblSexo);
		
		lblEspecie = new JLabel("Esp\u00E9cie:");
		lblEspecie.setBounds(205, 454, 68, 14);
		panPrincipalAnimal.add(lblEspecie);
		
		comboBoxEspecie = new JComboBox<String>();
		comboBoxEspecie.setBounds(272, 451, 138, 20);
		comboBoxEspecie.addItem(Especie.CACHORRO.getESPECIE());
		comboBoxEspecie.addItem(Especie.GATO.getESPECIE());	
		panPrincipalAnimal.add(comboBoxEspecie);
			
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(127, 454, 38, 20);
		comboBoxSexo.addItem(SexoAnimal.MACHO.getSEXO());
		comboBoxSexo.addItem(SexoAnimal.FEMEA.getSEXO());
		panPrincipalAnimal.add(comboBoxSexo);
		
		tableAnimal = new JTable();
		tableAnimal.addMouseListener(this);
		tableAnimal.setBorder(new LineBorder(Color.BLACK));
		tableAnimal.setGridColor(Color.BLACK);
		tableAnimal.setShowGrid(true);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBorder(null);
		scrollPane.setViewportView(tableAnimal);
		scrollPane.setBounds(10, 107, 591, 159);
		scrollPane.setVisible(true);
		panPrincipalAnimal.add(scrollPane);
		
		lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(83, 299, 52, 20);
		panPrincipalAnimal.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setBounds(155, 299, 238, 20);
		panPrincipalAnimal.add(txtCliente);
		txtCliente.setColumns(10);
		
		janelaAnimal.setSize(627,656);
		janelaAnimal.setContentPane( panPrincipalAnimal );
		ConfigTelas.centralizarFrame( janelaAnimal );
		
		btnLupaPesquisar.addActionListener(l -> {
			new FrmAnimal(new JDialog(janelaAnimal, "Buscar Cliente", true));
		});
	}
	
	public FrmAnimal(JDialog jd) {
		
		panPrincipalBusca = new JPanel();
		panPrincipalBusca.setBackground(SystemColor.text);
		panPrincipalBusca.setForeground(Color.WHITE);
		panPrincipalBusca.setLayout(null);
		
		tableBusca = new JTable();
		tableBusca.addMouseListener(this);
		tableBusca.setBorder(new LineBorder(Color.BLACK));
		tableBusca.setGridColor(Color.BLACK);
		tableBusca.setShowGrid(true);
		
		scrollPaneBusca = new JScrollPane();
		scrollPaneBusca.getViewport().setBorder(null);
		scrollPaneBusca.setViewportView(tableBusca);
		scrollPaneBusca.setBounds(10, 64, 539, 159);
		panPrincipalBusca.add(scrollPaneBusca);
		
		btnLupaPesquisarBusca = new JButton("");
		btnLupaPesquisarBusca.setIcon(new ImageIcon(FrmAnimal.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisarBusca.setBounds(368, 22, 65, 31);
		btnLupaPesquisarBusca.setVisible(true);
		panPrincipalBusca.add(btnLupaPesquisarBusca);
		
		txtBuscaCliente = new JTextField();
		txtBuscaCliente.setBounds(92, 33, 264, 20);
		panPrincipalBusca.add(txtBuscaCliente);
		txtBuscaCliente.setColumns(10);
		
		btnLupaPesquisarBusca.addActionListener(l -> {
			buscaCliente();
		});
		
		jd.setContentPane( panPrincipalBusca );
		jd.setSize(580,280);
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
		
	}
	
	private void buscaCliente() {
		controlCliente = new CtrlCliente();
		listaCliente = new ArrayList<Cliente>();

			try {
				listaCliente = controlCliente.buscaClientePorNome(txtBuscaCliente.getText());
				if (!listaCliente.isEmpty()) {
					modelo = new ModeloTabela(listaCliente);
					tableBusca.getTableHeader().setReorderingAllowed(false);
					tableBusca.setModel(modelo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		limpaCampos();

	}

	private void limpaCampos() {
	//	txtNome.setText("");
	//	txtCor.setText("");
	//	txtRaca.setText("");
	//	txtRga.setText("");
	
}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object acao = e.getSource();
		Object valorCliente;
		if (tableBusca.equals(acao)) {
			int linha = tableBusca.getSelectedRow();
			idCliente = listaCliente.get(linha).getId();
			valorCliente = tableBusca.getValueAt(linha, 0);
			txtCliente.setText(String.valueOf(valorCliente));
			
			buscaAnimaisDoCliente();
		}
	}

	private void buscaAnimaisDoCliente() {
		controlAnimal = new CtrlAnimal();
		listaAnimal = new ArrayList<Animal>();
		
		try {
			listaAnimal = controlAnimal.buscaCliente(idCliente);
			
			if (!listaAnimal.isEmpty()) {
				modelo = new ModeloTabela(listaAnimal);
				tableAnimal.getTableHeader().setReorderingAllowed(false);
				tableAnimal.setModel(modelo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FrmAnimal();
	}
}
