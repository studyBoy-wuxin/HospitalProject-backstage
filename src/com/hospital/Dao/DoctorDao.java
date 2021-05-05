package com.hospital.Dao;

import java.util.List;

import com.hospital.entity.Doctor;

public interface DoctorDao {
	
	public List<Doctor> findDocterByName(String Name);
	
	public Doctor findDocterById(int id) ;
		
	public int insertDoctor(Doctor doc);

}
