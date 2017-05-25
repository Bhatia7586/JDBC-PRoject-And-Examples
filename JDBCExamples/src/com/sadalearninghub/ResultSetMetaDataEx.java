package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataEx {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection opened");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dept");
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			// print column name
			for (int i = 1; i <= count; i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			System.out.println("============================");
			// print column size and its datatype
			for (int i = 1; i <= count; i++) {
				System.out.println(rsmd.getColumnTypeName(i) + " : "
						+ rsmd.getColumnDisplaySize(i));
			}
			System.out.println("============================");

			while (rs.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs.getString(i) + " : ");
				}
				System.out.println();
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
