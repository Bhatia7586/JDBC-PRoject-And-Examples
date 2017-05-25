package com.sadalearninghub;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertPicture {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection opened");
			PreparedStatement pstmt = con
					.prepareStatement("insert into employee_info values(?,?,?)");
			Scanner s = new Scanner(System.in);
			System.out.println("enter employee id: ");
			int eid = s.nextInt();
			System.out.println("enter employee name: ");
			String ename = s.next();
			System.out.println("enter photo path: ");
			String path = s.next();

			pstmt.setInt(1, eid);
			pstmt.setString(2, ename);

			File f = new File(path);
			FileInputStream fis = new FileInputStream(f);
			int size = (int) f.length();
			pstmt.setBinaryStream(3, fis, size);
			int k = pstmt.executeUpdate();
			System.out.println(k + " rows inserted");

			pstmt.close();
			con.close();

			System.out.println("connection closed");
		} catch (Exception e) {
		}
	}
}
