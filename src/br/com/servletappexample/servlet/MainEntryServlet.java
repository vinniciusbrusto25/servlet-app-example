package br.com.servletappexample.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		String nameView = null;
		
		//This works like a controller, just delegates the action to the class responsible for it.
		if (action.equals("listCompanies")) {
			
			ListCompanies listAction = new ListCompanies();
			nameView = listAction.run(request, response);
			
		} else if (action.equals("removeCompany")) {
			
			RemoveCompany removeAction = new RemoveCompany();
			nameView = removeAction.run(request, response);
			
		} else if (action.equals("viewCompany")) {
			
			ViewCompany viewAction = new ViewCompany();
			nameView = viewAction.run(request, response);
			
		} else if (action.equals("editCompany")) {
			
			EditCompany editAction = new EditCompany();
			nameView = editAction.run(request, response);
			
		} else if (action.equals("newCompany")) {
			
			NewCompany newAction = new NewCompany();
			nameView = newAction.run(request, response);
			
		}
		
		String[] typeUri = nameView.split(":");
		
		if (typeUri[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(typeUri[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeUri[1]);
		}
			
		
	}

}
