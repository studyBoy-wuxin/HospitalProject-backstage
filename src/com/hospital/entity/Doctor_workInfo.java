package com.hospital.entity;

public class Doctor_workInfo {
	private int DocInfoID;
	private int DocID;
	private String TreatDate;
	private String TreatBegin;
	private String TreatEnd;
	private int TreatNum;
	private double Price;
	
	public Doctor_workInfo() {};
		
	/**
	 * @param iD
	 * @param docID
	 * @param treatDate
	 * @param treatBegin
	 * @param treatEnd
	 * @param treatNum
	 * @param price
	 */
	public Doctor_workInfo(int DocInfoID, int docID, String treatDate, String treatBegin, String treatEnd, int treatNum,
			double price) {
		super();
		DocInfoID = DocInfoID;
		DocID = docID;
		TreatDate = treatDate;
		TreatBegin = treatBegin;
		TreatEnd = treatEnd;
		TreatNum = treatNum;
		Price = price;
	}
	
	public int getDocInfoID() {
		return DocInfoID;
	}
	public void setDocInfoID(int docInfoID) {
		DocInfoID = docInfoID;
	}
	public int getDocID() {
		return DocID;
	}
	public void setDocID(int docID) {
		DocID = docID;
	}
	public String getTreatDate() {
		return TreatDate;
	}

	public void setTreatDate(String treatDate) {
		TreatDate = treatDate;
	}

	public String getTreatBegin() {
		return TreatBegin;
	}

	public void setTreatBegin(String treatBegin) {
		TreatBegin = treatBegin;
	}

	public String getTreatEnd() {
		return TreatEnd;
	}

	public void setTreatEnd(String treatEnd) {
		TreatEnd = treatEnd;
	}

	public int getTreatNum() {
		return TreatNum;
	}
	public void setTreatNum(int treatNum) {
		TreatNum = treatNum;
	}	
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+DocInfoID+" , "+
					DocID+" , "+
					TreatDate+" , "+
					TreatBegin+" , "+
					TreatEnd+" , "+
					TreatNum+" , "+
					Price+"]";
	}
	
	

}
