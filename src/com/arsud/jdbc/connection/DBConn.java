package com.arsud.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.arsud.jdbc.config.DBCfg;

public class DBConn {

	private static final DBConn instance = new DBConn();
	public Connection connection;

	public DBConn() {
		connectDB();
	}

	private void connectDB() {
		try {
			Class.forName(DBCfg.DRIVER);
			connection = DriverManager.getConnection(DBCfg.URL + DBCfg.DB_NAME + DBCfg.PARAM, DBCfg.ID, DBCfg.PW);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBConn getInstance() {
		return instance;
	}

	public Connection getConnection() {
		try {
			if (connection == null) {
				new DBConn();
			}
			if (connection.isClosed()) {
				JdbcUtil.close(connection);
				this.connectDB();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
