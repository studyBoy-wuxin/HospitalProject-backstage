package com.hospital.Dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.entity.Prescription;

public interface PrescriptionDao {
	
	public int insertPrescription(Prescription pres);
	
	//根据DocInfoIDList找到对应Prescription的信息
	public ArrayList<Prescription> findPrescriptionByDocInfoIDList(List<Integer> DocInfoIDList);
	
	public int updatePresMes(Prescription pres);
	
	//通过PresID的List数组以及医生的DocID找到对应的病历单信息
	public List<Prescription> findAllPresMesPresIDList(@Param("list")List<Integer> presIDList,@Param("docInfoIDList")List<Integer> docInfoIDList);

	//通过病人ID找到未支付完成的病单
	public Prescription findUnPaidPresByPatID(int PatID) ;
}
