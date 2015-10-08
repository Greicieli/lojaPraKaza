package br.sc.senai.web.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.sc.senai.web.Dominio.Mercadorias;

public class MercadoriasDao extends Dao {
	
	private final String INSERT = "INSERT INTO mercadoria(nome, categoria, quantidade, descricao, valor) values (?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE mercadoria SET nome = ?, categoria = ?,quantidade = ?, descricao = ?, valor = ? WHERE idMercadoria =?";
	private final String DELETE = "DELETE FROM mercadoria WHERE idMercadoria = ?";
	private final String SELECT ="SELECT * FROM mercadoria";
	private final String SELECT_ID = "SELECT * DROM mercadoria WHERE idMercadoria = ?";
	
	
	public void salvar(Mercadorias mercadoria) throws Exception{
		if(mercadoria.getIdMercadoria() == 0){
			inserir(mercadoria);
		}else{
			alterar(mercadoria);
		}
		
	}

	
	public void inserir(Mercadorias mercadoria) throws Exception{
		try{
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, mercadoria.getNome());
			ps.setString(2, mercadoria.getCategoria());
			ps.setInt(3, mercadoria.getQuantidade());
			ps.setString(4, mercadoria.getDescricao());
			ps.setDouble(5, mercadoria.getValor());
			
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Erro ao tentar salvar a Mercadoria");
		}
	}


	public void alterar(Mercadorias mercadoria) throws Exception{
		try{
			PreparedStatement ps =getConnection().prepareStatement(UPDATE);
			ps.setString(1, mercadoria.getNome());
			ps.setString(2, mercadoria.getCategoria());
			ps.setInt(3, mercadoria.getQuantidade());
			ps.setString(4, mercadoria.getDescricao());
			ps.setDouble(5, mercadoria.getValor());
			ps.setLong(6, mercadoria.getIdMercadoria());
			
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Erro ao executar o update"+ e);
		}
		
	}
	
	
	public void excluir(Long idMercadoria) throws Exception{
		try{
			PreparedStatement ps =getConnection().prepareStatement(DELETE);
			ps.setLong(1, idMercadoria);
			ps.executeUpdate();
		} catch (SQLException e ){
			e.printStackTrace();
			System.out.println("Erro ao executar o delete: " + e);
			throw new Exception("Erro ao tentar excluir");
		}
	}
	

	
	public List <Mercadorias> listarTodos(){
		List<Mercadorias> mercadorias = new ArrayList<Mercadorias>();
		try{
			PreparedStatement ps =getConnection().prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Mercadorias mercadoria = new Mercadorias();
				mercadoria.setNome(rs.getString("nome"));
				mercadoria.setCategoria(rs.getString("categoria"));
				mercadoria.setQuantidade(rs.getInt("quantidade"));
				mercadoria.setDescricao(rs.getString("descricao"));
				mercadoria.setValor(rs.getDouble("valor"));
				mercadoria.setIdMercadoria(rs.getLong("idMercadoria"));
				mercadorias.add(mercadoria);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erro ao mostrar o produto: "+ e);
				
			}
			return mercadorias;
		
		}
	public Mercadorias buscarPorId(Long idMercadoria) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ps.setLong(1, idMercadoria);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mercadorias mercadoria = new Mercadorias();
				mercadoria.setNome(rs.getString("nome"));
				mercadoria.setCategoria(rs.getString("categoria"));
				mercadoria.setQuantidade(rs.getInt("quantidade"));
				mercadoria.setDescricao(rs.getString("descricao"));
				mercadoria.setValor(rs.getDouble("valor"));
				mercadoria.setIdMercadoria(rs.getLong("idMercadoria"));
				return mercadoria;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select da mercadoria: " + e);
		}
		return null;
	}
	}
