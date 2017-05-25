package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMyDBConn {
	// JDBC driver name and database URL
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/sada";

	// DB Credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_Driver);

			System.out.println("Connecting to DB");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				System.out.println("Connection created sucessfully");
			} else {
				System.out.println("Connection Failed");
			}

			System.out.println("Create statement object");
			stmt = conn.createStatement();
			String query = "select eid, ename from emp";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("eid");
				String name = rs.getString("ename");

				System.out.println("ID is: " + id);
				System.out.println("Name is: " + name);
				System.out.println("======================================");
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
