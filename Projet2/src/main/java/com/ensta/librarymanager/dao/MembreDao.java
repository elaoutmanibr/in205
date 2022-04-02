package com.ensta.librarymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.modele.Abonnement;
import com.ensta.librarymanager.modele.Livre;
import com.ensta.librarymanager.modele.Membre;
import com.ensta.librarymanager.persistence.ConnectionManager;

public class MembreDao implements IMembreDao {

	@Override
	public List<Membre> getList() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT id, nom, prenom, adresse, email, telephone, abonnement"
					+ " FROM membre"
					+ " ORDER BY nom, prenom;");
			ResultSet rs = prepStat.executeQuery();
			List<Membre> L = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				Abonnement abonnement = Abonnement.fromString(rs.getString("abonnement"));
				Membre m = new Membre(id, nom, prenom, adresse, email,telephone,abonnement);
				L.add(m);
			}
			return L;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public Membre getById(int id) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT id, nom, prenom, adresse, email, telephone, abonnement"
					+ " FROM membre"
					+ " WHERE id = ?;");
			prepStat.setInt(1, id);
			ResultSet rs = prepStat.executeQuery();
			
			rs.next();
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String adresse = rs.getString("adresse");
			String email = rs.getString("email");
			String telephone = rs.getString("telephone");
			Abonnement abonnement = Abonnement.fromString(rs.getString("abonnement"));

			Membre membre = new Membre(id,nom,prenom,adresse,email,telephone,abonnement);
			
			return membre;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public int create(String nom, String prenom, String adresse, String email, String telephone) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("INSERT INTO membre(nom, prenom, adresse, email, telephone,"
					+ " abonnement)"
					+ " VALUES (?, ?, ?, ?, ?, ?);");
			prepStat.setString(1, nom);
			prepStat.setString(2, prenom);
			prepStat.setString(3, adresse);
			prepStat.setString(4, email);
			prepStat.setString(5, telephone);
			prepStat.setString(6, "BASIC");
			return prepStat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		} 
	}

	@Override
	public void update(Membre membre) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("UPDATE membre"
					+ " SET nom = ?, prenom = ?, adresse = ?, email = ?, telephone = ?,"
					+ " abonnement = ?"
					+ " WHERE id = ?;");
			prepStat.setString(1, membre.getNom());
			prepStat.setString(2, membre.getPrenom());
			prepStat.setString(3, membre.getAdresse());
			prepStat.setString(4,membre.getEmail());
			prepStat.setString(5,membre.getTelephone());
			prepStat.setString(6,Abonnement.toString(membre.getAbonnement()));
			prepStat.setInt(7, membre.getId());
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
			PreparedStatement prepStat = conn.prepareStatement("DELETE FROM membre WHERE id = ?;");
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
			PreparedStatement prepStat = conn.prepareStatement("SELECT COUNT(id) AS count FROM membre;");
			ResultSet rs = prepStat.executeQuery();
			rs.next();
			return rs.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

}
