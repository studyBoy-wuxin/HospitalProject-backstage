package com.hospital.entity;

public class Subject {
	private int ID;
	private String MainSubject;
	private String BranchSubject;
	private String Address;
	
	
	
	/**
	 * @param iD
	 * @param mainSubject
	 * @param branchSubject
	 * @param address
	 */
	public Subject(int iD, String mainSubject, String branchSubject, String address) {
		super();
		ID = iD;
		MainSubject = mainSubject;
		BranchSubject = branchSubject;
		Address = address;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMainSubject() {
		return MainSubject;
	}
	public void setMainSubject(String mainSubject) {
		MainSubject = mainSubject;
	}
	public String getBranchSubject() {
		return BranchSubject;
	}
	public void setBranchSubject(String branchSubject) {
		BranchSubject = branchSubject;
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
		return "["+ID+"-"+MainSubject+"-"+BranchSubject+"-"+Address+"]";
	}

}
