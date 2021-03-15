package br.com.servletappexample.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.servletappexample.model.Company;
import br.com.servletappexample.model.Database;

public class ViewCompany {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database db = new Database();
		Company company = db.searchCompanyById(id);
		
		System.out.println(company.getName());
		
		request.setAttribute("company", company);
		
		return "forward:/formEditCompany.jsp";
	}

}
