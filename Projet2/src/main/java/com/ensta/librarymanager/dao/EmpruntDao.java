package com.ensta.librarymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.modele.Abonnement;
import com.ensta.librarymanager.modele.Emprunt;
import com.ensta.librarymanager.modele.Livre;
import com.ensta.librarymanager.persistence.ConnectionManager;

public class EmpruntDao implements IEmpruntDao {

	@Override
	public List<Emprunt> getList() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT e.id AS id, idMembre, nom, prenom, adresse, email,"
					+ " telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,"
					+ " dateRetour"
					+ " FROM emprunt AS e"
					+ " INNER JOIN membre ON membre.id = e.idMembre"
					+ " INNER JOIN livre ON livre.id = e.idLivre"
					+ " ORDER BY dateRetour DESC;");
			ResultSet rs = prepStat.executeQuery();
			List<Emprunt> L = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int idMembre = rs.getInt("idMembre");
				int idLivre = rs.getInt("idLivre");;
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				LocalDate dateRetour = rs.getDate("dateRetour")== null ? null : rs.getDate("dateRetour").toLocalDate();
				Emprunt emprunt = new Emprunt(id, idMembre, idLivre,dateEmprunt,dateRetour);
				L.add(emprunt);
			}
			return L;
		
		} catch (Exception e) {
		e.printStackTrace();
		throw new DaoException();
		}
	}

	@Override
	public List<Emprunt> getListCurrent() throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT e.id AS id, idMembre, nom, prenom, adresse, email,"
					+ " telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,"
					+ " dateRetour"
					+ " FROM emprunt AS e"
					+ " INNER JOIN membre ON membre.id = e.idMembre"
					+ " INNER JOIN livre ON livre.id = e.idLivre"
					+ " WHERE dateRetour IS NULL;");
			ResultSet rs = prepStat.executeQuery();
			List<Emprunt> L = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int idMembre = rs.getInt("idMembre");
				int idLivre = rs.getInt("idLivre");
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				LocalDate dateRetour = rs.getDate("dateRetour")== null ? null : rs.getDate("dateRetour").toLocalDate();
				Emprunt emprunt = new Emprunt(id, idMembre, idLivre,dateEmprunt,dateRetour);
				L.add(emprunt);
			}
			return L;
		
		} catch (Exception e) {
		e.printStackTrace();
		throw new DaoException();
		}
	}

	@Override
	public List<Emprunt> getListCurrentByMembre(int idMembre) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT e.id AS id, idMembre, nom, prenom, adresse, email,"
					+ " telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,"
					+ " dateRetour"
					+ " FROM emprunt AS e"
					+ " INNER JOIN membre ON membre.id = e.idMembre"
					+ " INNER JOIN livre ON livre.id = e.idLivre"
					+ " WHERE dateRetour IS NULL AND membre.id = ?;");
			prepStat.setInt(1, idMembre);
			ResultSet rs = prepStat.executeQuery();
			List<Emprunt> L = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int idLivre = rs.getInt("idLivre");
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				LocalDate dateRetour = rs.getDate("dateRetour")== null ? null : rs.getDate("dateRetour").toLocalDate();
				Emprunt emprunt = new Emprunt(id, idMembre, idLivre,dateEmprunt,dateRetour);
				L.add(emprunt);
			}
			return L;
		
		} catch (Exception e) {
		e.printStackTrace();
		throw new DaoException();
		}
	}

	@Override
	public List<Emprunt> getListCurrentByLivre(int idLivre) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT e.id AS id, idMembre, nom, prenom, adresse, email,"
					+ " telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,"
					+ " dateRetour"
					+ " FROM emprunt AS e"
					+ " INNER JOIN membre ON membre.id = e.idMembre"
					+ " INNER JOIN livre ON livre.id = e.idLivre"
					+ " WHERE dateRetour IS NULL AND livre.id = ?;");
			prepStat.setInt(1, idLivre);
			ResultSet rs = prepStat.executeQuery();
			List<Emprunt> L = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int idMembre = rs.getInt("idMembre");
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				LocalDate dateRetour = rs.getDate("dateRetour")== null ? null : rs.getDate("dateRetour").toLocalDate();
				Emprunt emprunt = new Emprunt(id, idMembre, idLivre,dateEmprunt,dateRetour);
				L.add(emprunt);
			}
			return L;
		
		} catch (Exception e) {
		e.printStackTrace();
		throw new DaoException();
		}
	}

	@Override
	public Emprunt getById(int id) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("SELECT e.id AS idEmprunt, idMembre, nom, prenom, adresse, email,"
					+ " telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,"
					+ " dateRetour"
					+ " FROM emprunt AS e"
					+ " INNER JOIN membre ON membre.id = e.idMembre"
					+ " INNER JOIN livre ON livre.id = e.idLivre"
					+ " WHERE e.id = ?;");
			prepStat.setInt(1, id);
			ResultSet rs = prepStat.executeQuery();
			Emprunt emprunt = null;
			if(rs.next()) {
				int idLivre = rs.getInt("idLivre");
				int idMembre = rs.getInt("idMembre");
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				LocalDate dateRetour = rs.getDate("dateRetour")== null ? null : rs.getDate("dateRetour").toLocalDate();
				emprunt = new Emprunt(id, idMembre, idLivre,dateEmprunt,dateRetour);
			}
			return emprunt;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public void create(int idMembre, int idLivre, LocalDate dateEmprunt) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("INSERT INTO emprunt(idMembre, idLivre, dateEmprunt, dateRetour)"
					+ " VALUES (?, ?, ?, ?);");
			prepStat.setInt(1, idMembre);
			prepStat.setInt(2, idLivre);
			prepStat.setDate(3, java.sql.Date.valueOf(dateEmprunt));
			prepStat.setDate(4, null);
			
			prepStat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public void update(Emprunt emprunt) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement prepStat = conn.prepareStatement("UPDATE emprunt"
					+ " SET idMembre = ?, idLivre = ?, dateEmprunt = ?, dateRetour = ?"
					+ " WHERE id = ?;");
			prepStat.setInt(1, emprunt.getIdMember());
			prepStat.setInt(2, emprunt.getIdLivre());
			prepStat.setDate(3, java.sql.Date.valueOf(emprunt.getDateEmprunt()));
			prepStat.setDate(4, java.sql.Date.valueOf(emprunt.getDateRetour()));
			prepStat.setInt(5, emprunt.getId());
			
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
			PreparedStatement prepStat = conn.prepareStatement("SELECT COUNT(id) AS count FROM emprunt;");
			ResultSet rs = prepStat.executeQuery();
			rs.next();
			return rs.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

}
