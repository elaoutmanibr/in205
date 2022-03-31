package com.ensta.librarymanager.modele;
import java.time.LocalDate;
import java.util.Objects;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.service.LivreService;
import com.ensta.librarymanager.service.MembreService;

public class Emprunt {
	private int id;
	private int idMember;
	private int idLivre;
	private LocalDate dateEmprunt;
	private LocalDate dateRetour;
	
	public int getId() {
		return id;
	}

	public int getIdMember() {
		return idMember;
	}
	
	public Membre getMember() {
		MembreService m = MembreService.getInstance();
		try {
			return m.getById(idMember);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getIdLivre() {
		return idLivre;
	}
	
	public Livre getLivre() {
		LivreService l = LivreService.getInstance();
		try {
			return l.getById(idLivre);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}



	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Emprunt(int id, int idMember, int idLivre, LocalDate dateEmprunt, LocalDate dateRetour) {
		this.id = id;
		this.idMember = idMember;
		this.idLivre = idLivre;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateEmprunt, dateRetour, id, idLivre, idMember);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprunt other = (Emprunt) obj;
		return Objects.equals(dateEmprunt, other.dateEmprunt) && Objects.equals(dateRetour, other.dateRetour)
				&& id == other.id && idLivre == other.idLivre && idMember == other.idMember;
	}
	
	
}
