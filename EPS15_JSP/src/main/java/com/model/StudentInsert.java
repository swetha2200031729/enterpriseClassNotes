package com.model;
import java.sql.*;
public class StudentInsert extends Student{
	public void insert() throws Exception{
		Driver drv=new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(drv);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","vijay");
		PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?)");
		pst.setInt(1, getSid());
		pst.setString(2, getSname());
		pst.setInt(3, getCgp());
		pst.execute();
	}

}
