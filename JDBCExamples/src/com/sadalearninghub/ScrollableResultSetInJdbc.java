package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableResultSetInJdbc {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection opened");
			Statement stmt = con.createStatement(1004, 1007);
			ResultSet rs = stmt.executeQuery("select * from employee");
			rs.afterLast();// cursor moves last before the row
			while (rs.previous()) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2)
						+ " : " + rs.getString(3));
			}
			System.out.println("==============================");
			System.out.println("cursor moves from 3rd row to top to bottom");
			rs.absolute(3);// cursor moves from 3rd row to top to bottom
			System.out.println(rs.getString(1) + " : " + rs.getString(2)
					+ " : " + rs.getString(3));
			System.out.println("===============================");

			System.out.println("cursor moves from current position to -1 row");
			rs.relative(-1);// cursor moves from current position to -1 row
			System.out.println(rs.getString(1) + " : " + rs.getString(2)
					+ " : " + rs.getString(3));
			System.out.println("=====================================");

			System.out
					.println("cursor moves to current position and storerow number into k");
			int k = rs.getRow();// cursor moves to current position and storerow
								// number into k
			System.out.println("the cursor in this row is :" + k);

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
