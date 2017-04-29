package br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.bean.Brinquedo;
import br.util.ConnectionFactory;

public class BrinquedoDAO {

	public boolean createBrinquedo(Brinquedo br){
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String  sql = "INSERT INTO brinquedos VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, br.getCod());
			stmt.setString(2, br.getDescricao());
			stmt.setString(3, br.getCategoria());
			stmt.setString(4, br.getMarca());
			stmt.setString(5,  br.getImagem());
			stmt.setDouble(6, br.getPreco());
			stmt.setString(7, br.getDetalhes());
			
			stmt.execute();
			
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	public Brinquedo  retrieveBrinquedo(int  cod) {
		Brinquedo br = null;
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM brinquedos WHERE cod=" + cod;
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
		
			
			if (rs.next()) {
				br = new Brinquedo();
				br.setCod(cod);
				br.setDescricao(rs.getString("descricao"));
				br.setCategoria(rs.getString("categoria"));
				br.setMarca(rs.getString("marca"));
				br.setImagem(rs.getString("imagem"));
				br.setPreco(rs.getDouble(6));
				br.setDetalhes(rs.getString("detalhes"));
			}
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		return br;

	}
	
	
	
	public boolean updateBrinquedo(Brinquedo br) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "UPDATE brinquedos SET descricao=?, categoria=?, marca = ?, imagem=?, preco=?, detalhes = ? WHERE cod = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, br.getDescricao());
			stmt.setString(2, br.getCategoria());
			stmt.setString(3, br.getMarca());
			stmt.setString(4,  br.getImagem());
			stmt.setDouble(5, br.getPreco());
			stmt.setString(6, br.getDetalhes());
			stmt.setInt(7, br.getCod());
			
			stmt.execute();
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
				
		return true;
	}
	
	public boolean deleteBrinquedo(int  cod) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "DELETE FROM brinquedos WHERE cod=" + cod;
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Brinquedo> retrieveListaBrinquedo() {
		List<Brinquedo> brinquedos = null;
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM `brinquedos` ORDER BY `brinquedos`.`categoria` ASC";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			brinquedos = new ArrayList<Brinquedo>();
			
			while (rs.next()) {
				Brinquedo br = new Brinquedo();
				br.setCod(rs.getInt(1));
				br.setDescricao(rs.getString("descricao"));
				br.setCategoria(rs.getString("categoria"));
				br.setMarca(rs.getString("marca"));
				br.setImagem(rs.getString("imagem"));
				br.setPreco(rs.getDouble(6));
				br.setDetalhes(rs.getString("detalhes"));
				
				brinquedos.add(br);
			}
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		return brinquedos;
	}
	
	public List<Brinquedo> retrieveListaBrinquedoHome() {
		List<Brinquedo> brinquedos = null;
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM `brinquedos` ORDER BY `brinquedos`.`preco` DESC LIMIT 0,6";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			brinquedos = new ArrayList<Brinquedo>();
			
			while (rs.next()) {
				Brinquedo br = new Brinquedo();
				br.setCod(rs.getInt(1));
				br.setDescricao(rs.getString("descricao"));
				br.setCategoria(rs.getString("categoria"));
				br.setMarca(rs.getString("marca"));
				br.setImagem(rs.getString("imagem"));
				br.setPreco(rs.getDouble(6));
				br.setDetalhes(rs.getString("detalhes"));
				
				brinquedos.add(br);
			}
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		return brinquedos;
	}
	
	
	public List<Brinquedo> retrieveListaBrinquedoCategoria(String categoria) {
		List<Brinquedo> brinquedos = null;
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM brinquedos WHERE categoria = "+"\"" + categoria + "\"";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			brinquedos = new ArrayList<Brinquedo>();
			
			while (rs.next()) {
				Brinquedo br = new Brinquedo();
				br.setCod(rs.getInt(1));
				br.setDescricao(rs.getString("descricao"));
				br.setCategoria(rs.getString("categoria"));
				br.setMarca(rs.getString("marca"));
				br.setImagem(rs.getString("imagem"));
				br.setPreco(rs.getDouble(6));
				br.setDetalhes(rs.getString("detalhes"));
				
				brinquedos.add(br);
			}
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		return brinquedos;
	}

	
	public List<Brinquedo> retrieveListaBrinquedoPesquisa(String descricao) {
		List<Brinquedo> brinquedos = null;
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM brinquedos WHERE descricao LIKE "+"\"" + "%" + descricao + "%" +  "\"";
			PreparedStatement stmt = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery();
			
			brinquedos = new ArrayList<Brinquedo>();
			
			while (rs.next()) {
				Brinquedo br = new Brinquedo();
				br.setCod(rs.getInt(1));
				br.setDescricao(rs.getString("descricao"));
				br.setCategoria(rs.getString("categoria"));
				br.setMarca(rs.getString("marca"));
				br.setImagem(rs.getString("imagem"));
				br.setPreco(rs.getDouble(6));
				br.setDetalhes(rs.getString("detalhes"));
				
				brinquedos.add(br);
			}
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		return brinquedos;
	}
	
	
}
