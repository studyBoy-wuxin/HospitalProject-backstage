package com.hospital.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.PrescriptionDao;
import com.hospital.entity.Prescription;

@Service
public class PrescriptionService {
	
	@Autowired
	private PrescriptionDao prescriptionDao;

	public int insertPrescription(Prescription pres) {
		return prescriptionDao.insertPrescription(pres);
	}
	
	//根据DocID找到挂了该医生号的病历单
	public ArrayList<Prescription> findPrescriptionByDocInfoIDList(List<Integer> DocInfoIDList){
		return prescriptionDao.findPrescriptionByDocInfoIDList(DocInfoIDList);
	}
	
	public int updatePresMes(Prescription pres) {
		return prescriptionDao.updatePresMes(pres);
	}
	
	public List<Prescription> findAllPresMesPresIDList(List<Integer> presIDList,List<Integer> docInfoIDList){
		return prescriptionDao.findAllPresMesPresIDList(presIDList,docInfoIDList);
	}
	
	public Prescription findUnPaidPresByPatID(int PatID) {
		return prescriptionDao.findUnPaidPresByPatID(PatID);
	}
}
