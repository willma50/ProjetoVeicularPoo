package veicular.ui;

import veicular.logica.dominio.VeiculoAppIF;


public interface VeiculoUIIF {
	
	public void setLogic(VeiculoAppIF app);
	public void setDisplay() throws Exception;

}
