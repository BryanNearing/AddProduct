package com.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Hibernate.*;
import com.entity.Product;

/**
 * Servlet implementation class FormInput
 */
@WebServlet("/FormInput")
public class FormInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		float cost = Float.parseFloat(request.getParameter("cost"));
		
		Session sesh = HibernateUtility.getSession();
		
		Transaction tx = sesh.beginTransaction();
		
		Product p = new Product(name, department, cost);
		
		sesh.save(p);
		
		tx.commit();
		
		response.sendRedirect("productAddSuccess.jsp");
	}

}
