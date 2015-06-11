package boundary;

import java.awt.Color;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.ConfigTelas;
import control.CtrlAgenda;
import control.CtrlAnimal;
import control.CtrlCliente;
import control.ModeloTabela;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import entity.Agenda;
import entity.Animal;
import entity.Cliente;
import entity.ClienteAgenda;

public class FrmAgenda extends MouseAdapter{
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTable tableAgenda;
	private JTable tableServicoMarcado;
	private JTextField txtData;
	private JTextField txtCliente;
	private JButton btnLupaPesquisar;
	private JComboBox<String> comboBoxAnimal;
	private JComboBox<String> comboBoxServico;
	private JPanel panel;
	private JButton btnPesquisar;
	private JDialog jd;
	private JPanel panPrincipalBusca;
	private JTable tableBusca = new JTable();
	private JScrollPane scrollPaneBusca;
	private JButton btnLupaPesquisarBusca;
	private JTextField txtBuscaCliente;
	private CtrlCliente controlCliente;
	private List<Cliente> listaCliente;
	private ModeloTabela modeloAgenda;
	private ModeloTabela modeloServicoMarcado;
	private int idCliente;
	private JScrollPane scrollPaneAgenda;
	private JScrollPane scrollPaneCliente;
	private CtrlAnimal controlAnimal;
	private List<Animal> listaAnimal;
	private JButton btnSalvar;
	private CtrlAgenda controlAgenda;
	private List<Agenda> listaAgenda;
	private List<ClienteAgenda> listaServicoMarcado;
	
	public FrmAgenda() {
		janela = new JFrame("Agenda");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(384, 115, 397, 166);
		panPrincipal.add(scrollPaneCliente);
		
		tableServicoMarcado = new JTable();
		scrollPaneCliente.setViewportView(tableServicoMarcado);
		
		txtData = new JTextField();
		txtData.setBounds(10, 11, 86, 20);
		panPrincipal.add(txtData);
		txtData.setColumns(10);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnPesquisar.setBounds(106, 10, 89, 23);
		panPrincipal.add(btnPesquisar);
		
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Arial", Font.BOLD, 16));
		lblAgenda.setBounds(150, 54, 78, 20);
		panPrincipal.add(lblAgenda);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(389, 308, 392, 61);
		panPrincipal.add(panel);
		panel.setLayout(null);
		
		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCliente.setEnabled(false);
		txtCliente.setBounds(35, 30, 252, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		btnLupaPesquisar = new JButton("");
		btnLupaPesquisar.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisar.setBounds(297, 29, 89, 23);
		panel.add(btnLupaPesquisar);
		
		comboBoxAnimal = new JComboBox<String>();
		comboBoxAnimal.setBounds(581, 430, 179, 20);
		panPrincipal.add(comboBoxAnimal);
		
		comboBoxServico = new JComboBox<String>();
		comboBoxServico.addItem("Banho");
		comboBoxServico.addItem("Tosa");
		comboBoxServico.addItem("Banho e Tosa");
		comboBoxServico.setBounds(384, 430, 125, 20);
		panPrincipal.add(comboBoxServico);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(641, 405, 46, 14);
		panPrincipal.add(lblAnimal);
		
		JLabel lblServico = new JLabel("Tipo de Servi\u00E7o");
		lblServico.setBounds(389, 405, 98, 14);
		panPrincipal.add(lblServico);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(692, 501, 89, 23);
		panPrincipal.add(btnSalvar);
		
		JLabel lblCliente = new JLabel("Servi\u00E7o Marcado");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 16));
		lblCliente.setBounds(519, 81, 136, 23);
		panPrincipal.add(lblCliente);
		
		tableAgenda = new JTable();
		tableAgenda.addMouseListener(this);
		tableAgenda.setBorder(new LineBorder(Color.BLACK));
		tableAgenda.setGridColor(Color.BLACK);
		tableAgenda.setShowGrid(true);
		
		scrollPaneAgenda = new JScrollPane();
		scrollPaneAgenda.getViewport().setBorder(null);
		scrollPaneAgenda.setViewportView(tableAgenda);
		scrollPaneAgenda.setBounds(10, 80, 351, 332);
		scrollPaneAgenda.setVisible(true);
		panPrincipal.add(scrollPaneAgenda);
		
		montarAgenda();
		tabelaServicoMarcado();
		
		janela.setSize(807,573);
		janela.setContentPane( panPrincipal);
		ConfigTelas.centralizarFrame(janela);
		
		btnLupaPesquisar.addActionListener(e -> {
			cliente(jd);
		});
		
		btnSalvar.addActionListener(e -> {
			tabelaServicoMarcado();
		});
		
	}
	
	private void tabelaServicoMarcado() {
		listaServicoMarcado = new ArrayList<ClienteAgenda>();
		controlAgenda = new CtrlAgenda();
		listaServicoMarcado = controlAgenda.buscarServicoMarcado();
		modeloServicoMarcado = new ModeloTabela(listaServicoMarcado);
		tableServicoMarcado.getTableHeader().setReorderingAllowed(false);
		tableServicoMarcado.setModel(modeloServicoMarcado);
	}

	private void montarAgenda() {
		listaAgenda = new ArrayList<Agenda>();
		controlAgenda = new CtrlAgenda();
		listaAgenda = controlAgenda.buscarAgenda();
		modeloAgenda = new ModeloTabela(listaAgenda);
		tableAgenda.getTableHeader().setReorderingAllowed(false);
		tableAgenda.setModel(modeloAgenda);
	}	
		
		
	private void cliente(JDialog jd) {
		jd = new JDialog(jd, "Buscar Cliente", true);
		
		try {
			BufferedImage image = ImageIO.read(  
			        this.getClass().getResource("/img/icon.png"));
			jd.setIconImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
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
					modeloAgenda = new ModeloTabela(listaCliente);
					tableBusca.getTableHeader().setReorderingAllowed(false);
					tableBusca.setModel(modeloAgenda);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		limpaCampos();
		
	}
	
	private void limpaCampos() {
		// TODO 
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
				listaAnimal.forEach(a -> {
					comboBoxAnimal.addItem(a.getNome());
				});
			}else{
				System.out.println("LISTA VAZIA");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new FrmAgenda();
	}
}
