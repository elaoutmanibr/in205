package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.modele.Abonnement;
import com.ensta.librarymanager.modele.Emprunt;
import com.ensta.librarymanager.modele.Livre;
import com.ensta.librarymanager.modele.Membre;
import com.ensta.librarymanager.service.EmpruntService;
import com.ensta.librarymanager.service.LivreService;
import com.ensta.librarymanager.service.MembreService;

@WebServlet("/membre_details")
public class MembreDetailsServlet extends HttpServlet{
private static final long serialVersionUID =1L;
	
	
	
	EmpruntService emprunt = EmpruntService.getInstance();
	MembreService membre = MembreService.getInstance();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int id  = Integer.parseInt(request.getParameter("id"));
			Membre m = membre.getById(id);
			List<Emprunt> lst = emprunt.getListCurrentByLivre(id);
			
			request.setAttribute("borrowList",lst);
			request.setAttribute("member",m);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/membre_details.jsp").forward(request, response);
		} catch (ServiceException e) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/error_500.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id  = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String abonnement = request.getParameter("abonnement");
			Membre m = membre.getById(id);
			m.setPrenom(prenom);
			m.setNom(nom);
			m.setAdresse(adresse);
			m.setEmail(email);
			m.setTelephone(telephone);
			m.setAbonnement(Abonnement.fromString(abonnement));
			membre.update(m);
			
			response.sendRedirect("membre_list");
			
		} catch (ServiceException e) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/error_500.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}

