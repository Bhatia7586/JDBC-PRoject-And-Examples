package com.sadalearninghub;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

public class JdbcRowSetExample {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			JdbcRowSet jrs = new JdbcRowSetImpl();
			jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			jrs.setUsername("system");
			jrs.setPassword("root");
			jrs.setCommand("select * from employee");
			jrs.execute();
			jrs.afterLast();
			System.out.println("printing in backward");
			while (jrs.previous()) {
				System.out.println(jrs.getInt(1) + " : " + jrs.getString(2)
						+ " : " + jrs.getString(3));
			}
			jrs.absolute(3);
			System.out.println("printing 3rd row");
			System.out.println(jrs.getInt(1) + " : " + jrs.getString(2) + " : "
					+ jrs.getString(3));
			jrs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
