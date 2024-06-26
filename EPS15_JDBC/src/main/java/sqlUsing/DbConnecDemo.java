package sqlUsing;

import java.sql.*;
public class DbConnecDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Driver drv=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(drv);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_data","root","vijay");
		if(con!=null) {
			System.out.println("Conected");
		}else {
			System.out.println("Not Connected");
		}

	}

}
