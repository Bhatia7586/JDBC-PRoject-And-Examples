package com.sadalearninghub;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectPicture {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sada", "root", "root");
			System.out.println("connection opened");
			PreparedStatement pstmt = con
					.prepareStatement("select e_photo from employee_info where eid=?");
			Scanner s = new Scanner(System.in);
			System.out.println("enter employee id: ");
			int eid = s.nextInt();
			pstmt.setInt(1, eid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			InputStream is = rs.getBinaryStream(1);
			FileOutputStream fos = new FileOutputStream(
					"E:\\\\photos\\\\test.gif");
			int b = 0;
			while ((b = is.read()) != -1) {
				fos.write(b);
			}
			System.out.println("image received, open it from rive E://");
			rs.close();
			fos.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
