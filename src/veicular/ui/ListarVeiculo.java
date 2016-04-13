package veicular.ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import veicular.logica.app.VeiculoAppIF;
import veicular.logica.dominio.Veiculo;


public class ListarVeiculo extends JFrame implements VeiculoUIIF{
	
	private JPanel painelFundo, painelTopo; 
	private JPanel painelBotoes; 
	private JButton btInserir; 
	private JButton btExcluir; 
	private Label label;
	private JTable tabela;
	private List<Veiculo> lista;
	private VeiculoTableModel modelo;
	private JScrollPane barraRolagem;
	
	private VeiculoAppIF app;
	
	public ListarVeiculo(){
		super("Veículos");
		montarTela();
		
		
	}
	
	private void buscar() throws Exception {
		this.lista = new ArrayList<Veiculo>(app.findAll()); 
		this.modelo = new VeiculoTableModel(lista); 
		this.tabela.setModel(modelo); 
		
	}
	
	public void montarTela(){
		
		/*this.btInserir = new JButton("Inserir"); 
		this.btExcluir = new JButton("Excluir"); 
		this.painelBotoes = new JPanel(); 
		this.painelTopo = new JPanel(); 
		this.barraRolagem = new JScrollPane(tabela); 
		this.painelFundo = new JPanel(); 
		this.painelFundo.setLayout(new BorderLayout()); 
		this.painelFundo.add(BorderLayout.CENTER, barraRolagem);
        this.label = new Label("");        
		this.painelTopo.setBackground(Color.white);
		this.painelTopo.add(label);
		this.painelBotoes.add(btInserir); 
		this.painelBotoes.add(btExcluir); 		
		this.painelFundo.add(BorderLayout.SOUTH, painelBotoes); 
		this.painelFundo.add(BorderLayout.NORTH, painelTopo);
		this.getContentPane().add(painelFundo); 		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setSize(900, 400); 
		setLocationRelativeTo(null);
		this.setVisible(true); */
		//this.btInserir.addActionListener(new BtInserirListener()); 
		//this.btExcluir.addActionListener(new BtExcluirListener()); 
		
		this.btInserir = new JButton("Inserir"); 
		this.btExcluir = new JButton("Excluir"); 
		this.painelBotoes = new JPanel(); 
		this.barraRolagem = new JScrollPane(tabela); 
		this.painelFundo = new JPanel(); 
		this.painelFundo.setLayout(new BorderLayout()); 
		this.painelFundo.add(BorderLayout.CENTER, barraRolagem); 
		this.painelBotoes.add(btInserir); 
		this.painelBotoes.add(btExcluir); 
		this.painelFundo.add(BorderLayout.SOUTH, painelBotoes); 
		this.getContentPane().add(painelFundo); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setSize(1200, 400); 
		this.setVisible(true); 
		//this.btInserir.addActionListener(new BtInserirListener()); 
		//this.btExcluir.addActionListener(new BtExcluirListener()); 
	}
	
	public void montarTabela() throws Exception {
		this.tabela = new JTable(modelo);
		this.buscar();		
		
		this.tabela.getColumnModel().getColumn(0).setPreferredWidth(100); 
		this.tabela.getColumnModel().getColumn(1).setPreferredWidth(50); 
		this.tabela.getColumnModel().getColumn(2).setPreferredWidth(10); 
		this.tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
	
	}

	

	@Override
	public void setLogic(VeiculoAppIF app) {
		this.app = app;
		
	}

	@Override
	public void setDisplay() throws Exception {
		this.montarTela();
		this.montarTabela();
		this.setVisible(true);
		
	}


}
