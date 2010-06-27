######################################################################
# Automatically generated by qmake (2.01a) dim. 27. juin 18:01:48 2010
######################################################################

TEMPLATE = app
TARGET = PauseQuafe 
DEPENDPATH += . \
              resources \
              src \
              src/core \
              src/core/dao \
              src/core/factory \
              src/core/parsers \
              src/core/threads \
              src/data/character \
              src/data/item \
              src/data/misc \
              src/misc/exceptions \
              src/misc/util \
              src/gui/model/browsers \
              src/gui/model/characters \
              src/gui/view/browsers \
              src/gui/view/character \
              src/gui/view/main \
              src/gui/view/misc \
              src/gui/view/skillplans
INCLUDEPATH += src \
    ui
UI_DIR = ui
win32:RC_FILE = resources/appIcons/pq.rc
ICON = resources/appIcons/PauseQuafeMac.icns

# Input
HEADERS += src/core/CharacterController.h \
           src/core/PQCore.h \
           src/core/dao/AbstractSqlDAO.h \
           src/core/dao/ItemDAO.h \
           src/core/dao/MarketGroupDAO.h \
           src/core/dao/MonitoredCharacterDAO.h \
           src/core/dao/SkillPlanDAO.h \
           src/core/dao/UserDatabaseDAO.h \
           src/core/factory/CharacterListFactory.h \
           src/core/factory/CharacterSheetFactory.h \
           src/core/factory/ServerStatusFactory.h \
           src/core/factory/SkillInTrainingFactory.h \
           src/core/factory/SkillQueueFactory.h \
           src/core/parsers/CharacterListParser.h \
           src/core/parsers/CharacterSheetParser.h \
           src/core/parsers/ServerStatusParser.h \
           src/core/parsers/SkillInTrainingParser.h \
           src/core/parsers/SkillQueueParser.h \
           src/core/threads/ApiRequest.h \
           src/core/threads/ServerStatusRequest.h \
           src/data/character/APIData.h \
           src/data/character/Attribute.h \
           src/data/character/AttributeEnhancer.h \
           src/data/character/CharacterSheet.h \
           src/data/character/CharacterSkill.h \
           src/data/character/MonitoredCharacter.h \
           src/data/character/SkillInQueue.h \
           src/data/character/SkillInTraining.h \
           src/data/character/SkillPlan.h \
           src/data/character/SkillQueue.h \
           src/data/item/Blueprint.h \
           src/data/item/BlueprintDetailed.h \
           src/data/item/BPActivity.h \
           src/data/item/BPRequiredMaterial.h \
           src/data/item/Item.h \
           src/data/item/ItemAttribute.h \
           src/data/item/ItemDetailed.h \
           src/data/item/MarketGroup.h \
           src/data/item/PreRequisite.h \
           src/data/item/Skill.h \
           src/data/misc/ServerStatus.h \
           src/misc/exceptions/PQConfigException.h \
           src/misc/exceptions/PQConnectionException.h \
           src/misc/exceptions/PQEveDatabaseCorrupted.h \
           src/misc/exceptions/PQException.h \
           src/misc/exceptions/PQFileNotFoundException.h \
           src/misc/exceptions/PQParseException.h \
           src/misc/exceptions/PQSQLDriverNotFoundException.h \
           src/misc/exceptions/PQUserDatabaseFileCorrupted.h \
           src/misc/util/Constants.h \
           src/misc/util/CountdownTimer.h \
           src/misc/util/FileHandler.h \
           src/misc/util/Formatter.h \
           src/misc/util/Functions.h \
           src/misc/util/SQLConstants.h \
           src/gui/model/browsers/AttributesTableModel.h \
           src/gui/model/browsers/GroupElement.h \
           src/gui/model/browsers/ItemElement.h \
           src/gui/model/browsers/ItemPrerequisiteElement.h \
           src/gui/model/browsers/ItemTreeElement.h \
           src/gui/model/browsers/ItemTreeSortFilterProxyModel.h \
           src/gui/model/browsers/MarketGroupElement.h \
           src/gui/model/browsers/MaterialsTableModel.h \
           src/gui/model/browsers/SkillElement.h \
           src/gui/model/characters/CharaterSkillPlansProxyModel.h \
           src/gui/model/characters/MonitoredCharactersAndSkillPlansModel.h \
           src/gui/view/browsers/AbstractBrowserTab.h \
           src/gui/view/browsers/BrowserBlueprintTab.h \
           src/gui/view/browsers/BrowserItemTab.h \
           src/gui/view/browsers/BrowserShipTab.h \
           src/gui/view/browsers/BrowserSkillTab.h \
           src/gui/view/browsers/BrowsersWindow.h \
           src/gui/view/browsers/ItemTreeView.h \
           src/gui/view/character/CharacterInfo.h \
           src/gui/view/character/CharacterSkills.h \
           src/gui/view/character/CharacterTab.h \
           src/gui/view/character/SkillPlanListView.h \
           src/gui/view/main/AddCharacterDialog.h \
           src/gui/view/main/CharacterListDialog.h \
           src/gui/view/main/DeleteCharacterDialog.h \
           src/gui/view/main/MainWindow.h \
           src/gui/view/main/PQSystemTrayIcon.h \
           src/gui/view/main/SettingsDialog.h \
           src/gui/view/misc/AboutPQ.h \
           src/gui/view/misc/ErrorAPICorrupted.h \
           src/gui/view/misc/ErrorMessage.h \
           src/gui/view/misc/ErrorQuestion.h \
           src/gui/view/misc/Errors.h \
           src/gui/view/misc/StyleSheetEditor.h \
           src/gui/view/skillplans/AddSkillPlanDialog.h \
           src/gui/view/skillplans/SkillPlanView.h
