package org.pausequafe.data.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.pausequafe.data.business.Item;
import org.pausequafe.data.business.ItemAttribute;
import org.pausequafe.data.business.ItemDetailed;
import org.pausequafe.data.business.Skill;
import org.pausequafe.misc.exceptions.PQEveDatabaseNotFound;
import org.pausequafe.misc.exceptions.PQSQLDriverNotFoundException;
import org.pausequafe.misc.exceptions.PQUserDatabaseFileCorrupted;
import org.pausequafe.misc.util.SQLConstants;

/**
 * A DAO that creates Item from the eve database 
 * 
 * @author Administrateur
 */
public class ItemDAO  extends AbstractSqlDAO{
	
	//////////////////////
	// protected fields //
	//////////////////////	
	private static ItemDAO instance;
	private HashMap<Integer, Item> memoryCache = new HashMap<Integer, Item>();
	
    /////////////////
    // constructor //
    /////////////////
	private ItemDAO(){
		super();
	}
	
	public static ItemDAO getInstance(){
		if (instance == null){
			instance = new ItemDAO();
		}
		return instance;
	}
	
	////////////////////
    // public methods //
    ////////////////////
//	public List<Item> findItemsById(List<Integer> list) throws PQSQLDriverNotFoundException, PQUserDatabaseFileCorrupted, PQEveDatabaseNotFound{
//		ArrayList<Item> result = new ArrayList<Item>();
//		List<Integer> toBeQueried = new ArrayList<Integer>();
//		
//		// get items from cache 
//		Item anItem;
//		for(Integer anItemIndex : list){
//			anItem = memoryCache.get(anItemIndex);
//			if(anItem == null){
//				toBeQueried.add(anItemIndex);
//			} else {
//				result.add(anItem);
//			}
//		}
//		
//		// get missing items from database
//		
//		for(Integer typeID : toBeQueried){
//			result.add(findItemById(typeID)); 
//		}
//		
//		return result;
//	}
	

	
	public Item findItemById(int typeIDrequired) throws  PQSQLDriverNotFoundException, PQUserDatabaseFileCorrupted, PQEveDatabaseNotFound {
		
		Item askedItem = memoryCache.get(typeIDrequired);
		
		if(askedItem != null){
			return askedItem;
		}
		
		File db = new File(SQLConstants.EVE_DATABASE_FILE);
		if(!db.exists()){
			throw new PQEveDatabaseNotFound();
		}
		initConnection(SQLConstants.EVE_DATABASE);

		String query = SQLConstants.QUERY_TYPES_BY_ID.replace("?", "" + typeIDrequired);
		//System.out.println(query); // for convenience : uncomment to see DB queries

		try {
			ResultSet res = stat.executeQuery(query);
			while(res.next()){
				Integer itemId = res.getInt(SQLConstants.TYPEID_COL);
				askedItem = memoryCache.get(itemId);
				if(askedItem == null){
								
					askedItem = new Item(itemId,
							res.getString(SQLConstants.TYPENAME_COL),
							res.getInt(SQLConstants.METAGROUPID_COL));

					memoryCache.put(askedItem.getTypeID(), askedItem);
				}

				int attributeID = res.getInt(SQLConstants.ATTRIBUTEID_COL);

				switch(attributeID){
				case SQLConstants.REQUIRED_SKILL_1_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(1).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_2_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(2).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_3_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(3).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_1_LEVEL_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(1).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_2_LEVEL_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(2).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_3_LEVEL_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(3).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.METALEVEL_ATTID : 
					askedItem.setMetaLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
				default : break;
				}
			}
			res.close();


		} catch (SQLException e) {
			throw new PQUserDatabaseFileCorrupted();
		}
		return askedItem;
	}

public Skill findSkillById(int typeIDrequired) throws  PQSQLDriverNotFoundException, PQUserDatabaseFileCorrupted, PQEveDatabaseNotFound {
		
		Skill askedSkill = null;
		
		File db = new File(SQLConstants.EVE_DATABASE_FILE);
		if(!db.exists()){
			throw new PQEveDatabaseNotFound();
		}
		initConnection(SQLConstants.EVE_DATABASE);

		String query = SQLConstants.QUERY_TYPES_BY_ID.replace("?", "" + typeIDrequired);
		//System.out.println(query); // for convenience : uncomment to see DB queries

		try {
			ResultSet res = stat.executeQuery(query);
			while(res.next()){
				Integer itemId = res.getInt(SQLConstants.TYPEID_COL);
				if(askedSkill == null){
								
					askedSkill = new Skill(itemId, res.getString(SQLConstants.TYPENAME_COL));

					memoryCache.put(askedSkill.getTypeID(), askedSkill);
				}

				int attributeID = res.getInt(SQLConstants.ATTRIBUTEID_COL);

				switch(attributeID){
				case SQLConstants.REQUIRED_SKILL_1_ATTID : 
					askedSkill.youDontWantToKnowWhatThisIs(1).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_2_ATTID : 
					askedSkill.youDontWantToKnowWhatThisIs(2).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_3_ATTID : 
					askedSkill.youDontWantToKnowWhatThisIs(3).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_1_LEVEL_ATTID : 
					askedSkill.youDontWantToKnowWhatThisIs(1).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_2_LEVEL_ATTID : 
					askedSkill.youDontWantToKnowWhatThisIs(2).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_3_LEVEL_ATTID : 
					askedSkill.youDontWantToKnowWhatThisIs(3).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.RANK_ATTID : 
					askedSkill.setRank(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
				default : break;
				}
			}
			res.close();


		} catch (SQLException e) {
			throw new PQUserDatabaseFileCorrupted();
		}
		return askedSkill;
	}
	
	
	
	public ItemDetailed getItemDetails(Item baseItem) throws PQUserDatabaseFileCorrupted, PQEveDatabaseNotFound, PQSQLDriverNotFoundException{
		
		File db = new File(SQLConstants.EVE_DATABASE_FILE);
		if(!db.exists()){
			throw new PQEveDatabaseNotFound();
		}
		initConnection(SQLConstants.EVE_DATABASE);

		int typeIDrequired = baseItem.getTypeID();
		String query = SQLConstants.QUERY_ITEM_DETAILS_BY_ID.replace("?", "" + typeIDrequired);
		//System.out.println(query); // for convenience : uncomment to see DB queries

		ItemDetailed askedItem = null;
		
		try {
			ResultSet res = stat.executeQuery(query);
			while(res.next()){
				if(askedItem == null){
					String description = res.getString(SQLConstants.DESCRIPTION_COL).replaceAll("\n", "<br>");
					description = description.replaceAll("\t", "<br>");
					
					askedItem = new ItemDetailed(res.getInt(SQLConstants.TYPEID_COL),
															res.getString(SQLConstants.TYPENAME_COL),
															res.getString(SQLConstants.ICON_COL),
															description,
															res.getDouble(SQLConstants.BASEPRICE_COL),
															res.getDouble(SQLConstants.RADIUS_COL),
															res.getDouble(SQLConstants.MASS_COL),
															res.getDouble(SQLConstants.VOLUME_COL),
															res.getDouble(SQLConstants.CAPACITY_COL),
															res.getInt(SQLConstants.METAGROUPID_COL));
				}

				int attributeID = res.getInt(SQLConstants.ATTRIBUTEID_COL);

				switch(attributeID){
				case SQLConstants.REQUIRED_SKILL_1_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(1).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_2_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(2).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_3_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(3).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_1_LEVEL_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(1).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_2_LEVEL_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(2).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.REQUIRED_SKILL_3_LEVEL_ATTID : 
					askedItem.youDontWantToKnowWhatThisIs(3).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
					break;
				case SQLConstants.METALEVEL_ATTID : 
					askedItem.setMetaLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
				default : 
					String attributeName = res.getString(SQLConstants.ATTRIBUTE_NAME_COL);
					String attributeCategory = res.getString(SQLConstants.ATTRIBUTE_CATEGORY_COL);
					double attributeValue = res.getDouble(SQLConstants.ATTRIBUTE_VALUE_COL);
					String unit = res.getString(SQLConstants.UNIT_COL);
					int unitID = res.getInt(SQLConstants.UNITID_COL);
					ItemAttribute attribute = new ItemAttribute(attributeName, attributeCategory, attributeValue, unit, unitID);
					askedItem.addAttribute(attribute);
				}
			}
			res.close();


		} catch (SQLException e) {
			throw new PQUserDatabaseFileCorrupted();
		}
		return askedItem;
		
	}
	
	/////////////////////
	// private methods //
	/////////////////////
	
	/*private List<Item> queryItemsById(List<Integer> toBeQueried) throws  PQSQLDriverNotFoundException, PQDatabaseFileCorrupted, PQEveDatabaseNotFound {
		List<Item> result = new ArrayList<Item>();
		
		File db = new File(SQLConstants.EVE_DATABASE_FILE);
		if(!db.exists()){
			throw new PQEveDatabaseNotFound();
		}
		initConnection(SQLConstants.EVE_DATABASE);

		String inClause = "";
		boolean first = true;
		for(Integer typeID : toBeQueried){
			if(first){
				first = false;
			} else {
				inClause += ",";
			}
			inClause += typeID;
		}
		String query = SQLConstants.QUERY_TYPES_BY_ID;
		query = query.replace("?", inClause);
		//System.out.println(query); // for convenience : uncomment to see DB queries
		
		try {
			ResultSet res = stat.executeQuery(query);
			Item newItem = null;
			while(res.next()){
				Integer itemId = res.getInt(SQLConstants.TYPEID_COL);
				newItem = memoryCache.get(itemId);
				if(newItem == null){
					newItem = new Item(itemId,
							res.getString(SQLConstants.TYPENAME_COL),
							res.getString(SQLConstants.DESCRIPTION_COL),
							res.getFloat(SQLConstants.BASEPRICE_COL),
							res.getFloat(SQLConstants.RADIUS_COL),
							res.getFloat(SQLConstants.MASS_COL),
							res.getFloat(SQLConstants.VOLUME_COL),
							res.getFloat(SQLConstants.CAPACITY_COL)				
					);

					memoryCache.put(newItem.getTypeID(), newItem);
					result.add(newItem);
				}
				
				int attributeID = res.getInt(SQLConstants.ATTRIBUTEID_COL);

				switch(attributeID){
					case SQLConstants.REQUIRED_SKILL_1_ATTID : 
						newItem.youDontWantToKnowWhatThisIs(1).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
						break;
					case SQLConstants.REQUIRED_SKILL_2_ATTID : 
						newItem.youDontWantToKnowWhatThisIs(2).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
						break;
					case SQLConstants.REQUIRED_SKILL_3_ATTID : 
						newItem.youDontWantToKnowWhatThisIs(3).setTypeID(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
						break;
					case SQLConstants.REQUIRED_SKILL_1_LEVEL_ATTID : 
						newItem.youDontWantToKnowWhatThisIs(1).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
						break;
					case SQLConstants.REQUIRED_SKILL_2_LEVEL_ATTID : 
						newItem.youDontWantToKnowWhatThisIs(2).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
						break;
					case SQLConstants.REQUIRED_SKILL_3_LEVEL_ATTID : 
						newItem.youDontWantToKnowWhatThisIs(3).setRequiredLevel(res.getInt(SQLConstants.ATTRIBUTE_VALUE_COL));
						break;
					default : 
						String attributeName = res.getString(SQLConstants.ATTRIBUTE_NAME_COL);
						String attributeCategory = res.getString(SQLConstants.ATTRIBUTE_CATEGORY_COL);
						float attributeValue = res.getFloat(SQLConstants.ATTRIBUTE_VALUE_COL);
						ItemAttribute attribute = new ItemAttribute(attributeName, attributeCategory, attributeValue);
						newItem.addAttribute(attribute);
				}
				
			}
			res.close();
		} catch (SQLException e) {
			throw new PQDatabaseFileCorrupted();
		}
		return result;
	}*/
}
