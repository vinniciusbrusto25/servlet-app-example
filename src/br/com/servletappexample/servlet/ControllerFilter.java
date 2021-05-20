package br.com.servletappexample.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.servletappexample.action.ActionApp;

//@WebFilter("/main")
public class ControllerFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		
		System.out.println("ControllerFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String nameAction = request.getParameter("action");
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
