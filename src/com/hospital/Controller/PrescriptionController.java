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

//������������
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
	
	//��ѯ���ҽ���йصĴ�����
	@ResponseBody
	@RequestMapping("/findPrescriptionByDocID")
	public Object findPrescriptionByDocID(@RequestParam("DocID")int DocID) {	
		Map<String, Object> map = new HashMap<String, Object>();
		//��ͨ��DocID�ҵ����е��Ű���Ϣ��ID
		List<Integer> DocInfoIDList = docInfoService.findDocInfoIDListByDocID(DocID);
		System.out.println(DocInfoIDList);
		//ͨ���Ű�ID�ҵ���Ӧ�Ĳ���
		ArrayList<Prescription> PresList =  prescriptionService.findPrescriptionByDocInfoIDList(DocInfoIDList);	
		System.out.println(PresList);
		//�����ʱ��û���κ�����ԤԼ��ҽ������ô�ͷ���Nothing (���ⱨ��)
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
