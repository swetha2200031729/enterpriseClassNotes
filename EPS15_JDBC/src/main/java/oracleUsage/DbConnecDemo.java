package oracleUsage;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
public class DbConnecDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Driver drv=new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(drv);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","vijay");
		if(con!=null) {
			System.out.println("connected");
		}else {
			System.out.println("not connected");
		}

	}

}