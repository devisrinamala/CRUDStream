package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deletion {

	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "akshaya@123";
	public static final String Url = "jdbc:mysql://localhost:3306/demo";
	public static Connection conn;
	public static PreparedStatement pmst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			String sql = "delete from employee where emp_id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter employee id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("Error");
			}
			sc.close();
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
