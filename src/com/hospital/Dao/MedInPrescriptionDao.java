package com.hospital.Dao;

import java.util.List;

import com.hospital.entity.MedInPrescription;

public interface MedInPrescriptionDao {

	public int insert(MedInPrescription MIP);
	
	public int insertPresMedList(List<MedInPrescription> list);
	
	//通过PresID来找到MedInPrescription信息
	public List<MedInPrescription> findMedInPresByPresID(int PresID);
	
	//找到所有不重复的有药物信息的病历单
	public List<Integer> findAllPresID();
}
