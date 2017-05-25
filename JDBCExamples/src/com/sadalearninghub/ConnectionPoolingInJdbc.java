package com.sadalearninghub;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConnectionPoolingInJdbc {
	public static void main(String[] args) {
		try {
			OracleConnectionPoolDataSource ocp = new OracleConnectionPoolDataSource();
			ocp.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ocp.setUser("system");
			ocp.setPassword("root");

			PooledConnection pc = ocp.getPooledConnection();
			Connection proxyCon = pc.getConnection();
			System.out.println("connection opened");

			Statement stmt = proxyCon.createStatement();
			stmt.execute("create table student(no number(3), name varchar2(20))");
			System.out.println("table created");
			stmt.close();
			proxyCon.close();
			System.out.println("proxy connection closed");

			Connection proxycon2 = pc.getConnection();
			System.out.println("proxy connection2 is opened");
			Statement stmt2 = proxycon2.createStatement();
			int k = stmt2
					.executeUpdate("insert into student values(111,'AAA')");
			System.out.println(k + " rows are updated");
			stmt2.close();
			proxycon2.close();
			System.out.println("proxy connection 2 closed");
			pc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
