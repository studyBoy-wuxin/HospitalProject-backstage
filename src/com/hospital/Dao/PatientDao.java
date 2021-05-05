package com.hospital.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.entity.Patient;

public interface PatientDao {

	//����id���Ҳ���ȫ����Ϣ
	public Patient findPatientById(int id);
	
	//����id���Ҳ��˵Ļ�����Ϣ
	public Patient findPatientBasicMesById(int PatID);
	
	//���������ҵ�����
	public Patient findPatientByName(String Name);

	//��������
	public int insertPatient(Patient pat);	
	
	//���²���
	public int UpdatePatient(Patient pat);	
	
	public List<Patient> findPatientBasicMesByPatID(List<Integer> PatID);
}
