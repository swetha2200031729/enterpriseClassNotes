package com.klef;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
public class HttpClassDemo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write("Hi, this is HTTP class type");
    }
	

}
