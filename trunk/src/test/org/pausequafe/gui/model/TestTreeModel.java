package org.pausequafe.gui.model;

import org.pausequafe.data.business.MarketGroup;
import org.pausequafe.data.dao.MarketGroupDAO;
import org.pausequafe.gui.model.tree.MarketGroupElement;
import org.pausequafe.gui.model.tree.TreeElement;
import org.pausequafe.gui.model.tree.TreeModel;
import org.pausequafe.misc.exceptions.PQEveDatabaseNotFound;
import org.pausequafe.misc.exceptions.PQSQLDriverNotFoundException;
import org.pausequafe.misc.exceptions.PQUserDatabaseFileCorrupted;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QTreeView;

public class TestTreeModel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	QApplication.initialize(args);
		
		MarketGroup group=null;
		try {
			group = MarketGroupDAO.getInstance().findMarketGroupById(9);
		} catch (PQSQLDriverNotFoundException e) {
			e.printStackTrace();
		} catch (PQUserDatabaseFileCorrupted e) {
			e.printStackTrace();
		} catch (PQEveDatabaseNotFound e) {
			e.printStackTrace();
		}
		TreeElement root = new MarketGroupElement(group);
		TreeModel ships = new TreeModel(root);
		
		QTreeView view = new QTreeView();
		view.setModel(ships);
		view.show();
		QApplication.exec();
	}

}
