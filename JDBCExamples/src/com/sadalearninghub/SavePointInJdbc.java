package com.sadalearninghub;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointInJdbc {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			DatabaseMetaData dbmd = con.getMetaData();
			if (dbmd.supportsSavepoints()) {
				System.out
						.println("Savepoint supported by the driver and database");
				con.setAutoCommit(false);
				Statement stmt = con.createStatement();
				int k = stmt
						.executeUpdate("insert into dept values(15,'FF',9000)");
				Savepoint sp = con.setSavepoint("spoint");
				int m = stmt
						.executeUpdate("delete from student_info where sid=103");
				con.rollback(sp);
				con.commit();
				System.out.println("done");
				stmt.close();
			} else {
				System.out
						.println("save point is not supported by the driver and database");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
