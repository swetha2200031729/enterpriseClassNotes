package oracleUsage;

import java.sql.*;

public class TableCreate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Driver drv=new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(drv);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","vijay");
		if(con!=null) {
			System.out.println("connected");
		}else {
			System.out.println("Not Connected");
		}
		Statement st=con.createStatement();
		st.execute("create table student(sid number, sname varchar(50), cgp number)");
		System.out.println("table created");
		con.close();

	}

}
