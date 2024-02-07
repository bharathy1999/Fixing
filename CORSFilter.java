package com.signupprofile.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletResponse response=(HttpServletResponse)arg1;
		HttpServletRequest request = (HttpServletRequest) arg0;

		response.setHeader("Access-Control-Allow-Origin", "*");

        // Allow specified HTTP methods
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

        // Allow specified headers
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Allow credentials (if required)
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Set maximum age of preflight request cache
        response.setHeader("Access-Control-Max-Age", "3600");

        // Handle preflight requests
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // Pass request down the chain, allowing the servlet to handle the actual request
        	arg2.doFilter(request, response);
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
