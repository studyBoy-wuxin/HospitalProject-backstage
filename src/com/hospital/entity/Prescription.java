package com.hospital.entity;

//处方单(将医生与病人关联的中间表)DocName PatName TreatmentTime DoctorSuggestion Medicines
public class Prescription {
	private Integer PresID;
	private int DocInfoID;
	private int PatID;
	private String TreatmentTime;
	private String DoctorSuggestion;
	private double TotalPrice;	
	
	private String BookedTime;
	private int Status;
	
	
	public Prescription() {};
	

	/**
	 * @param docID
	 * @param patID
	 * @param bookedTime
	 */
	public Prescription(int DocInfoID, int patID, String bookedTime) {
		super();
		this.DocInfoID = DocInfoID;
		PatID = patID;
		BookedTime = bookedTime;
	}

	


	/**
	 * @param presID
	 * @param docID
	 * @param patID
	 * @param treatmentTime
	 * @param doctorSuggestion
	 * @param totalPrice
	 * @param medicines
	 * @param bookedTime
	 * @param status
	 */
	public Prescription(Integer presID, int DocInfoID, int patID, String treatmentTime, String doctorSuggestion,
			double totalPrice,  String bookedTime, int status) {
		super();
		PresID = presID;
		DocInfoID = DocInfoID;
		PatID = patID;
		TreatmentTime = treatmentTime;
		DoctorSuggestion = doctorSuggestion;
		TotalPrice = totalPrice;

		BookedTime = bookedTime;
		Status = status;
	}


	public Integer getPresID() {
		return PresID;
	}
	public void setPresID(Integer presID) {
		PresID = presID;
	}	
	public int getDocInfoID() {
		return DocInfoID;
	}
	public void setDocInfoID(int docInfoID) {
		DocInfoID = docInfoID;
	}
	public int getPatID() {
		return PatID;
	}
	public void setPatID(int patID) {
		PatID = patID;
	}
	public String getTreatmentTime() {
		return TreatmentTime;
	}
	public void setTreatmentTime(String treatmentTime) {
		TreatmentTime = treatmentTime;
	}
	public String getDoctorSuggestion() {
		return DoctorSuggestion;
	}
	public void setDoctorSuggestion(String doctorSuggestion) {
		DoctorSuggestion = doctorSuggestion;
	}
	public double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(double totalprice) {
		TotalPrice = totalprice;
	}
	
	public String getBookedTime() {
		return BookedTime;
	}
	public void setBookedTime(String bookedTime) {
		BookedTime = bookedTime;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+PresID+" , "+DocInfoID+" , "+PatID+" , "+TreatmentTime+" , "+DoctorSuggestion+" , "+TotalPrice+" , "+BookedTime+" , "+Status+" , "+"]";
	}

}
