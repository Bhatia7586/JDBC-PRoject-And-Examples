package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OracleType2 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:oci:@xe",
					"system", "root");
			System.out.println("connection opened");
			Statement stmt = con.createStatement();
			int i = stmt
					.executeUpdate("update emp set sal='999' where empno=10");
			System.out.println(i + " rows are updated");
			stmt.close();
			con.close();
			System.out.println("connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
