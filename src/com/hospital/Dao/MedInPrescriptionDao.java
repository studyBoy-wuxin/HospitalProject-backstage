package com.hospital.Dao;

import java.util.List;

import com.hospital.entity.MedInPrescription;

public interface MedInPrescriptionDao {

	public int insert(MedInPrescription MIP);
	
	public int insertPresMedList(List<MedInPrescription> list);
	
	//ͨ��PresID���ҵ�MedInPrescription��Ϣ
	public List<MedInPrescription> findMedInPresByPresID(int PresID);
	
	//�ҵ����в��ظ�����ҩ����Ϣ�Ĳ�����
	public List<Integer> findAllPresID();
}
