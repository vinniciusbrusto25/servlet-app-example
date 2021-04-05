package br.com.servletappexample.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCompanyForm implements ActionApp {
	
	public String run(HttpServletRequest request, HttpServletResponse response) {

		return "forward:formNewCompany.jsp";
	}

}
