package com.sadalearninghub;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class EventHandlingInRowset implements RowSetListener {

	int count1, count2, count3;

	EventHandlingInRowset() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			CachedRowSet crs = new CachedRowSetImpl();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			crs.setUsername("system");
			crs.setPassword("root");
			crs.addRowSetListener(this);
			crs.setCommand("select * from emp");
			crs.execute();

			crs.last();
			crs.absolute(3);
			crs.relative(-1);
			crs.beforeFirst();
			crs.absolute(4);

			crs.absolute(2);
			crs.updateString(2, "ABCD");
			crs.updateRow();

			crs.absolute(5);
			crs.updateString(2, "cs");
			crs.updateRow();
			crs.close();

			System.out.println("count1=" + count1);
			System.out.println("count2=" + count2);
			System.out.println("count3=" + count3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rowSetChanged(RowSetEvent arg0) {
		count1++;

	}

	@Override
	public void rowChanged(RowSetEvent arg0) {
		count2++;

	}

	@Override
	public void cursorMoved(RowSetEvent arg0) {
		count3++;

	}

	public static void main(String[] args) {
		new EventHandlingInRowset();

	}

}
