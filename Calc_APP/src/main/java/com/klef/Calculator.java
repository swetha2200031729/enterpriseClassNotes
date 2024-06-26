package com.klef;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {
  private static final long serialVersionUID = 1L;
    
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
//	  int A=Integer.parseInt(request.getParameter("v1"));
//	  int B=Integer.parseInt(request.getParameter("v2"));
//	  int C=A+B;
	  response.setContentType("text/html");
	  PrintWriter pw=response.getWriter();
	  pw.print("Sol = ");
    
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    
  }

}