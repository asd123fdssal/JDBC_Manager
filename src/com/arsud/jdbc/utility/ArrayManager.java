package com.arsud.jdbc.utility;

import java.util.List;

import com.arsud.jdbc.model.IModel;

public class ArrayManager {

	public static Object[][] convertList2ObjArray(List<? extends IModel> list) {
		return list.stream().map(u -> u.toArray()).toArray(Object[][]::new);
	}

}
