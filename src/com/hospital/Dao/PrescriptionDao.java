package com.hospital.Dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.entity.Prescription;

public interface PrescriptionDao {
	
	public int insertPrescription(Prescription pres);
	
	//����DocInfoIDList�ҵ���ӦPrescription����Ϣ
	public ArrayList<Prescription> findPrescriptionByDocInfoIDList(List<Integer> DocInfoIDList);
	
	public int updatePresMes(Prescription pres);
	
	//ͨ��PresID��List�����Լ�ҽ����DocID�ҵ���Ӧ�Ĳ�������Ϣ
	public List<Prescription> findAllPresMesPresIDList(@Param("list")List<Integer> presIDList,@Param("docInfoIDList")List<Integer> docInfoIDList);

	//ͨ������ID�ҵ�δ֧����ɵĲ���
	public Prescription findUnPaidPresByPatID(int PatID) ;
}
