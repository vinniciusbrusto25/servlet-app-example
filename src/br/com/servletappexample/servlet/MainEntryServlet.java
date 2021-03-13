package br.com.servletappexample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.servletappexample.action.EditCompany;
import br.com.servletappexample.action.ListCompanies;
import br.com.servletappexample.action.NewCompany;
import br.com.servletappexample.action.RemoveCompany;
import br.com.servletappexample.action.ViewCompany;

@WebServlet("/main")
public class MainEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		//This works like a controller, just delegates the action to the class responsible for it.
		if (action.equals("listCompanies")) {
			ListCompanies listAction = new ListCompanies();
			listAction.run(request, response);
		} else if (action.equals("removeCompany")) {
			RemoveCompany removeAction = new RemoveCompany();
			removeAction.run(request, response);
		} else if (action.equals("viewCompany")) {
			ViewCompany viewAction = new ViewCompany();
			viewAction.run(request, response);
		} else if (action.equals("editCompany")) {
			EditCompany editAction = new EditCompany();
			editAction.run(request, response);
		} else if (action.equals("newCompany")) {
			NewCompany newAction = new NewCompany();
			newAction.run(request, response);
		}
	}

}
