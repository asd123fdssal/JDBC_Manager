package com.arsud.jdbc.factory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.arsud.jdbc.factory.AbsFactory;
import com.arsud.jdbc.model.impl.User;

public class UserFactory extends AbsFactory<User> {

	@Override
	protected void bindModel(User model, ResultSet rs) {
		try {
			model.setId(rs.getInt(1));
			model.setUserid(rs.getString(2));
			model.setUserpw(rs.getString(3));
			model.setNickname(rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected User getModel(ResultSet rs) {
		User user = new User();
		bindModel(user, rs);
		return user;
	}

}
