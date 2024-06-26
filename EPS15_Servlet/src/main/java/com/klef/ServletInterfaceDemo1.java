package com.klef;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;
public class ServletInterfaceDemo1 implements Servlet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date d=new Date();
		arg1.setContentType("text/html");
		PrintWriter pw=arg1.getWriter();
		pw.print("<html> <head><title>Servlet interface</title><head> <body> <h2> GSD-Date :"+d.toString()+"</h2></body></html>");
		
		
	}

}
