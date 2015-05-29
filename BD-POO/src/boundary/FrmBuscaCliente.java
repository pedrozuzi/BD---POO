package boundary;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.ConfigTelas;
import control.CtrlCliente;
import control.CtrlTabela;

public class FrmBuscaCliente extends MouseAdapter implements WindowListener {
	
	private JTextField txtBuscaCliente;
	private JTable tableBuscaCliente;
	private JScrollPane scrollPaneBuscaCliente;
	private JButton btnLupaPesquisarBusca;
	private JPanel panPrincipalBusca;
	private JFrame janelaBusca;
	private CtrlCliente controlCliente;
	private DefaultTableModel modelo;
	
	public FrmBuscaCliente() {
		janelaBusca = new JFrame();
		janelaBusca.addWindowListener(this);
		janelaBusca.setTitle("Buscar um Cliente");
		panPrincipalBusca = new JPanel();
		panPrincipalBusca.setBackground(SystemColor.text);
		panPrincipalBusca.setForeground(Color.WHITE);
		panPrincipalBusca.setLayout(null);
		
		janelaBusca.setSize(445,272);
		janelaBusca.setContentPane( panPrincipalBusca );
		
		btnLupaPesquisarBusca = new JButton("");
		btnLupaPesquisarBusca.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/MiniLupa.png")));
		btnLupaPesquisarBusca.setBounds(314, 28, 65, 31);
		panPrincipalBusca.add(btnLupaPesquisarBusca);
		
		txtBuscaCliente = new JTextField();
		txtBuscaCliente.setBounds(69, 39, 235, 20);
		panPrincipalBusca.add(txtBuscaCliente);
		txtBuscaCliente.setColumns(10);
		
		scrollPaneBuscaCliente = new JScrollPane();
		scrollPaneBuscaCliente.setBounds(10, 77, 419, 139);
		panPrincipalBusca.add(scrollPaneBuscaCliente);
		
		tableBuscaCliente = new JTable();
		scrollPaneBuscaCliente.setViewportView(tableBuscaCliente);
		ConfigTelas.telaBuscaCliente(janelaBusca);
		
		modelo = montarTabela();
		
		btnLupaPesquisarBusca.addActionListener(l -> {
			
		});

	}
	
	public DefaultTableModel montarTabela () {
		String[] colunas = new String[2];
		colunas[0] = "Nome";
		colunas[1] = "CPF";

		modelo = new CtrlTabela(new Object[][] {}, colunas);

		tableBuscaCliente.setModel(modelo);
		tableBuscaCliente.addMouseListener(this);
		tableBuscaCliente.getTableHeader().setReorderingAllowed(false); //deixar as colunas para nao serem movidas de seu lugar original
		tableBuscaCliente.getColumnModel().getColumn(0).setResizable(false);
		tableBuscaCliente.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableBuscaCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPaneBuscaCliente.setViewportView(tableBuscaCliente);
		return modelo;
}
	
	public static void main(String[] args) {
		new FrmBuscaCliente();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	
}
