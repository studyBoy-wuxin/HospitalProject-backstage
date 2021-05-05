package com.hospital.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.DoctorDao;
import com.hospital.entity.Doctor;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorDao doctorDao;
	
	public List<Doctor> findDocterByName(String Name) {
		return doctorDao.findDocterByName(Name);
	}

	public Doctor findDocterById(int id) {
		return doctorDao.findDocterById(id);
	}
}
