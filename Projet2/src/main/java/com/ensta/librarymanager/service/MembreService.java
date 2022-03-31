package com.ensta.librarymanager.service;

import java.util.List;

import com.ensta.librarymanager.dao.MembreDao;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.modele.Membre;

public class MembreService implements IMembreService {

	private MembreDao membreDao = new MembreDao();
	
	static MembreService instance;
	public static MembreService getInstance() {
		if (instance== null) {
			instance = new MembreService();
		}
		return instance;
		
	}
	@Override
	public List<Membre> getList() throws ServiceException {
		try {
			return this.membreDao.getList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Membre> getListMembreEmpruntPossible() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Membre getById(int id) throws ServiceException {
		try {
			return this.membreDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public int create(String nom, String prenom, String adresse, String email, String telephone) throws ServiceException {
		try {
			return this.membreDao.create(nom,prenom,adresse,email,telephone);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void update(Membre membre) throws ServiceException {
		try {
			this.membreDao.update(membre);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	@Override
	public void delete(int id) throws ServiceException {
		try {
			this.membreDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public int count() throws ServiceException {
		try {
			return this.membreDao.count();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

}
