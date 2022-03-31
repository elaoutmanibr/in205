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

@WebServlet("/emprunt_list")
public class EmpruntListServlet extends HttpServlet{
	EmpruntService emprunt = EmpruntService.getInstance();
	
	private static final long serialVersionUID =1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			if (request.getParameter("show") != null && request.getParameter("show").contains("all")){
	            request.setAttribute("borrowList", emprunt.getList());
	            request.setAttribute("show", "all");
	        }else {
	            request.setAttribute("borrowList", emprunt.getListCurrent());
	            request.setAttribute("show", "current");
	        }
			this.getServletContext().getRequestDispatcher("/WEB-INF/View/emprunt_list.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
