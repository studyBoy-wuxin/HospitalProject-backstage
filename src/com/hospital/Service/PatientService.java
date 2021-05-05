package com.hospital.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.PatientDao;
import com.hospital.entity.Patient;

@Service
public class PatientService {
	
	@Autowired
	private PatientDao patientDao;
	
	//����ID���Ҳ���ȫ����Ϣ
	public Patient findPatientById(int id) {
		return patientDao.findPatientById(id);
	}
	
	public Patient findPatientBasicMesById(int PatID) {
		return patientDao.findPatientBasicMesById(PatID);
	}
	
	//���Ӳ���
	public int insertPatient(Patient pat) {
		return patientDao.insertPatient(pat);	
	}
	
	//�������ֲ���
	public Patient findPatientByName(String Name) {
		return patientDao.findPatientByName(Name);
	}
		
	//���²���
	public int UpdatePatient(Patient pat) {
		return patientDao.UpdatePatient(pat);
	}
	
	public List<Patient> findPatientBasicMesByPatID(List<Integer> PatID){
		return patientDao.findPatientBasicMesByPatID(PatID);
	}


}
