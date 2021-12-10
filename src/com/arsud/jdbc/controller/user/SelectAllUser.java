package com.arsud.jdbc.controller.user;

import java.util.List;

import com.arsud.jdbc.factory.FactoryManager;
import com.arsud.jdbc.factory.impl.UserFactory;
import com.arsud.jdbc.model.impl.User;

public class SelectAllUser {

	public SelectAllUser() {
		try {
			List<User> userList = ((UserFactory) FactoryManager.getFactorymgr().getFactory(UserFactory.class))
					.getModelList("select * from user");
			userList.stream().forEach(it -> System.out.println(it.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
