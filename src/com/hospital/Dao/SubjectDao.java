package com.hospital.Dao;

import java.util.List;

import com.hospital.entity.Doctor;
import com.hospital.entity.Subject;

public interface SubjectDao {

	public List<Subject> findAll();
	
	public List<Doctor> findDoctorByBranchSubject(String BranchSubject);
}
