package com.hospital.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MedInPrescription {
	private Integer ID;
	@JsonProperty( "PresID")
	private Integer PresID;
	@JsonProperty( "MedID")
	private String MedID;
	@JsonProperty( "MedNum")
	private Integer MedNum;
	
	public MedInPrescription() {}
	
	
	/**
	 * @param iD
	 * @param presID
	 * @param medID
	 * @param medNum
	 */
	public MedInPrescription(Integer iD, Integer presID, String medID, Integer medNum) {
		super();
		ID = iD;
		PresID = presID;
		MedID = medID;
		MedNum = medNum;
	}


	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getMedID() {
		return MedID;
	}
	public void setMedID(String medID) {
		MedID = medID;
	}		
	public Integer getPresID() {
		return PresID;
	}
	public void setPresID(Integer presID) {
		PresID = presID;
	}
	public Integer getMedNum() {
		return MedNum;
	}
	public void setMedNum(Integer medNum) {
		MedNum = medNum;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+ID+" , "+PresID+" , "+MedID+" , "+MedNum+"]";
	}

}
