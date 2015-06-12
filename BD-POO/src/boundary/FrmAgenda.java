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
import control.CtrlServico;
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
import entity.Servico;

public class FrmAgenda extends MouseAdapter{
	
	private JFrame janela; 
	private JPanel panPrincipal;
	private JTable tableAgenda = new JTable();
	private JTextField txtCliente;
	private JButton btnLupaPesquisar;
	private JComboBox<Animal> comboBoxAnimal;
	private JComboBox<String> comboBoxServico;
	private JPanel panel;
	private JDialog jd;
	private JPanel panPrincipalBusca;
	private JTable tableBusca = new JTable();
	private JScrollPane scrollPaneBusca;
	private JButton btnLupaPesquisarBusca;
	private JTextField txtBuscaCliente;
	private CtrlCliente controlCliente;
	private List<Cliente> listaCliente;
	private ModeloTabela modeloAgenda;
	private int idCliente;
	private JScrollPane scrollPaneAgenda;
	private CtrlAnimal controlAnimal;
	private List<Animal> listaAnimal;
	private JButton btnSalvar;
	private CtrlAgenda controlAgenda;
	private List<Agenda> listaAgenda;
	private int idAnimal;
	private CtrlServico controlServico;
	private Agenda agenda;
	private Animal animal;
	
	public FrmAgenda() {
		janela = new JFrame("Agenda");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);
		
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Arial", Font.BOLD, 16));
		lblAgenda.setBounds(150, 11, 78, 20);
		panPrincipal.add(lblAgenda);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(384, 116, 374, 61);
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
		btnLupaPesquisar.setBounds(297, 27, 63, 25);
		panel.add(btnLupaPesquisar);
		
		comboBoxAnimal = new JComboBox<Animal>();
		comboBoxAnimal.setBounds(549, 236, 179, 20);
		panPrincipal.add(comboBoxAnimal);
		
		comboBoxServico = new JComboBox<String>();
		comboBoxServico.addItem("Banho");
		comboBoxServico.addItem("Tosa");
		comboBoxServico.addItem("Banho e Tosa");
		comboBoxServico.setBounds(384, 236, 125, 20);
		panPrincipal.add(comboBoxServico);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(609, 211, 46, 14);
		panPrincipal.add(lblAnimal);
		
		JLabel lblServico = new JLabel("Tipo de Servi\u00E7o");
		lblServico.setBounds(389, 211, 98, 14);
		panPrincipal.add(lblServico);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(687, 346, 89, 23);
		panPrincipal.add(btnSalvar);
		
		tableAgenda = new JTable();
		tableAgenda.addMouseListener(this);
		tableAgenda.setBorder(new LineBorder(Color.BLACK));
		tableAgenda.setGridColor(Color.BLACK);
		tableAgenda.setShowGrid(true);
		
		scrollPaneAgenda = new JScrollPane();
		scrollPaneAgenda.getViewport().setBorder(null);
		scrollPaneAgenda.setViewportView(tableAgenda);
		scrollPaneAgenda.setBounds(10, 37, 351, 332);
		scrollPaneAgenda.setVisible(true);
		panPrincipal.add(scrollPaneAgenda);
		
		montarAgenda();
		
		janela.setSize(807,430);
		janela.setContentPane( panPrincipal);
		ConfigTelas.centralizarFrame(janela);
		
		btnLupaPesquisar.addActionListener(e -> {
			cliente(jd);
		});
		
		btnSalvar.addActionListener(e -> {
			adicionaServicoAgenda();
		});
		
		comboBoxAnimal.addActionListener(a -> {
			acaoComboBox();
		});
		
	}
	
	private void acaoComboBox() {
		animal = new Animal();
		if (comboBoxAnimal.getItemCount() > 0) {
			animal = (Animal) comboBoxAnimal.getSelectedItem();
			idAnimal = animal.getId();
		}
	}

	private void atualizaAgenda() {
		//agenda.setAuxiliar(auxiliar);
		//agenda.setHorario(horario);
	}
	
	private void adicionaServicoAgenda() {
		agenda = new Agenda();
		Servico servico = new Servico();
		Animal animal = new Animal();
		Cliente cliente = new Cliente();
		controlServico = new CtrlServico();
		servico.setCodigo(controlServico.buscarNovaEntrada());
		animal.setId(idAnimal);
		animal.setNome(String.valueOf(comboBoxAnimal.getSelectedItem()));
		servico.setAnimal(animal);
		cliente.setId(idCliente);
		servico.setCliente(cliente);
		servico.setNome(String.valueOf(comboBoxServico.getSelectedItem()));
		agenda.setCliente(cliente);
		agenda.setServico(servico);
		
		controlServico.incluiServicoAgenda(servico);
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
			comboBoxAnimal.removeAllItems();
			int linha = tableBusca.getSelectedRow();
			idCliente = listaCliente.get(linha).getId();
			valorCliente = tableBusca.getValueAt(linha, 0);
			txtCliente.setText(String.valueOf(valorCliente));
			buscaAnimaisDoCliente(linha);
			
		}else if (tableAgenda.equals(acao)) {
			Object[] valores = new Object[2];
			int linha = tableAgenda.getSelectedRow();
			int coluna = tableAgenda.getSelectedColumn();
			int linhasTabela = tableAgenda.getRowCount();
			System.out.println(linhasTabela);
			
			for (coluna = 0; coluna < tableAgenda.getColumnCount(); coluna++) {
				valores[coluna] = tableAgenda.getValueAt(linha, coluna);
			}
			
			for (int i = 0; i < valores.length; i++) {
				System.out.println(valores[i]);
			}
			
		}
	}

	private void buscaAnimaisDoCliente(int linha) {
		controlAnimal = new CtrlAnimal();
		listaAnimal = new ArrayList<Animal>();
		
		try {
			listaAnimal = controlAnimal.buscaAnimal(idCliente);
			
			if (!listaAnimal.isEmpty()) {
				listaAnimal.forEach(a -> comboBoxAnimal.addItem(a) );
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new FrmAgenda();
	}
}
