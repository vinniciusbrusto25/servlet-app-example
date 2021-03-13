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

public class EditCompany {

	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String txtIdCompany = request.getParameter("txtIdCompny");
		Integer id = Integer.valueOf(txtIdCompany);
		String txtNameCompany = request.getParameter("txtName");
		String txtDateEntry = request.getParameter("txtDateEntry");
		
		System.out.println("Editing company id: " + id);
		
		Date dateEntry = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateEntry = sdf.parse(txtDateEntry);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);
		
		Database db = new Database();
		Company company = db.searchCompanyById(id);
		company.setName(txtNameCompany);
		company.setDateEntry(dateEntry);
		
		response.sendRedirect("main?action=listCompanies");
	}

}
