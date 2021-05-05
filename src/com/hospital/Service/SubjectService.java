package com.hospital.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.SubjectDao;
import com.hospital.entity.Doctor;
import com.hospital.entity.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;
	
	public List<Subject> findAll() {
		return subjectDao.findAll();
	}
	
	public List<Doctor> findDoctorByBranchSubject(String BranchSubject){
		return subjectDao.findDoctorByBranchSubject(BranchSubject);
	}

}
