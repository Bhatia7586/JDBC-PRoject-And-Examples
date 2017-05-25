package com.sadalearninghub;

import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class OracleCachedRowSetEx {
	public static void main(String[] args) {
		try {

			OracleCachedRowSet crs = new OracleCachedRowSet();
			CachedRowSet crs1 = new OracleCachedRowSet();
			ResultSet crs3 = new OracleCachedRowSet();

			crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			crs.setUsername("system");
			crs.setPassword("root");
			crs.setCommand("select * from dept");
			// make crs as updatable
			crs.setReadOnly(false);
			crs.execute();
			// move to last row
			crs.absolute(-1);
			crs.deleteRow();
			crs.acceptChanges();
			crs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