FORMS += src/gui/view/browsers/BrowserBlueprintTab.ui \
         src/gui/view/browsers/BrowserItemTab.ui \
         src/gui/view/browsers/BrowserShipTab.ui \
         src/gui/view/browsers/BrowserSkillTab.ui \
         src/gui/view/browsers/BrowsersWindow.ui \
         src/gui/view/character/CharacterInfo.ui \
         src/gui/view/character/CharacterSkills.ui \
         src/gui/view/character/CharacterTab.ui \
         src/gui/view/character/SkillPlanListView.ui \
         src/gui/view/main/AddCharacterDialog.ui \
         src/gui/view/main/CharacterListDialog.ui \
         src/gui/view/main/DeleteCharacterDialog.ui \
         src/gui/view/main/MainWindow.ui \
         src/gui/view/main/SettingsDialog.ui \
         src/gui/view/misc/AboutPQ.ui \
         src/gui/view/misc/ErrorAPICorrupted.ui \
         src/gui/view/misc/ErrorMessage.ui \
         src/gui/view/misc/ErrorQuestion.ui \
         src/gui/view/misc/StyleSheetEditor.ui \
         src/gui/view/skillplans/AddSkillPlanDialog.ui \
         src/gui/view/skillplans/SkillPlanView.ui
SOURCES += src/main.cpp \
           src/core/CharacterController.cpp \
           src/core/PQCore.cpp \
           src/core/dao/AbstractSqlDAO.cpp \
           src/core/dao/ItemDAO.cpp \
           src/core/dao/MarketGroupDAO.cpp \
           src/core/dao/MonitoredCharacterDAO.cpp \
           src/core/dao/SkillPlanDAO.cpp \
           src/core/dao/UserDatabaseDAO.cpp \
           src/core/factory/CharacterListFactory.cpp \
           src/core/factory/CharacterSheetFactory.cpp \
           src/core/factory/ServerStatusFactory.cpp \
           src/core/factory/SkillInTrainingFactory.cpp \
           src/core/factory/SkillQueueFactory.cpp \
           src/core/parsers/CharacterListParser.cpp \
           src/core/parsers/CharacterSheetParser.cpp \
           src/core/parsers/ServerStatusParser.cpp \
           src/core/parsers/SkillInTrainingParser.cpp \
           src/core/parsers/SkillQueueParser.cpp \
           src/core/threads/ApiRequest.cpp \
           src/core/threads/ServerStatusRequest.cpp \
           src/data/character/APIData.cpp \
           src/data/character/AttributeEnhancer.cpp \
           src/data/character/CharacterSheet.cpp \
           src/data/character/CharacterSkill.cpp \
           src/data/character/MonitoredCharacter.cpp \
           src/data/character/SkillInQueue.cpp \
           src/data/character/SkillInTraining.cpp \
           src/data/character/SkillPlan.cpp \
           src/data/character/SkillQueue.cpp \
           src/data/item/Blueprint.cpp \
           src/data/item/BlueprintDetailed.cpp \
           src/data/item/BPActivity.cpp \
           src/data/item/BPRequiredMaterial.cpp \
           src/data/item/Item.cpp \
           src/data/item/ItemAttribute.cpp \
           src/data/item/ItemDetailed.cpp \
           src/data/item/MarketGroup.cpp \
           src/data/item/PreRequisite.cpp \
           src/data/item/Skill.cpp \
           src/data/misc/ServerStatus.cpp \
           src/misc/exceptions/PQConfigException.cpp \
           src/misc/exceptions/PQConnectionException.cpp \
           src/misc/exceptions/PQEveDatabaseCorrupted.cpp \
           src/misc/exceptions/PQException.cpp \
           src/misc/exceptions/PQFileNotFoundException.cpp \
           src/misc/exceptions/PQParseException.cpp \
           src/misc/exceptions/PQSQLDriverNotFoundException.cpp \
           src/misc/exceptions/PQUserDatabaseFileCorrupted.cpp \
           src/misc/util/CountdownTimer.cpp \
           src/misc/util/FileHandler.cpp \
           src/misc/util/Formatter.cpp \
           src/gui/model/browsers/AttributesTableModel.cpp \
           src/gui/model/browsers/GroupElement.cpp \
           src/gui/model/browsers/ItemElement.cpp \
           src/gui/model/browsers/ItemPrerequisiteElement.cpp \
           src/gui/model/browsers/ItemTreeElement.cpp \
           src/gui/model/browsers/ItemTreeSortFilterProxyModel.cpp \
           src/gui/model/browsers/MarketGroupElement.cpp \
           src/gui/model/browsers/MaterialsTableModel.cpp \
           src/gui/model/browsers/SkillElement.cpp \
           src/gui/model/characters/CharaterSkillPlansProxyModel.cpp \
           src/gui/model/characters/MonitoredCharactersAndSkillPlansModel.cpp \
           src/gui/view/browsers/AbstractBrowserTab.cpp \
           src/gui/view/browsers/BrowserBlueprintTab.cpp \
           src/gui/view/browsers/BrowserItemTab.cpp \
           src/gui/view/browsers/BrowserShipTab.cpp \
           src/gui/view/browsers/BrowserSkillTab.cpp \
           src/gui/view/browsers/BrowsersWindow.cpp \
           src/gui/view/browsers/ItemTreeView.cpp \
           src/gui/view/character/CharacterInfo.cpp \
           src/gui/view/character/CharacterSkills.cpp \
           src/gui/view/character/CharacterTab.cpp \
           src/gui/view/character/SkillPlanListView.cpp \
           src/gui/view/main/AddCharacterDialog.cpp \
           src/gui/view/main/CharacterListDialog.cpp \
           src/gui/view/main/DeleteCharacterDialog.cpp \
           src/gui/view/main/MainWindow.cpp \
           src/gui/view/main/PQSystemTrayIcon.cpp \
           src/gui/view/main/SettingsDialog.cpp \
           src/gui/view/misc/AboutPQ.cpp \
           src/gui/view/misc/ErrorAPICorrupted.cpp \
           src/gui/view/misc/ErrorMessage.cpp \
           src/gui/view/misc/ErrorQuestion.cpp \
           src/gui/view/misc/Errors.cpp \
           src/gui/view/misc/StyleSheetEditor.cpp \
           src/gui/view/skillplans/AddSkillPlanDialog.cpp \
           src/gui/view/skillplans/SkillPlanView.cpp
RESOURCES += resources/database.qrc \
             resources/icons_eve.qrc \
             resources/icons_pq.qrc \
             resources/stylesheets.qrc
