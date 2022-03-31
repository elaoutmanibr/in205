package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.service.LivreService;

@WebServlet("/livre_delete")
public class LivreDeleteServlet extends HttpServlet{
	
	
	private static final long serialVersionUID =1L;
	
	LivreService livre = LivreService.getInstance();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int id  = Integer.parseInt(request.getParameter("id"));
			livre.delete(id);
			
			response.sendRedirect("livre_list");
		} catch (ServiceException e) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/error_500.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
