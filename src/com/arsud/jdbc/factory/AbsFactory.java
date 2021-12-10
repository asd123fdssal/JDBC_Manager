package com.arsud.jdbc.factory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.arsud.jdbc.connection.DBManager;

public abstract class AbsFactory<T> {

	protected String name = this.getClass().getSimpleName();
	
	public List<T> getModelList(String sql, Object... objects) throws Exception {
		ArrayList<T> modelList = new ArrayList<>();

		try (DBManager dbMgr = DBManager.getDBManagers()) {
			ResultSet rs = dbMgr.getResultSet(sql, objects);

			while (rs.next()) {
				modelList.add(getModel(rs));
			}

		} catch (Exception e) {
			throw e;
		}

		return modelList;
	}
	protected abstract void bindModel(T model, ResultSet rs);

	protected abstract T getModel(ResultSet rs);

}
