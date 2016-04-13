package veicular.logica.app;


import java.io.FileReader;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Properties;




import veicular.logica.dominio.VeiculoAppIF;
import veicular.logica.dominio.VeiculoGestor;
import veicular.logica.persistencia.sql.VeiculoDaoIF;
import veicular.ui.VeiculoUIIF;


public class appTeste {
	
	private VeiculoAppIF gestor;
	private Principal app;

	public appTeste(){
		this.gestor = new VeiculoGestor();					
	}
	
	public void cenario1() throws Exception{
		//this.gestor.addVeiculo("SIENA", 2, "MGE-3654", 2006);
		
	}
	
	public void cenario2() throws Exception{
		
		//this.app = new Principal();
	}
	
	   public void run(String fileName) throws Exception{
	    	Properties prop = new Properties();
	    	prop.load(new FileReader(fileName));
	    	VeiculoDaoIF veiculoDAO = (VeiculoDaoIF)(Class.forName(prop.getProperty("PERSISTENCIA")).newInstance());
	    	VeiculoAppIF app = (VeiculoAppIF)(Class.forName(prop.getProperty("LOGICA")).newInstance());
	   		app.setPersistencia(veiculoDAO);
	    	VeiculoUIIF ui = (VeiculoUIIF)(Class.forName(prop.getProperty("UI")).newInstance());
	    	ui.setLogic(app);	    	
	   		ui.setDisplay(); 
	    }
	   
	public static void main(String[] args) throws Exception{
		
		/*Veiculo veiculo = new Veiculo("FIAT", 1, "MGE-3654", 2006);
		VeiculoDaoSql v = new VeiculoDaoSql();
		try {
			v.create(veiculo);
		} catch (ClassNotFoundException e) {
			System.out.println("teste1");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("teste2");
			e.printStackTrace();
		}*/		
		
		//appTeste app = new appTeste();
		//app.cenario1();
		//app.cenario2();
		appTeste app = new appTeste();
    	app.run("config.app");
		//teste
	}
}
