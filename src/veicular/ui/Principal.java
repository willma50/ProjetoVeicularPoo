package veicular.ui;


import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import veicular.logica.dominio.VeiculoAppIF;



public class Principal extends JFrame implements VeiculoUIIF, ActionListener{
	
	public Panel painel = new Panel();
	JMenuBar barra; 
	JMenu veiculo, sair;
	JMenuItem cadastrar, consultar;
	
	private VeiculoAppIF app;
	
	public Principal(){		
		super("Tela inicial");
				
		
	}
	
	public void montarTela() {
		
		Container tela = getContentPane();
		//painel.setBackground(new Color(0,0,0)); //configurando cor de fundo para o painel
        painel.setBounds(new Rectangle(0,28,800,520));//configurando forma no caso Retângulo com posição x,y e medidas w, h
        tela.add(painel);  
         
		tela.setLayout(null);
		
		barra = new JMenuBar();
		
		setJMenuBar(barra);
		veiculo = new JMenu("Veículo");	
		sair = new JMenu("Sair");
		cadastrar = new JMenuItem("Cadastrar");
		consultar = new JMenuItem("Consultar");
		
		barra.add(veiculo);
		barra.add(sair);
		veiculo.add(cadastrar);
		veiculo.add(consultar);
		
		consultar.addActionListener(this);
		cadastrar.addActionListener(this);
		
		//rever
		/*consultar.addActionListener(new ActionListener(){

	          public void actionPerformed(ActionEvent e){

	        	  
	        	  try {
					listarVeiculo2.setDisplay();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
	        	  listarVeiculo2.setVisible(true);
	        	  

	          }
	    });*/
		
	}

	@Override
	public void setLogic(VeiculoAppIF app) {
		this.app = app;
		
	}

	@Override
	public void setDisplay() throws Exception {
		this.montarTela();
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == consultar){
			System.out.println("entrou menu ");
			//new CadastroUnidade(this.appU, null);
			ListarVeiculo listarVeiculo2 = new ListarVeiculo();
      	    listarVeiculo2.setLogic(app);
      	   // listarVeiculo2.setDisplay();
		}else
			if(e.getSource() == cadastrar){
				try {
					CadastrarVeiculo cadastro = new CadastrarVeiculo(app);
				} catch (Exception e1) {
					System.out.println("Erro cadastro!");
					e1.printStackTrace();
				}
				
			}
		
	}
	

	/*public static void main (String args[]){
		Principal app = new Principal();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} */
}
