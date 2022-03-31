package com.ensta.librarymanager.modele;

import java.util.Objects;

public class Livre {
	private int id;
	private String titre;
	private String auteur;
	private String isbn;
	
	public Livre(int id, String titre, String auteur, String isbn) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.isbn = isbn;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(auteur, id, isbn, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		return Objects.equals(auteur, other.auteur) && id == other.id && Objects.equals(isbn, other.isbn)
				&& Objects.equals(titre, other.titre);
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", isbn=" + isbn + "]";
	}

	
}
