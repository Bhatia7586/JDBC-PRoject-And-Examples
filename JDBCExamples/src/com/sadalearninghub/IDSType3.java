package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class IDSType3 {
	public static void main(String[] args) {
		try {
			Class.forName("jdbc.sql.IDSDriver");
			Connection con = DriverManager
					.getConnection("jdbc:ids://localhost:12/conn?dsn=accdsn");
			Statement stmt = con.createStatement();
			int k = stmt
					.executeUpdate("create table student(sid number, sname text)");
			System.out.println("table created");
			int i = stmt.executeUpdate("insert into student values(111,'DDD')");
			System.out.println(i + " rows are inserted");
			stmt.close();
			con.close();
		} catch (Exception e) {
		}
	}
}
