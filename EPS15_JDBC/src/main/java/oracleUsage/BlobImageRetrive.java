package oracleUsage;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BlobImageRetrive {
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
		ResultSet rs=st.executeQuery("select * from imagetab");
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			Blob b=rs.getBlob(3);
			byte[] imagedata=b.getBytes(1, (int)b.length());
			FileOutputStream fo=new FileOutputStream("C:\\Users\\manim\\OneDrive\\Pictures\\my pics\\ret_img.jpeg");
			fo.write(imagedata);
			System.out.println(id+" "+name+" retreved");
		}
		
		con.close();


	}


}
