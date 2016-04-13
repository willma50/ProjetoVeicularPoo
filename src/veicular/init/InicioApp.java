package veicular.init;


import java.io.FileReader;
import java.util.Properties;

import veicular.logica.app.VeiculoAppIF;
import veicular.logica.persistencia.sql.VeiculoDaoIF;
import veicular.ui.VeiculoUIIF;


public class InicioApp {

	
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
		(new InicioApp()).run("config.app");
		InicioApp app = new InicioApp();
  
	}
}
