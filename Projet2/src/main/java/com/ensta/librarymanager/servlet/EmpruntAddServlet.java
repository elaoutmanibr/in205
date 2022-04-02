package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.modele.Livre;
import com.ensta.librarymanager.modele.Membre;
import com.ensta.librarymanager.service.EmpruntService;
import com.ensta.librarymanager.service.LivreService;
import com.ensta.librarymanager.service.MembreService;

@WebServlet("/emprunt_add")
public class EmpruntAddServlet extends HttpServlet{
	
	
	private static final long serialVersionUID =1L;
	
	LivreService livre = LivreService.getInstance();
	EmpruntService emprunt = EmpruntService.getInstance();
	MembreService membre = MembreService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Livre> lst = livre.getList();
			request.setAttribute("bookList",lst);
			List<Membre> lst2 = membre.getList();
			request.setAttribute("memberList",lst2);
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/emprunt_add.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idMembre = Integer.parseInt(request.getParameter("idMembre"));
			int idLivre = Integer.parseInt(request.getParameter("idLivre"));
			LocalDate dateEmprunt = LocalDate.now();
			
			boolean b = emprunt.create(idMembre, idLivre, dateEmprunt);
			if (!b) {
				response.sendRedirect(request.getContextPath()+"/emprunt_error");
			}else {
				response.sendRedirect(request.getContextPath()+"/emprunt_add");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}