package oracleUsage;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
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
		PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?)");
		pst.setInt(1,222);
		pst.setString(2,"pruthvi");
		pst.setInt(3, 9);
		pst.execute();
		System.out.println("Data Inserted Via Prepared Statement");
		con.close();

	}


}
