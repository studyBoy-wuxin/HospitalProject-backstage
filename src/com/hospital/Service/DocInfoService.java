package com.hospital.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.DocInfoDao;
import com.hospital.entity.Doctor_workInfo;

@Service
public class DocInfoService {
	
	@Autowired
	private DocInfoDao docInfoDao;

	public List<Doctor_workInfo> findAllInfoByDocID(int docId) {
		return docInfoDao.findAllInfoByDocID(docId);
	}
	
	public Doctor_workInfo findInfoByID(int ID) {
		return docInfoDao.findInfoByDocInfoID(ID);
	}
	
	public int updateTreatNum(int ID,int TreatNum) {
		return docInfoDao.updateTreatNum(ID,TreatNum);
	}
	
	public List<Integer> findDocInfoIDListByDocID(int docID){
		return docInfoDao.findDocInfoIDListByDocID(docID);
	}
}
