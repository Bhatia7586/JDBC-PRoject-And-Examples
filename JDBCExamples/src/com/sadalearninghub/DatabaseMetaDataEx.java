package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDataEx {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection opened");
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Database server: "
					+ dbmd.getDatabaseProductName());
			System.out.println(con.getClass().getName());
			System.out.println("Database server version: "
					+ dbmd.getDatabaseProductVersion());
			System.out.println("Max columns allowed in a table: "
					+ dbmd.getMaxColumnsInTable());
			System.out.println("Max characters allowed in a table: "
					+ dbmd.getMaxTableNameLength());
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
