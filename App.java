package com.example.mavenproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class App {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";

	private static final String Username = "root";

	private static final String Password = "akshaya@123";

	private static final String Url = "";

	private static Connection conn;

	private static PreparedStatement pmst;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int ch;

		do {
			display();

			System.out.println("Enter your choice");

			ch = Integer.parseInt(sc.next());

			switch (ch) {

			case 1:
				createdatabase();
				break;

			case 2:
				dropdatabase();

			case 3:
				createtable();
				break;

			case 4:
				droptable();
				break;

			case 5:
				insertdata();
				break;

			case 6:
				updatedata();
				break;

			case 7:
				deletedata();
				break;

			case 8:
				getall();
				break;

			case 9:
				getby();
				break;

			case 10:
				System.exit(ch);

			default:
				System.out.println("Invalid Operation");
			}

		} while (ch > 0);
	}

	private static void getby() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter database name");

		String Url = "jdbc:mysql://localhost:3306/" + sc.next();
		try {

			Class.forName(Driver);

			conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter table name");

			String sql = "select * from " + sc.next() + " where email = ?";

			pmst = conn.prepareStatement(sql);

			System.out.println("enter email: ");

			pmst.setString(1, sc.next());

			ResultSet rs = pmst.executeQuery();

			while (rs.next()) {

				System.out.println("id: " + rs.getInt("id"));

				System.out.println("name: " + rs.getString("name"));

				System.out.println("email: " + rs.getString("email"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void getall() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter database name");

		String Url = "jdbc:mysql://localhost:3306/" + sc.next();

		try {

			Class.forName(Driver);

			conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter table name");

			String sql = "select * from " + sc.next();

			pmst = conn.prepareStatement(sql);

			ResultSet rs = pmst.executeQuery();

			while (rs.next()) {

				System.out.println("id: " + rs.getInt("id"));

				System.out.println("name: " + rs.getString("name"));

				System.out.println("email: " + rs.getString("email"));

				System.out.println(" ");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static void deletedata() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter database");

		String Url = "jdbc:mysql://localhost:3306/ " + sc.next();

		try {

			Class.forName(Driver);

			conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter table name");

			String sql = "delete from " + sc.next() + " where id = ?";

			pmst = conn.prepareStatement(sql);

			System.out.println("Enter id");

			pmst.setInt(1, sc.nextInt());

			int i = pmst.executeUpdate();

			if (i > 0) {

				System.out.println("Data deleted successfully");
			} else {

				System.out.println("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void updatedata() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter database name");

		String Url = "jdbc:mysql://localhost:3306/ " + sc.next();
		try {

			Class.forName(Driver);

			conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter table name");

			String sql = "update " + sc.next() + " set name = ?,email = ? where id = ?";

			pmst = conn.prepareStatement(sql);

			System.out.println("Enter name");

			pmst.setString(1, sc.next());

			System.out.println("Enter email");

			pmst.setString(2, sc.next());

			System.out.println("Enter id");

			pmst.setInt(3, sc.nextInt());

			int i = pmst.executeUpdate();

			if (i > 0) {

				System.out.println("Data updated successfully");
			} else {

				System.out.println("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void insertdata() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter database name");

		String Url = "jdbc:mysql://localhost:3306/ " + sc.next();

		try {

			Class.forName(Driver);

			conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter table name");

			String sql = "insert into " + sc.next() + " (id,name,email) values (?,?,?)";

			pmst = conn.prepareStatement(sql);

			System.out.println("Enter id");

			pmst.setInt(1, sc.nextInt());

			System.out.println("Enter name");

			pmst.setString(2, sc.next());

			System.out.println("Enter email");

			pmst.setString(3, sc.next());

			int i = pmst.executeUpdate();

			if (i > 0) {

				System.out.println("Data inserted successfully");
			} else {

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

			Connection conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter table name");

			String sql = "drop table " + sc.next();

			pmst = conn.prepareStatement(sql);

			int i = pmst.executeUpdate();

			if (i == 0) {

				System.out.println("Table deleted successfully");
			} else {

				System.out.println("Error");
			}
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

			Connection conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter table name");

			String sql = "create table " + sc.next() + " (id int,name varchar(20),email varchar(30))";

			pmst = conn.prepareStatement(sql);

			int i = pmst.executeUpdate();

			if (i == 0) {

				System.out.println("Table created successfully");
			} else {

				System.out.println("Error");
			}
		} catch (Exception e) {

		}

	}

	private static void dropdatabase() {

		Scanner sc = new Scanner(System.in);

		String Url = "jdbc:mysql://localhost:3306/";

		try {

			Class.forName(Driver);

			Connection conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter database name");

			String sql = "drop database " + sc.next();

			pmst = conn.prepareStatement(sql);

			int i = pmst.executeUpdate();

			if (i == 0) {

				System.out.println("Database deleted successfully");
			} else {

				System.out.println("Error");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static void createdatabase() {

		String Url = "jdbc:mysql://localhost:3306/";

		Scanner sc = new Scanner(System.in);

		try {

			Class.forName(Driver);

			Connection conn = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Enter database name");

			String sql = "create database " + sc.next();

			pmst = conn.prepareStatement(sql);

			int i = pmst.executeUpdate();

			if (i > 0) {

				System.out.println("database created successfully");
			} else {

				System.out.println("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void display() {

		System.out.println("*****************");

		System.out.println("\t1. create database");

		System.out.println("\t2. drop database");

		System.out.println("\t3. create table");

		System.out.println("\t4. drop table");

		System.out.println("\t5. insert data");

		System.out.println("\t6. edit data");

		System.out.println("\t7. delete data");

		System.out.println("\t8. get all records");

		System.out.println("\t9. get record by email");

		System.out.println("\t10. exit");

		System.out.println("*****************");

	}
}
