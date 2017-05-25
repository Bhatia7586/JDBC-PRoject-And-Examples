package com.sadalearninghub;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DtabaseConnectionExample {

	public static void main(String[] args) throws InstantiationException {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Approch-1 to register the driver

			// This is for MySql database
			// Class.forName("com.mysql.jdbc.Driver").newInstance();

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

			stmt = conn.createStatement();
			boolean b = stmt
					.execute("create table emp(eid number, ename varchar(20))");
			if (b) {
				System.out.println("emp table created successfully");
			} else {
				System.out.println("emp table creation failed");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close connection
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
