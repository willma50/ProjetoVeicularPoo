package veicular.logica.app;


import java.util.Collection;

import veicular.logica.dominio.Aeronave;
import veicular.logica.dominio.Embarcacoes;
import veicular.logica.dominio.Veiculo;
import veicular.logica.persistencia.sql.VeiculoDaoIF;
import veicular.logica.persistencia.sql.VeiculoDaoSql;


public class VeiculoGestor implements VeiculoAppIF{
	
	private VeiculoDaoIF VeiculoDao;

	@Override
	public void addVeiculo(String descricao, String placa,
			int anoFabricacao, int classe) throws Exception {
		
		if(classe == 0)
			this.addAeronave(descricao, placa, anoFabricacao);
		if(classe == 1)
			this.addEmbarcacoes(descricao, placa, anoFabricacao);
		
		//colocar as demais condições
		
		//Veiculo veiculo = new Veiculo(descricao, classe, placa, anoFabricacao);
		//System.out.println("vendo "+veiculo.getDescricao());
		//System.out.println("\n"+veiculo);
		/////this.VeiculoDao = new VeiculoDaoMem();
		//this.VeiculoDao = new VeiculoDaoSql();
		//this.VeiculoDao.create(veiculo);
		
	}
	
	public void addAeronave(String descricao, String placa,
			int anoFabricacao) throws Exception{
		this.VeiculoDao = new VeiculoDaoSql();
		Aeronave aeronave = new Aeronave(descricao, placa, anoFabricacao);
		this.VeiculoDao.salvar(aeronave);
		
	}
	
	public void addEmbarcacoes(String descricao, String placa,
			int anoFabricacao) throws Exception{
		this.VeiculoDao = new VeiculoDaoSql();
		Embarcacoes embarcacoes = new Embarcacoes(descricao, placa, anoFabricacao);
		this.VeiculoDao.salvar(embarcacoes);
	}

	//colocar os demais métodos da condição
	@Override
	public Collection<Veiculo> findAll() throws Exception {
		this.VeiculoDao = new VeiculoDaoSql();
		return this.VeiculoDao.findAll();
	}

	@Override
	public void setPersistencia(VeiculoDaoIF veiculoDAO) {
		this.VeiculoDao = veiculoDAO;
		
	}

}
