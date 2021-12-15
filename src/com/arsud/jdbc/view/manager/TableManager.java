package com.arsud.jdbc.view.manager;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.arsud.jdbc.factory.AbsFactory;
import com.arsud.jdbc.factory.FactoryManager;
import com.arsud.jdbc.model.IModel;

public class TableManager {
	public static void clearRows(DefaultTableModel jtModel) {

		while (jtModel.getRowCount() > 0) {
			jtModel.removeRow(0);
		}

	}

	public static List<? extends IModel> fillRows(DefaultTableModel jtModel, AbsFactory<? extends IModel> factory,
			String sql, Object... objects) throws Exception {

		try {

			clearRows(jtModel);

			List<? extends IModel> modelList = FactoryManager.getFactorymgr().getFactory(factory.getClass())
					.getModelList(sql, objects);

			for (IModel iModel : modelList) {
				jtModel.addRow(iModel.toArray());
			}

			return modelList;

		} catch (Exception e) {
			throw new Exception();
		}

	}
}
