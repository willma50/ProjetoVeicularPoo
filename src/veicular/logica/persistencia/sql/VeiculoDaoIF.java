package veicular.logica.persistencia.sql;


import java.sql.SQLException;
import java.util.Collection;

import veicular.logica.dominio.Veiculo;



public interface VeiculoDaoIF {

	public void salvar(Veiculo veiculo) throws Exception; //cria��o 
	public Veiculo findByPlaca(String descricao) throws Exception; // pesquisa pela descri��o
	public Collection<Veiculo> findAll() throws Exception; // busca todos dos registros
	public void remove(String descricao) throws Exception;
}