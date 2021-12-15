package com.arsud.jdbc.main;

import com.arsud.jdbc.controller.user.SelectAllUser;

public class ProjectMain {

	public static void main(String[] args) {
		try {
			new SelectAllUser().selectUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
