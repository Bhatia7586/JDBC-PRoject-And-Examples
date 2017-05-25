package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessingInJdbc {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection opened");
			Statement stmt = con.createStatement();
			stmt.addBatch("insert into dept values(11,'BB',5000)");
			stmt.addBatch("update employee set ename='sada' where eno=2");
			stmt.addBatch("delete from student_info where ssid=101");
			try {
				int k[] = stmt.executeBatch();
				System.out.println("batch is succesfull");

			} catch (Exception e) {
				try {
					System.out.println("batch execution failed");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("batch execution failed");
			// e.printStackTrace();
		}
	}
}
