package com.ensta.librarymanager.service;

import java.util.List;

import com.ensta.librarymanager.dao.LivreDao;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.modele.Livre;

public class LivreService implements ILivreService {
	
	private LivreDao livreDao = new LivreDao();
	
	static LivreService instance;
	public static LivreService getInstance() {
		if (instance== null) {
			instance = new LivreService();
		}
		return instance;
		
	}

	@Override
	public List<Livre> getList() throws ServiceException {
		try {
			return this.livreDao.getList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Livre> getListDispo() throws ServiceException {
		
		return null;
	}

	@Override
	public Livre getById(int id) throws ServiceException {
		try {
			return this.livreDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public int create(String titre, String auteur, String isbn) throws ServiceException {
		try {
			return this.livreDao.create(titre, auteur, isbn);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void update(Livre livre) throws ServiceException {
		try {
			this.livreDao.update(livre);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	@Override
	public void delete(int id) throws ServiceException {
		try {
			this.livreDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}


	}

	@Override
	public int count() throws ServiceException {
		try {
			return this.livreDao.count();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

}
