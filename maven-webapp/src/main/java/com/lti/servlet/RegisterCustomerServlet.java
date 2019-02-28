package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.module.Customer;

@WebServlet("/register")
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=  Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		String email= request.getParameter("email"); 
		
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setEmail(email);
		
		CustomerDao dao = new CustomerDao();
		dao.add(customer);
		response.sendRedirect("confirmation.html");
		
	}

}