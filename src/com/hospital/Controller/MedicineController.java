package com.hospital.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.Service.MedInPrescriptionService;
import com.hospital.Service.MedicineService;
import com.hospital.entity.MedInPrescription;
import com.hospital.entity.Medicine;

@Controller
@RequestMapping("/MedicineController")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	@Autowired
	private MedInPrescriptionService medInPresService;
	
	@ResponseBody
	@RequestMapping("/findAllType")
	public List<String> findAllType() {
		List<String> TypeList = medicineService.findAllType();
		System.out.println(TypeList);
		return TypeList;
	}
	
	@ResponseBody
	@RequestMapping("/findMedicinesByType")
	public List<Medicine> findMedicinesByType(@RequestParam("Type")String type) {
		List<Medicine> findMedByType = medicineService.findMedicinesByType(type);
		System.out.println(findMedByType);
		return findMedByType;
	}
	
	@ResponseBody
	@RequestMapping("/findAllMedicines")
	public List<Medicine> findAllMedicines() {
		List<Medicine> medicines = medicineService.findAllMedicines();
		System.out.println(medicines);
		return medicines;
	}
	
	@ResponseBody
	@RequestMapping("/findMedInfoByPresID")
	public Object findMedInfoByPresID(@RequestParam("PresID") int PresID){
		List<MedInPrescription> medInPresList = medInPresService.findMedInPresByPresID(PresID);
		
		List<String> MedIDList = new ArrayList<>();
		for(int i=0;i<medInPresList.size();i++) {
			MedIDList.add(medInPresList.get(i).getMedID());
		}
		
		List<Medicine> medInfoList = medicineService.findMedInfoByMedIDList(MedIDList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("medInPresList", medInPresList);
		map.put("medInfoList", medInfoList);
		System.out.println(medInPresList);
		System.out.println(medInfoList);
		return map;
	}
	
	
	
	
}
