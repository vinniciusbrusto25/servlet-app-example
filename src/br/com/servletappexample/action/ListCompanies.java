package br.com.servletappexample.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.servletappexample.model.Company;
import br.com.servletappexample.model.Database;

public class ListCompanies implements ActionApp {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Database database = new Database();
		List<Company> list = database.getCompanies();
		
		request.setAttribute("listOfCompanies", list);
		
		System.out.println("Listing companies...");
		
		return "forward:listCompanies.jsp";
	}
}
