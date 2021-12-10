package com.arsud.jdbc.factory;

import java.util.ArrayList;
import java.util.List;

import com.arsud.jdbc.factory.impl.UserFactory;
import com.arsud.jdbc.model.IModel;

public class FactoryManager {

	private static final FactoryManager factoryMgr = new FactoryManager();

	private final List<AbsFactory<? extends IModel>> factorys = new ArrayList<AbsFactory<? extends IModel>>();

	public FactoryManager() {
		addFactory(new UserFactory());
	}

	private void addFactory(AbsFactory<? extends IModel> factory) {
		Boolean factoryFound = this.factorys.stream().anyMatch((it) -> it.getClass().equals(factory.getClass()));

		if (factoryFound) {
			throw new IllegalArgumentException("이미 존재하는 Factory 클래스 입니다.");
		}
		this.factorys.add(factory);
	}

	public AbsFactory<? extends IModel> getFactory(Class<?> classRef) {
		for (AbsFactory<? extends IModel> factory : this.factorys) {
			if (factory.getClass().equals(classRef)) {
				return factory;
			}
		}
		return null;
	}

	public static FactoryManager getFactorymgr() {
		return factoryMgr;
	}

}
