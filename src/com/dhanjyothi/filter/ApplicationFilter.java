package com.dhanjyothi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dhanjyothi.util.Constants;

public class ApplicationFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) {
		//
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		if(null != session && (session.isNew() || null == session.getAttribute(Constants.LOGGED_USER))) {
			session.invalidate();
			req.getRequestDispatcher("/login/logout.htm").forward(request, response);
		}else {
			filterChain.doFilter(request, response);
		}
		
	}
	
	@Override
	public void destroy() {
		//
	}
}
