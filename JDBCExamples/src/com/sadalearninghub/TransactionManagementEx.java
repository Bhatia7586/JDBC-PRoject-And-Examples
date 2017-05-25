package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagementEx {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection is opened");
			stmt = con.createStatement();
			con.setAutoCommit(false);
			int i = stmt
					.executeUpdate("insert into student_info values(101,'sada',500)");
			int j = stmt
					.executeUpdate("update customer_info set cadd='hyd' where cid=101");
			int k = stmt.executeUpdate("delete from employee where eno=7799");
			con.commit();
			System.out.println("transaction success");
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("transaction failed");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
