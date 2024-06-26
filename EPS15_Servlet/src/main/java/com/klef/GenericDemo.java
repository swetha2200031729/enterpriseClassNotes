package com.klef;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
public class GenericDemo extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		arg1.setContentType("text/html");
		PrintWriter pw=arg1.getWriter();
		pw.print("<html>hi it is generic class</html>");
		
	}

}
