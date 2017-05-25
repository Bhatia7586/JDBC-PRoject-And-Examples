package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdatableResultSetInJdbc {
	Connection con;
	Statement stmt;

	public void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection opened");
			stmt = con.createStatement(1004, 1008);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertStudent() {
		try {
			ResultSet rs = stmt.executeQuery("select * from student_info");
			rs.moveToInsertRow();
			rs.updateInt(1, 111);
			rs.updateString(2, "BBB");
			rs.updateInt(3, 999);
			rs.updateRow();
			System.out.println("one row is inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStudent() {
		try {
			ResultSet rs = stmt.executeQuery("select * from student_info");
			rs.absolute(3);
			rs.updateInt(3, 1000);
			rs.updateRow();
			System.out.println("one row is updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent() {
		try {
			ResultSet rs = stmt.executeQuery("select * from student_info");
			rs.absolute(2);
			rs.deleteRow();
			System.out.println("one row is deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			stmt.close();
			con.close();
			System.out.println("connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UpdatableResultSetInJdbc ut = new UpdatableResultSetInJdbc();
		ut.openConnection();
		ut.insertStudent();
		ut.updateStudent();
		ut.deleteStudent();
		ut.closeConnection();
	}
}
