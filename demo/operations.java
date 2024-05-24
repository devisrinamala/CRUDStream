package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class operations {

	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "akshaya@123";
	public static final String Url = "";
	public static Connection conn;
	public static PreparedStatement pmst;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			display();
			System.out.println("Enter choice");
			ch = Integer.parseInt(sc.nextLine());
			switch(ch) {
			case 1:
				createdatabse();
				break;
			case 2:
				createtable();
				break;
			case 3:
				insertion();
				break;
			case 4:
				deletion();
				break;
			case 5:
				getall();
				break;
			case 6:
				getbyid();
				break;
			case 7:
				droptable();
				break;
			case 8:
				dropdatabase();
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (ch>0);
	}
	
	private static void dropdatabase() {
		String Url = "jdbc:mysql://localhost:3306/";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter Database Name");
			String sql = "drop database " + sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Database is successfully dropped");
			}
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void droptable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String Url = "jdbc:mysql://localhost:3306/ " + sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter table Name");
			String sql = "drop table " + sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Table is successfully Deleted");
			}
			else {
				System.out.println("Error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getbyid() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String Url = "jdbc:mysql://localhost:3306/" + sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter table name");
			String sql = "select * from "+sc.next()+" where id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter id");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				System.out.println("id: " + rs.getInt("id")); 
				System.out.println("name: " + rs.getString("name")); 
				System.out.println("email: " + rs.getString("email"));
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getall() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String Url = "jdbc:mysql://localhost:3306/ " + sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter table Name");
			String sql = "select * from " + sc.next();
			pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				System.out.println("id: " + rs.getInt("id")); 
				System.out.println("name: " + rs.getString("name")); 
				System.out.println("email: " + rs.getString("email"));
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void deletion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String Url = "jdbc:mysql://localhost:3306/ " + sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter table name");
			String sql = "delete from "+sc.next()+" where id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter student id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data is successfully deleted");
			}
			else {
				System.out.println("Error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void insertion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String Url = "jdbc:mysql://localhost:3306/ " + sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter table name");
			String sql = "insert into "+sc.next()+"(id,name,email) values(?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter name");
			pmst.setString(2, sc.next());
			System.out.println("Enter email");
			pmst.setString(3, sc.next());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data is successfully inserted");
			}
			else {
				System.out.println("Error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createtable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String Url = "jdbc:mysql://localhost:3306/ " + sc.next();
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter table Name");
			String sql = "create table " + sc.next() + "(id int,name varchar(20),email varchar(30))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Table is successfully created");
			}
			else {
				System.out.println("Error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void createdatabse() {
		String Url = "jdbc:mysql://localhost:3306/";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter Database Name");
			String sql = "create database " + sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Database is successfully created");
			}
			else {
				System.out.println("Error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void display() {
		System.out.println("Operations");
		System.out.println("\t1 .create database");
		System.out.println("\t2 .create table");
		System.out.println("\t3 .Insertion of data");
		System.out.println("\t4 .Deletion of data");
		System.out.println("\t5 .Fetch all records");
		System.out.println("\t6 .Get record by id");
		System.out.println("\t7 .Deletion of table");
		System.out.println("\t8 .Deletion of database");
		System.out.println("\t9 .Terminate process");
	}
}
