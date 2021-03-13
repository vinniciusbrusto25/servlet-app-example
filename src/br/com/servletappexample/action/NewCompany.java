package br.com.servletappexample.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.servletappexample.model.Company;
import br.com.servletappexample.model.Database;

public class NewCompany {

	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String txtNameCompany = request.getParameter("txtName");
		String txtDateEntry = request.getParameter("txtDateEntry");
		
		System.out.println("Adding the new company: " + txtNameCompany);
		
		Date dateEntry = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateEntry = sdf.parse(txtDateEntry);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Company company = new Company();
		company.setName(txtNameCompany);
		company.setDateEntry(dateEntry);
		
		Database database = new Database();
		database.add(company);
		
		request.setAttribute("company", company.getName());
		
		response.sendRedirect("main?action=listCompanies");
	}

}
