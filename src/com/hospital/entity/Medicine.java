package com.hospital.entity;

public class Medicine {
	private String MedID;
	private String type;
	private String MedName;
	private double Price;
	//说明
	private String Description;
	//库存
	private int Inventory;
	//过期日期
	private String OverdueDate;
	private String Address;
		
	public Medicine() {};
	
	/**
	 * @param medID
	 * @param type
	 * @param medName
	 * @param price
	 * @param explanation
	 * @param inventory
	 * @param overdueDate
	 * @param adress
	 */
	public Medicine(String medID, String type, String medName, double price, String description, int inventory,
			String overdueDate, String address) {
		super();
		MedID = medID;
		this.type = type;
		MedName = medName;
		this.Price = price;
		this.Description = description;
		Inventory = inventory;
		OverdueDate = overdueDate;
		Address = address;
	}




	public String getMedID() {
		return MedID;
	}
	public void setMedID(String MedID) {
		this.MedID = MedID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMedName() {
		return MedName;
	}
	public void setMedName(String medName) {
		MedName = medName;
	}	
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getInventory() {
		return Inventory;
	}
	public void setInventory(int inventory) {
		Inventory = inventory;
	}
	public String getOverdueDate() {
		return OverdueDate;
	}
	public void setOverdueDate(String overdueDate) {
		OverdueDate = overdueDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAdress(String address) {
		Address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+MedID+" , "+type+" , "+MedName+" , "+Price+" , "+Description+" , "+Inventory+" , "+OverdueDate+" , "+Address+"]";
	}
	

}
