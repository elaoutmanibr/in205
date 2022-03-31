package com.ensta.librarymanager.main;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.service.LivreService;

public class Main {
	public static void main (String [] args) {
		LivreService l = new LivreService();
		try {
			
			System.out.println(l.getById(1));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
