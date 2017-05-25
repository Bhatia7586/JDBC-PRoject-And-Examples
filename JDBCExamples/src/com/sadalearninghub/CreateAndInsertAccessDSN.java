package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateAndInsertAccessDSN {
	public static void main(String[] args) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:accessdsn");
			System.out.println("connection is opened");
			Statement stmt = con.createStatement();
			int i = stmt
					.executeUpdate("create table sample(id number, name text, address text)");
			System.out.println("Table created");
			int k = stmt
					.executeUpdate("insert into sample values(1,'A','HYD')");
			int k1 = stmt
					.executeUpdate("insert into sample values(2,'B','HYD')");
			System.out.println("rows are inserted");
			stmt.close();
			con.close();
			System.out.println("Connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
