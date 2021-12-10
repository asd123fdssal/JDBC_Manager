package com.arsud.jdbc.controller.user;

import java.util.List;

import com.arsud.jdbc.factory.FactoryManager;
import com.arsud.jdbc.factory.impl.UserFactory;
import com.arsud.jdbc.model.User;

public class SelectAllUser {

	public SelectAllUser(User user) {
		try {
			List<User> userList = ((UserFactory) FactoryManager.getFactorymgr().getFactory("UserFactory"))
					.getModelList("select * from user");
			System.out.println(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
