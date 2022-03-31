package com.ensta.librarymanager.service;

import java.time.LocalDate;
import java.util.List;

import com.ensta.librarymanager.dao.EmpruntDao;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.modele.Abonnement;
import com.ensta.librarymanager.modele.Emprunt;
import com.ensta.librarymanager.modele.Membre;

public class EmpruntService implements IEmpruntService {

	private EmpruntDao empruntDao = new EmpruntDao();
	
	static EmpruntService instance;
	public static EmpruntService getInstance() {
		if (instance== null) {
			instance = new EmpruntService();
		}
		return instance;
		
	}
	@Override
	public List<Emprunt> getList() throws ServiceException {
		try {
			return this.empruntDao.getList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Emprunt> getListCurrent() throws ServiceException {
		try {
			return this.empruntDao.getListCurrent();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Emprunt> getListCurrentByMembre(int idMembre) throws ServiceException {
		try {
			return this.empruntDao.getListCurrentByMembre(idMembre);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Emprunt> getListCurrentByLivre(int idLivre) throws ServiceException {
		try {
			return this.empruntDao.getListCurrentByLivre(idLivre);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public Emprunt getById(int id) throws ServiceException {
		try {
			return this.empruntDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void create(int idMembre, int idLivre, LocalDate dateEmprunt) throws ServiceException {
		try {
			this.empruntDao.create(idMembre,idLivre,dateEmprunt);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	@Override
	public void returnBook(int id) throws ServiceException {
		try {
			Emprunt emprunt = empruntDao.getById(id);
            emprunt.setDateRetour(LocalDate.now());
			empruntDao.update(emprunt);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	@Override
	public int count() throws ServiceException {
		try {
			return this.empruntDao.count();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public boolean isLivreDispo(int idLivre) throws ServiceException {
		try {
			List<Emprunt> listLivre = empruntDao.getListCurrentByLivre(idLivre);
            if(listLivre.size() == 0) {
                return true;
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
		return false;
	}

	@Override
	public boolean isEmpruntPossible(Membre membre) throws ServiceException {
		try {
			List<Emprunt> listEmprunt = empruntDao.getListCurrentByMembre(membre.getId());
            Abonnement abonnement = membre.getAbonnement();
            int n = listEmprunt.size();
            if (abonnement == Abonnement.BASIC && n < 2) {return true;} 
            if (abonnement == Abonnement.PREMIUM && n < 5) {return true;} 
            if (abonnement == Abonnement.VIP && n < 20) {return true;}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
		return false;
	}

}
