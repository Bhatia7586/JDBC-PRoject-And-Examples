package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MSExcelInJdbc {
	public static void main(String[] args) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:exceldsn");
			System.out.println("connection opened");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from [sheet1$]");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2)
						+ " : " + rs.getString(3));
				System.out.println("------------------------");
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
