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

import com.hospital.Service.DocInfoService;
import com.hospital.Service.PatientService;
import com.hospital.Service.PrescriptionService;
import com.hospital.entity.Patient;
import com.hospital.entity.Prescription;

//处方单控制器
@Controller
@RequestMapping("/PrescriptionController")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	@Autowired
	private DocInfoService docInfoService;
	@Autowired
	private PatientService patientService;

	@ResponseBody
	@RequestMapping("/insertPrescription")
	public String insertPrescription(Prescription pres) {
		System.out.println(pres);
		int flag = prescriptionService.insertPrescription(pres);
		if(flag>0) {
			return "success";
		}else {
			return "false";
		}		
	}
	
	//查询与该医生有关的处方单
	@ResponseBody
	@RequestMapping("/findPrescriptionByDocID")
	public Object findPrescriptionByDocID(@RequestParam("DocID")int DocID) {	
		Map<String, Object> map = new HashMap<String, Object>();
		//先通过DocID找到所有的排班信息的ID
		List<Integer> DocInfoIDList = docInfoService.findDocInfoIDListByDocID(DocID);
		System.out.println(DocInfoIDList);
		//通过排版ID找到对应的病单
		ArrayList<Prescription> PresList =  prescriptionService.findPrescriptionByDocInfoIDList(DocInfoIDList);	
		System.out.println(PresList);
		//如果此时还没有任何人来预约此医生，那么就返回Nothing (避免报错)
		if(PresList.size() == 0) {
			return "Nothing";
		}
		
		ArrayList<Patient> patBasicMesList = new ArrayList<Patient>();
		for(int i = 0;i<PresList.size();i++) {			
			patBasicMesList.add(patientService.findPatientBasicMesById(PresList.get(i).getPatID()));
		}
		map.put("PresList", PresList);
		map.put("patBasicMesList", patBasicMesList);
		System.out.println(map);

		return map;
	}
	
}
