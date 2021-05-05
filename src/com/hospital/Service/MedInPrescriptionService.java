package com.hospital.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.MedInPrescriptionDao;
import com.hospital.entity.MedInPrescription;

@Service
public class MedInPrescriptionService {
	
	@Autowired
	private MedInPrescriptionDao dao;
	
	public int insert(MedInPrescription MIP) {
		return dao.insert(MIP);
	}
	
	public int insertPresMedList(List<MedInPrescription> list) {
		return dao.insertPresMedList(list);
	}
	
	public List<MedInPrescription> findMedInPresByPresID(int PresID){
		return dao.findMedInPresByPresID(PresID);
	}

	public List<Integer> findAllPresID(){
		return dao.findAllPresID();
	}
}
