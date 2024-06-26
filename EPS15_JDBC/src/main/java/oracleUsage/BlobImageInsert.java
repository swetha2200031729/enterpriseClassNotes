package oracleUsage;

import java.io.FileInputStream;
import java.sql.*;



public class BlobImageInsert {
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
//		Statement st=con.createStatement();
//		st.execute("create table imagetab(id number,name varchar(30),image blob)");
//		System.out.println("table created ");
		
		PreparedStatement pst=con.prepareStatement("insert into imagetab values(?,?,?)");
		pst.setInt(1,111);
		pst.setString(2,"vijay");
		FileInputStream fs=new FileInputStream("C:\\Users\\manim\\OneDrive\\Pictures\\my pics\\My_id_photo.jpeg");		
		pst.setBinaryStream(3, fs, fs.available());
		pst.execute();
		System.out.println("image Data Inserted Via Prepared Statement");
		con.close();

	}

}
