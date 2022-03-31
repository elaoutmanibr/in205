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
import com.ensta.librarymanager.modele.Emprunt;
import com.ensta.librarymanager.service.EmpruntService;


@WebServlet("/emprunt_return")
public class EmpruntReturnServlet extends HttpServlet{
	
	
	private static final long serialVersionUID =1L;
	EmpruntService emprunt = EmpruntService.getInstance();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Emprunt> lst = emprunt.getListCurrent();
			request.setAttribute("borrowList",lst);
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/emprunt_return.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			emprunt.returnBook(id);
			this.doGet(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
				
	}
}
