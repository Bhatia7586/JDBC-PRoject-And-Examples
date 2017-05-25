package com.sadalearninghub;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlDateTime {

	public static void main(String[] args) {
		java.util.Date javaDate = new java.util.Date();
		long javaTime = javaDate.getTime();
		System.out.println("The java date is :" + javaTime);

		// Get and display SQL Date
		java.sql.Date sqlDate = new java.sql.Date(javaTime);
		System.out.println("The SQL date is :" + sqlDate.toString());

		// Get And Display SQL Time
		java.sql.Time sqlTime = new java.sql.Time(javaTime);
		System.out.println("The sql time is :" + sqlTime.toString());

		// Get And Display SqlTimeStamp
		java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(javaTime);
		System.out.println("The Sql TimeStamp is :" + sqlTimeStamp.toString());
		try {
			Connection conn = null;
			Statement stmt = conn.createStatement();
			String str = "select eid from emp";
			ResultSet rs = stmt.executeQuery(str);
			int id = rs.getInt(1);
			if (rs.wasNull()) {
				id = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
