package veicular.ui;

import javax.swing.JPanel;

import veicular.logica.dominio.VeiculoAppIF;

public class CadastrarVeiculo extends JPanel {

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public CadastrarVeiculo(VeiculoAppIF app) throws Exception {
		app.addVeiculo("SIENA", "MGE-3654", 2006, 1);
		
	}

}
