package br.com.servletappexample.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.servletappexample.action.ActionApp;

//This works like a controller, just delegates the action to the class responsible for it.
@WebServlet("/main")
public class MainEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nameAction = request.getParameter("action");
		HttpSession session = request.getSession();
		boolean isUserLogged = (session.getAttribute("userLogged") != null);
		boolean isProtectedAction = !(nameAction.equals("LoginForm") || nameAction.equals("Login"));
		
		if (isProtectedAction && (!isUserLogged)) {
			response.sendRedirect("main?action=LoginForm");
			return;
		}
		
		String className = "br.com.servletappexample.action." + nameAction;
		
		String nameView;
		try {
			Class actionClass = Class.forName(className);
			ActionApp actionapp = (ActionApp) actionClass.newInstance();
			nameView = actionapp.run(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException| IOException e) {
			throw new ServletException(e);
		}
		
		String[] typeUri = nameView.split(":");
		
		if (typeUri[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typeUri[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeUri[1]);
		}
			
	}

}
