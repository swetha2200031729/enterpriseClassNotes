package oracleUsage;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertingData {
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
		String query="insert into student values(111,'vijay',9)";
		st.execute(query);
		System.out.println("Data inserted");
		con.close();

	}


}
