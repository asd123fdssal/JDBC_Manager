package com.arsud.jdbc.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager implements AutoCloseable{

	private static DBManager DBManagers = new DBManager();

	private PreparedStatement pstmt;
	private ResultSet rs;

	public DBManager() {

	}

	private PreparedStatement getPstmt(String sql, Object... objects) {
		try {
			pstmt = DBConn.getInstance().getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			for (int i = 0; i < objects.length; i++) {
				pstmt.setObject(i + 1, objects[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public int updateSQL(String sql, Object... objects) {
		pstmt = getPstmt(sql, objects);
		try {
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public ResultSet getResultSet(String sql, Object... objects) {
		try {
			rs = getPstmt(sql, objects).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void close() {
		JdbcUtil.close(rs, pstmt);
	}

	public static DBManager getDBManagers() {
		return DBManagers;
	}

}
