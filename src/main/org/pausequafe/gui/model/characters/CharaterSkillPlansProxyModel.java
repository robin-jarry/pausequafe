package org.pausequafe.gui.model.characters;

import org.pausequafe.data.business.MonitoredCharacter;
import org.pausequafe.data.business.SkillPlan;

import com.trolltech.qt.core.QModelIndex;
import com.trolltech.qt.core.Qt.DropAction;
import com.trolltech.qt.core.Qt.DropActions;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.core.Qt.ItemFlag;
import com.trolltech.qt.core.Qt.ItemFlags;
import com.trolltech.qt.gui.QAbstractProxyModel;

public class CharaterSkillPlansProxyModel extends QAbstractProxyModel {


	/////////////
	// fields ///
	/////////////
	private MonitoredCharacter root=null;
	private MonitoredCharactersAndSkillPlansModel sourceModel=null;

	
	//////////////////
	// constructor ///
	//////////////////
	public CharaterSkillPlansProxyModel(MonitoredCharacter root) {
		super();
		this.root = root;
		try {
			this.sourceModel = MonitoredCharactersAndSkillPlansModel.getInstance();
			setSourceModel(sourceModel);
		} catch (Exception e) {
			// we don't really care because no exception 
			// can actually be returned at this point since
			// monitored characters have already been retrieved
			e.printStackTrace();
		}
	}
	
	/////////////////////
	// public methods ///
	/////////////////////
	public void createSkillPlan(String name) {
		int rowCount = rowCount(null);
		insertRow(rowCount, null);
		
		SkillPlan newSkillPlan = new SkillPlan(root.getApi().getCharacterID(),SkillPlan.NOID,rowCount,name);
		setData(index(rowCount,0,null) , newSkillPlan, ItemDataRole.DisplayRole);
	}

	public void deleteSkillPlan(int row) {
		int rowCount = rowCount(null);
		if(rowCount!=0){
			removeRow(row, null);
		}
	}
	
	//////////////////////////////
	// overridden proxy methods //
	//////////////////////////////
	@Override
	public QModelIndex mapFromSource(QModelIndex sourceIndex) {
		// source_to_proxy
		QModelIndex result = null;
		
		if(sourceIndex!=null && sourceIndex.parent()!=null
			&& sourceIndex.data().equals(root) )
		{
			result=index(sourceIndex.row(), sourceIndex.column(),null);
		} 
		
		return result;
	}

	@Override
	public QModelIndex mapToSource(QModelIndex proxyIndex) {
		QModelIndex result = null;
		
		if(proxyIndex != null) {
			result = sourceModel.index(
					proxyIndex.row(), proxyIndex.column(), 
					sourceModel.valueToIndex(root));
		} else {
			result = sourceModel.valueToIndex(root);
		}
		
		return result;
	}

	@Override
	public int columnCount(QModelIndex parent) {
		return 1;
	}

	@Override
	public int rowCount(QModelIndex parent) {
		int result = sourceModel.rowCount(mapToSource(parent));
		return result;
	}
	
	@Override
	public QModelIndex index(int row, int column, QModelIndex parent) {
		QModelIndex result = createIndex(row, column);
		return result;
	}

	@Override
	public QModelIndex parent(QModelIndex child) {
		return null;
	}
	
	//////////////////////////////
	// overridden D&D methods   //
	//////////////////////////////
	@Override
	public boolean insertRows(int row, int count, QModelIndex parent) {
		boolean result;
		
		beginInsertRows(parent, row, row+count-1);
		result = sourceModel.insertRows(row, count, mapToSource(parent));
		endInsertRows();
		
		return result;
	}
	
	@Override
	public boolean removeRows(int row, int count, QModelIndex parent) {
		boolean result;
		
		beginRemoveRows(parent, row, row+count-1);
		result = sourceModel.removeRows(row,count,mapToSource(parent));
		endRemoveRows();
		
		return result;
	}

	@Override
	public DropActions supportedDropActions() {
		DropActions result = new DropActions(DropAction.MoveAction);
		return result;
	}

	@Override
	public ItemFlags flags(QModelIndex index) {
		ItemFlags result = new ItemFlags();

		if (index == null){
			result.set(ItemFlag.ItemIsDropEnabled);
		} else {
			result.set(
					ItemFlag.ItemIsDragEnabled,
					ItemFlag.ItemIsEnabled,
					ItemFlag.ItemIsSelectable);
		}

		return result;
	}

}
