package com.sadalearninghub;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementExample {

	public static void main(String[] args) throws InstantiationException {
		Connection conn = null;
		CallableStatement cstmt = null;
		try {

			// Approch-2 to register driver using DriverManager.registerDriver
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);

			// URL : jdbc:mysql://localhost:3306/sada
			String url = "jdbc:mysql://localhost:3306/sada";
			String username = "root";
			String pwd = "root";

			conn = DriverManager.getConnection(url, username, pwd);
			if (conn != null) {
				System.out.println("Connection created successfully");
			} else {
				System.out.println("Connection failed");
			}

			cstmt = conn.prepareCall("{call getEmpName(?,?)}");

			System.out.println("Updated successfuly");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close connection
			try {
				cstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
