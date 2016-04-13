package veicular.logica.dominio;


import java.util.Collection;

import veicular.logica.persistencia.sql.VeiculoDaoIF;


public interface VeiculoAppIF {

	public void addVeiculo(String descricao, String placa, int anoFabricacao, int classe) throws Exception;
	public Collection<Veiculo> findAll() throws Exception;
	public void setPersistencia(VeiculoDaoIF veiculoDAO);
	
}
