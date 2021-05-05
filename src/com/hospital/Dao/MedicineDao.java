package com.hospital.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.entity.Medicine;

public interface MedicineDao {
	
	public List<String> findAllType();
	
	public List<Medicine> findMedicinesByType(String Type);
	
	public List<Medicine> findAllMedicines();
	
	public Medicine findMedByID(String MedID);
	
	public int ReduceMedicine(@Param("MedID")String MedID,@Param("newInventory")int newInventory);

	public List<Medicine> findMedInfoByMedIDList(List<String> MedID);

}
