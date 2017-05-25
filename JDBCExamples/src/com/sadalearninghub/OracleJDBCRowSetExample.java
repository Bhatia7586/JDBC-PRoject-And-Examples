package com.sadalearninghub;

import javax.sql.RowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class OracleJDBCRowSetExample {
	public static void main(String[] args) {
		try {
			RowSet jrs = new OracleJDBCRowSet();
			jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			jrs.setUsername("system");
			jrs.setPassword("root");
			jrs.setCommand("select * from dept");
			jrs.execute();
			jrs.afterLast();
			System.out.println("printing in backward direction");
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
