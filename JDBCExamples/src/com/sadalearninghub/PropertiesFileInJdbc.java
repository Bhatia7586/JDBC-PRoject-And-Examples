package com.sadalearninghub;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PropertiesFileInJdbc {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\MyEclipseworkspace\\JDBCExamples\\src\\com\\sadalearninghub\\ConnectionInfo.properties");
			Properties pros = new Properties();
			pros.load(fis);
			String driverClassName = pros.getProperty("k1");
			String url = pros.getProperty("k2");
			String userName = pros.getProperty("k3");
			String pwd = pros.getProperty("k4");
			Class.forName(driverClassName);
			Connection con = DriverManager.getConnection(url, userName, pwd);
			System.out.println("the driver loaded with " + driverClassName);
			System.out.println("connection is opened");
			con.close();
			System.out.println("connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
