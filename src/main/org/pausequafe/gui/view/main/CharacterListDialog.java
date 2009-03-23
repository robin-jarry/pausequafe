package org.pausequafe.gui.view.main;

import java.util.List;

import org.pausequafe.data.business.APIData;

import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QListWidget;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QWidget;

public class CharacterListDialog extends QDialog {

    Ui_CharacterListDialog ui = new Ui_CharacterListDialog();
    
    private QListWidget charListWidget;
    private QPushButton chooseButton;
    
    List<APIData> characterList;
    
    private int chosenCharacterIndex = -1;


    public CharacterListDialog(List<APIData> characterList) {
        this(null, characterList);
    }

    public CharacterListDialog(QWidget parent, List<APIData> characterList) {
        super(parent);
        this.characterList = characterList;
        setupUi();
    }
    
    private void setupUi(){
    	ui.setupUi(this);
    	charListWidget = (QListWidget) this.findChild(QListWidget.class, "charListWidget");
    	chooseButton = (QPushButton) this.findChild(QPushButton.class, "chooseButton");
    	chooseButton.clicked.connect(this, "accept()");
    	chooseButton.setEnabled(false);
    	
    	for(APIData character : characterList){
    		charListWidget.addItem(character.getCharacterName());
    	}
    	
    	charListWidget.currentRowChanged.connect(this, "updateIndex()");
    }
    
    @SuppressWarnings("unused")
	private void updateIndex(){
    	chosenCharacterIndex = charListWidget.currentIndex().row();
    	chooseButton.setEnabled(true);
    }
    
    public int getChosenCharacterIndex(){
    	return chosenCharacterIndex;
    }
}
