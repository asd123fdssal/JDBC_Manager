package com.arsud.jdbc.controller.user;

import java.util.List;

import com.arsud.jdbc.factory.FactoryManager;
import com.arsud.jdbc.factory.impl.UserFactory;
import com.arsud.jdbc.model.impl.User;

public class SelectAllUser {

	public List<User> selectUsers() throws Exception {
		try {
			List<User> userList = ((UserFactory) FactoryManager.getFactorymgr().getFactory(UserFactory.class))
					.getModelList("select * from user");
			return userList;
		} catch (Exception e) {
			throw e;
		}
	}

}
