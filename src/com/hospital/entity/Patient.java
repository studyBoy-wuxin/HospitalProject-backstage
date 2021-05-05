package com.hospital.entity;

public class Patient {
	private int PatID;
	private String Name;
	private int Sex;
	private int Age;
	private String Password;
	private String Birth;
	private String IdentityCard;
	private String telephone;
	private String CardURL;	
	private String Address;
	
	public Patient() {};
	
	/**
	 * @param id
	 * @param name
	 * @param sex
	 * @param age
	 * @param password
	 * @param birth
	 * @param identityCard
	 * @param telephone
	 * @param card_URL
	 */
	public Patient(int PatID, String name, int sex, int age, String password, String birth, String identityCard,
			String telephone, String CardURL,String Address) {
		super();
		this.PatID = PatID;
		this.Name = name;
		this.Sex = sex;
		this.Age = age;
		this.Password = password;
		this.Birth = birth;
		this.IdentityCard = identityCard;
		this.telephone = telephone;
		this.CardURL = CardURL;
		this.Address = Address;
	}
	
	
	public int getPatID() {
		return PatID;
	}
	public void setPatID(int patID) {
		PatID = patID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getSex() {
		return Sex;
	}
	public void setSex(int sex) {
		Sex = sex;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getIdentityCard() {
		return IdentityCard;
	}
	public void setIdentityCard(String identityCard) {
		IdentityCard = identityCard;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}		
	public String getCardURL() {
		return CardURL;
	}
	public void setCardURL(String cardURL) {
		CardURL = cardURL;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+PatID+"-"+Name+"-"+Sex+"-"+Age+"-"+Password+"-"+IdentityCard+"-"+telephone+"-"+Birth+"-"+CardURL+"-"+Address+"]";
	}	

}
