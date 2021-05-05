package com.hospital.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.entity.Patient;

public interface PatientDao {

	//根据id查找病人全部信息
	public Patient findPatientById(int id);
	
	//根据id查找病人的基本信息
	public Patient findPatientBasicMesById(int PatID);
	
	//根据名字找到病人
	public Patient findPatientByName(String Name);

	//新增病人
	public int insertPatient(Patient pat);	
	
	//更新病人
	public int UpdatePatient(Patient pat);	
	
	public List<Patient> findPatientBasicMesByPatID(List<Integer> PatID);
}
