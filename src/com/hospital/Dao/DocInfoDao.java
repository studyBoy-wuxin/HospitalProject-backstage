package com.hospital.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.entity.Doctor_workInfo;

public interface DocInfoDao {
	
	public List<Doctor_workInfo> findAllInfoByDocID(int docId);
	
	public Doctor_workInfo findInfoByDocInfoID(int DocInfoID);
	
	public int updateTreatNum(@Param("DocInfoID")int DocInfoID,@Param("TreatNum")int TreatNum) ;

	public List<Integer> findDocInfoIDListByDocID(int docID);
}
