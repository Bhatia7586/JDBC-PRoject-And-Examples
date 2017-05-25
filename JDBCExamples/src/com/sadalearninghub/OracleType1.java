package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleType1 {
	public static void main(String[] args) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:oracledsn",
					"root", "root");
			System.out.println("connection is opened");
			Statement stmt = con.createStatement();
			// create table
			int i = stmt
					.executeUpdate("create table student_test(sid int, sname char(10), marks int)");
			System.out.println(i + " tables created");
			int j = stmt
					.executeUpdate("insert into student_test values(18,'AAA',56)");
			System.out.println(j + " rows is inserted");

			ResultSet rs = stmt.executeQuery("select * from student_test");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2)
						+ " : " + rs.getInt(3));
			}
			rs.close();
			stmt.close();
			con.close();
			System.out.println("connection closed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
