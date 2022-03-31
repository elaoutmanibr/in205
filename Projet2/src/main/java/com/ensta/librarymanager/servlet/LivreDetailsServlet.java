package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.modele.Emprunt;
import com.ensta.librarymanager.modele.Livre;
import com.ensta.librarymanager.service.EmpruntService;
import com.ensta.librarymanager.service.LivreService;
import com.ensta.librarymanager.service.MembreService;

@WebServlet("/livre_details")
public class LivreDetailsServlet extends HttpServlet{
private static final long serialVersionUID =1L;
	
	
	
	LivreService livre = LivreService.getInstance();
	EmpruntService emprunt = EmpruntService.getInstance();
	MembreService membre = MembreService.getInstance();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int id  = Integer.parseInt(request.getParameter("id"));
			Livre l = livre.getById(id);
			List<Emprunt> lst = emprunt.getListCurrentByLivre(id);
			
			request.setAttribute("borrowList",lst);
			request.setAttribute("livre",l);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/livre_details.jsp").forward(request, response);
		} catch (ServiceException e) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/error_500.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id  = Integer.parseInt(request.getParameter("id"));
			String titre = request.getParameter("titre");
			String auteur = request.getParameter("auteur");
			String isbn = request.getParameter("isbn");
			
			Livre l = livre.getById(id);
			l.setTitre(titre);
			l.setAuteur(auteur);
			l.setIsbn(isbn);
			livre.update(l);
			
			response.sendRedirect("livre_list");
			
		} catch (ServiceException e) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/error_500.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}
