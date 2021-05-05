package com.hospital.entity;

public class Doctor {
	
	private int DocID;
	private String Name;
	//学历
	private String Qualification;
	//分支学科
	private String BranchSubject;
	//职位
	private String Position;
	private String Department;
	private String Introduce;
	
	public Doctor() {};
				
	/**
	 * @param docID
	 * @param name
	 * @param qualification
	 * @param branchSubject
	 * @param position
	 * @param department
	 * @param introduce
	 */
	public Doctor(int docID, String name, String qualification, String branchSubject, String position,
			String department, String introduce) {
		super();
		DocID = docID;
		Name = name;
		Qualification = qualification;
		BranchSubject = branchSubject;
		Position = position;
		Department = department;
		Introduce = introduce;
	}

	public int getDocID() {
		return DocID;
	}

	public void setDocID(int docID) {
		DocID = docID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getBranchSubject() {
		return BranchSubject;
	}

	public void setBranchSubject(String branchSubject) {
		BranchSubject = branchSubject;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
	
	public String getIntroduce() {
		return Introduce;
	}

	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+DocID+"-"+Name+"-"+Qualification+"-"+BranchSubject+"-"+Position+"-"+Department+"-"+Introduce+"]";
	}
	
	
	

}
