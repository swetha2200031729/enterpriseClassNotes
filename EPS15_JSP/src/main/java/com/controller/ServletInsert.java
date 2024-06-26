package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.StudentInsert;

public class ServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletInsert() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("sid"));
		String name=request.getParameter("sname");
		int cgp=Integer.parseInt(request.getParameter("cgp"));
		StudentInsert si=new StudentInsert();
		si.setSid(id);
		si.setSname(name);
		si.setCgp(cgp);
		try {
			si.insert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw=response.getWriter();
		pw.print("Data Inserted");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
