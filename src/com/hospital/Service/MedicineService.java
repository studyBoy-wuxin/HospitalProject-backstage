package com.hospital.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.MedicineDao;
import com.hospital.entity.Medicine;

@Service
public class MedicineService {

	@Autowired
	private MedicineDao medicineDao;
	
	public List<String> findAllType(){
		return medicineDao.findAllType();
	}
	
	public List<Medicine> findMedicinesByType(String Type){
		return medicineDao.findMedicinesByType(Type);
	}
	
	public List<Medicine> findAllMedicines(){
		return medicineDao.findAllMedicines();
	}
	
	public Medicine findMedByID(String MedID) {
		return medicineDao.findMedByID(MedID);
	}
	
	public int ReduceMedicine(String MedID,int newInventory) {
		return medicineDao.ReduceMedicine(MedID, newInventory);	
	}
	
	public List<Medicine> findMedInfoByMedIDList(List<String> MedID){
		return medicineDao.findMedInfoByMedIDList(MedID);
	}
}
