package org.pausequafe.data.business;

public class ItemAttribute {
	
	
	private String attributeName;
	private String attributeCategory;
	private double value;
	private String unit;
	private int unitID;
	
	
	public ItemAttribute(String attributeName, String attributeCategory, double value, String unit, int unitID) {
		this.attributeName = attributeName;
		this.attributeCategory = attributeCategory;
		this.unit = unit;
		this.value = value;
		this.setUnitID(unitID);
	}

	
	
	public String getAttributeName() {
		return attributeName;
	}

	public String getAttributeCategory() {
		return attributeCategory;
	}

	public double getValue() {
		return value;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public void setAttributeCategory(String attributeCategory) {
		this.attributeCategory = attributeCategory;
	}

	public void setValue(double value) {
		this.value = value;
	}



	public String getUnit() {
		return unit;
	}



	public void setUnit(String unit) {
		this.unit = unit;
	}



	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}



	public int getUnitID() {
		return unitID;
	}
}
