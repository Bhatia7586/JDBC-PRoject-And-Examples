package com.sadalearninghub;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class MySqlFunction {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection is opened");
			CallableStatement cstmt = con.prepareCall("{?=call fun1(?)}");
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setInt(2, 10);
			cstmt.execute();
			int k = cstmt.getInt(1);
			System.out.println("qube of the given number : " + k);
			cstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
