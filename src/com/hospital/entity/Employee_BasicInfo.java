package com.hospital.entity;

public class Employee_BasicInfo {

	private int EmpID;
	private String Name;
	private int Sex;
	private int Age;
	private String Birth;
	private String Password;
	private String Department;
	private String Telephone;
	private String Address;
	
	public Employee_BasicInfo() {};
	
	/**
	 * @param empID
	 * @param name
	 * @param sex
	 * @param age
	 * @param birth
	 * @param password
	 * @param department
	 * @param telephone
	 * @param adress
	 */
	public Employee_BasicInfo(int empID, String name, int sex, int age, String birth, String password,
			String department, String telephone, String address) {
		super();
		EmpID = empID;
		Name = name;
		Sex = sex;
		Age = age;
		Birth = birth;
		Password = password;
		Department = department;
		Telephone = telephone;
		Address = address;
	}

	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
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
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}		
	 public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
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
		return "["+EmpID+", "+Name+", "+Sex+", "+Age+", "+Birth+", "+Password+", "+Department+", "+Telephone+", "+Address+"]";
	}
	
	
}
