package br.com.servletappexample.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.servletappexample.model.Database;

public class RemoveCompany {

	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database db = new Database();
		
		db.removeCompany(id);
		
		response.sendRedirect("main?action=listCompanies");
		
	}

}
