package com.ensta.librarymanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.service.EmpruntService;
import com.ensta.librarymanager.service.LivreService;
import com.ensta.librarymanager.service.MembreService;


@WebServlet("/dashboard")
public class HomeServlet extends HttpServlet{
	
	
	private static final long serialVersionUID =1L;
	LivreService livre = LivreService.getInstance();
	EmpruntService emprunt = EmpruntService.getInstance();
	MembreService membre = MembreService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			request.setAttribute("bookCount",livre.count());
			request.setAttribute("borrowCount",emprunt.count());
			request.setAttribute("memberCount",membre.count());
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/dashboard.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}

