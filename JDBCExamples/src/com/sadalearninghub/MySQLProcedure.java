package com.sadalearninghub;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class MySQLProcedure {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection is opened");
			CallableStatement cstmt = con.prepareCall("{call pro1(?,?)}");
			cstmt.setInt(1, 10);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			int k = cstmt.getInt(2);
			System.out.println("Square of the given number: " + k);
			cstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
