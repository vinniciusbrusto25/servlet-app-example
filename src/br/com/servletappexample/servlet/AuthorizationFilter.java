package br.com.servletappexample.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/main")
public class AuthorizationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		
		System.out.println("AuthorizationFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String nameAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean isUserLogged = (session.getAttribute("userLogged") != null);
		boolean isProtectedAction = !(nameAction.equals("LoginForm") || nameAction.equals("Login"));
		
		if (isProtectedAction && (!isUserLogged)) {
			response.sendRedirect("main?action=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
