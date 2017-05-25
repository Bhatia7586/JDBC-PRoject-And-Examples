package com.sadalearninghub;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {

	public static void main(String[] args) throws InstantiationException {
		Connection conn = null;
		PreparedStatement pstmt = null;
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

			pstmt = conn.prepareStatement("update emp set ename=? where eid=?");
			pstmt.setString(1, "SadaLearningHub");
			pstmt.setInt(2, 1);

			ParameterMetaData pmd = pstmt.getParameterMetaData();
			System.out
					.println("It is to find the count of parameters(? symbol)."
							+ pmd.getParameterCount());

			pstmt.execute();

			System.out.println("Updated successfuly");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close connection
			try {
				conn.close();
				pstmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
