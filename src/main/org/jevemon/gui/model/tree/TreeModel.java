package org.jevemon.gui.model.tree;

import org.jevemon.misc.exceptions.JEVEMonException;

import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QTreeModel;

/**
 * This class implements a tree model that can be used to 
 * show items sorted by groups.
 *  
 * @author Gobi
 */
public class TreeModel extends QTreeModel {

	private TreeElement root = null;

	public TreeModel(TreeElement root){
		this.root = root;
	}

	@Override
	public Object child(Object parent, int index) {
		TreeElement treeElement; 
		if(parent==null){
			treeElement = root;
		} else {
			treeElement = (TreeElement) parent;
		}
		
		TreeElement child = null;
		try {
			child = treeElement.ChildAt(index);
		} catch (JEVEMonException e) {
			e.printStackTrace();
		}
		return child;
		
	}

	@Override
	public int childCount(Object parent) {
		TreeElement treeElement; 
		if(parent==null){
			treeElement = root;
		} else {
			treeElement = (TreeElement) parent;
		}
				
		return treeElement.childCount();
	}

	@Override
	public String text(Object value) {
		String s =((TreeElement) value).getName(); 
		return s;
	}

	@Override
	public Object data(Object value, int role){
		TreeElement elt = (TreeElement) value;

		Object result = null;
		switch(role){
		// text to display
		case ItemDataRole.DisplayRole    : result = text(value); break;
		// display font
		case ItemDataRole.FontRole       : result =  elt.getFont(); break;
		// the icon before the skills
		case ItemDataRole.DecorationRole : result =  elt.getIcon(); break;
		// tool tips on the skills
		case ItemDataRole.ToolTipRole    : result =  elt.getTooltip(); break;

		default : result = null;
		}
		
		return result;
	}

}
