package br.com.servletappexample.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns = "/main")
public class MonitorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("MonitorFilter");
		
		long before = System.currentTimeMillis();
		String action = request.getParameter("action");
		
		//Follow or continue the request.
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		System.out.println("Execution time for the action " + action + ": " + (after - before));
		
	}

}
