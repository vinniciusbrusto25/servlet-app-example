package br.com.servletappexample.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.servletappexample.model.Database;
import br.com.servletappexample.model.User;

public class Login implements ActionApp {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		
		System.out.println(login + " is logging...");
		
		Database db = new Database();
		User usr = db.findUserByLogin(login, password);
		
		if (usr != null) {
			System.out.println("User authenticated!");
			HttpSession session = request.getSession();
			session.setAttribute("userLogged", usr);
			return "redirect:main?action=ListCompanies";
		} else {
			System.out.println("Invalid user!");
			return "redirect:main?action=LoginForm";
		}
		
		
	}

}
