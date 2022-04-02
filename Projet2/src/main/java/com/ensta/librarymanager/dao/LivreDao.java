package com.ensta.librarymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.modele.Livre;
import com.ensta.librarymanager.persistence.ConnectionManager;
public class LivreDao implements ILivreDao {

	static LivreDao instance;
	
	public LivreDao() {}
	
	public static LivreDao getInstance() {
		if (instance== null) {
			instance = new LivreDao();
		}
		return instance;
		
	}
	@Override
	public List<Livre> getList() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT id, titre, auteur, isbn FROM livre;");
			ResultSet rs = prepStat.executeQuery();
			List<Livre> L = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur");
				String isbn = rs.getString("isbn");
				Livre livre = new Livre(id, titre, auteur, isbn);
				L.add(livre);
			}
			return L;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
		
	}

	@Override
	public Livre getById(int id) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT titre, auteur, isbn FROM Livre WHERE id= ?");
			prepStat.setInt(1, id);
			ResultSet rs = prepStat.executeQuery();
			
			rs.next();
			String titre = rs.getString("titre");
			String auteur = rs.getString("auteur");
			String isbn = rs.getString("isbn");
			Livre livre = new Livre(id, titre, auteur, isbn);
			
			return livre;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
		
	}

	@Override
	public int create(String titre, String auteur, String isbn) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("INSERT INTO livre(titre, auteur, isbn) VALUES (?, ?, ?);");
			prepStat.setString(1, titre);
			prepStat.setString(2, auteur);
			prepStat.setString(3, isbn);
			return prepStat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		} 
	}

	@Override
	public void update(Livre livre) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("UPDATE livre SET titre = ?, auteur = ?, isbn = ? WHERE id = ?;");
			prepStat.setString(1, livre.getTitre());
			prepStat.setString(2, livre.getAuteur());
			prepStat.setString(3, livre.getIsbn());
			prepStat.setInt(4,livre.getId());
			prepStat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		} 
		
	}

	@Override
	public void delete(int id) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("DELETE FROM livre WHERE id = ?;");
			prepStat.setInt(1,id);
			prepStat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
		
	}

	@Override
	public int count() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT COUNT(id) AS count FROM livre;");
			ResultSet rs = prepStat.executeQuery();
			rs.next();
			return rs.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
}
