package veicular.logica.persistencia.sql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import veicular.logica.dominio.Aeronave;
import veicular.logica.dominio.Embarcacoes;
import veicular.logica.dominio.Veiculo;


public class VeiculoDaoSql extends DBDAO implements VeiculoDaoIF{
	
	private static final int TIPO_AERONAVE = 0;
	private static final int TIPO_EMBARCACOES = 1;	
	
	private static final String INSERT_VEICULO = "INSERT INTO VEICULO (DESCRICAO, PLACA, ANOFABRICACAO, CLASSE) VALUES (?, ?, ?, ?)";
	private static final String FINDBYNOME = "select DESCRICAO, CLASSE, PLACA, ANOFABRICACAO from veiculo where descricao = ?";
	private static final String FINDALL = "select DESCRICAO, CLASSE, PLACA, ANOFABRICACAO from veiculo";
	private static final String DELETE = "delete from veiculo where descricao = ?";
	
	@Override
	public void salvar(Veiculo veiculo) throws Exception {
		
		Veiculo v = this.findByPlaca(veiculo.getPlaca());
		
		if(veiculo == null)
			this.create(v);
		else
			this.update(v);
		
	}

	private void update(Veiculo veiculo) throws SQLException {
		
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(INSERT_VEICULO);
		pstam.setString(1, veiculo.getDescricao());
		pstam.setString(2, veiculo.getPlaca());
		pstam.setInt(3, veiculo.getAnoFabricacao());
		
		pstam.executeUpdate();
		pstam.close();
		conn.close();
	}
	

	private void create(Veiculo veiculo) throws SQLException {
		
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(INSERT_VEICULO);
		pstam.setString(1, veiculo.getDescricao());
		pstam.setString(2, veiculo.getPlaca());
		pstam.setInt(3, veiculo.getAnoFabricacao());
		System.out.println(veiculo.getClass());
		if(veiculo.getClass().equals(Aeronave.class))
			pstam.setInt(4, VeiculoDaoSql.TIPO_AERONAVE);
		else if(veiculo.getClass().equals(Embarcacoes.class))
			pstam.setInt(4, VeiculoDaoSql.TIPO_EMBARCACOES);
		
		//Colocar as outras condições
		
		pstam.executeUpdate();
		pstam.close();
		conn.close();
	}

	@Override
	public Veiculo findByPlaca(String descricao) throws ClassNotFoundException, SQLException {
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(FINDBYNOME);
		pstam.setString(1, descricao);
		ResultSet rs = pstam.executeQuery();
		Veiculo veiculo = null;
		if(rs.next()){
			
			if(rs.getInt("CLASSE") == 0)			
				veiculo = new Aeronave(rs.getString("DESCRICAO"), rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"));
			
			if(rs.getInt("CLASSE") == 1	)		
				veiculo = new Embarcacoes(rs.getString("DESCRICAO"), rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"));
			//colocar as demais condições
		}
		rs.close();
		pstam.close();
		conn.close();
		
		return veiculo;
	}

	@Override
	public Collection<Veiculo> findAll() throws ClassNotFoundException, SQLException {
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(FINDALL);
		ResultSet rs = pstam.executeQuery();
		List<Veiculo> listVeiculo = new ArrayList<>();	
		Veiculo veiculo = null;
		while(rs.next()){
			
			if(rs.getInt("CLASSE") == 0)			
				veiculo = new Aeronave(rs.getString("DESCRICAO"),  rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"));
			
			if(rs.getInt("CLASSE") == 1	)		
				veiculo = new Embarcacoes(rs.getString("DESCRICAO"), rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"));
			
			//colocar as demais condições
			
			//Veiculo veiculo = new Veiculo(rs.getString("DESCRICAO"), rs.getInt("CLASSE"), rs.getString("PLACA"), rs.getInt("ANOFABRICACAO"));
			//System.out.println(veiculo.getPlaca());
			
			listVeiculo.add(veiculo);
		}
		rs.close();
		pstam.close();
		conn.close();
		
		return listVeiculo;
	}

	@Override
	public void remove(String descricao) throws Exception {
		Connection conn = this.getConnection();
		PreparedStatement pstam = conn.prepareStatement(DELETE);
		pstam.setString(1, descricao);
		pstam.executeUpdate();
		pstam.close();
		conn.close();
		
	}

	/*public static void main(String[] args) {
		VeiculoDaoSql daoSql = new VeiculoDaoSql();
		Veiculo veiculo = new Veiculo("FIAT", 1, "MGE-3654", 2006);
		try {
			daoSql.create(veiculo);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC não encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("uri, user ou senha incorretos");
			e.printStackTrace();
		};
		
	}*/
	
}
