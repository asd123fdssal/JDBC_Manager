package com.arsud.jdbc.controller.user;

import com.arsud.jdbc.connection.DBManager;
import com.arsud.jdbc.model.impl.User;

public class AddUser {

	public AddUser(User user) {
		try (DBManager dbMgr = DBManager.getDBManagers()) {
			String sql = "insert into values(0,?,?,?)";
			dbMgr.updateSQL(sql, user.getUserid(), user.getUserpw(), user.getNickname());
		} catch (Exception e) {
			throw e;
		}
	}

}
