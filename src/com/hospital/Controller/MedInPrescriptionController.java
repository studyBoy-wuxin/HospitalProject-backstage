package com.hospital.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.Service.DocInfoService;
import com.hospital.Service.MedInPrescriptionService;
import com.hospital.Service.MedicineService;
import com.hospital.Service.PatientService;
import com.hospital.Service.PrescriptionService;
import com.hospital.entity.MedInPrescription;
import com.hospital.entity.Patient;
import com.hospital.entity.Prescription;


@Controller
@RequestMapping("/MedInPrescriptionController")
public class MedInPrescriptionController {
	@Autowired
	private MedInPrescriptionService medInPresService;
	@Autowired
	private PrescriptionService presService;
	@Autowired
	private MedicineService medService;
	@Autowired
	private PatientService patService;
	@Autowired
	private DocInfoService docInfoService;
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insert( Prescription pres,@RequestBody List<MedInPrescription> list) {
		System.out.println("�ѷ���-----------------");
		System.out.println(pres);
		System.out.println(list);
		
		//���ȣ���Ҫ���²�������Ϣ
		int flag1 = presService.updatePresMes(pres);
		//��Σ��Բ�������ҩƷ�����ҩƷ
		int flag2 = medInPresService.insertPresMedList(list);
		//����ҩƷ���
		for(int i=0;i<list.size();i++) {
			String MedID = list.get(i).getMedID();
			//����MedID�ҵ����󣬼�ȥ��ҩ��
			int newInventory = (int)medService.findMedByID(list.get(i).getMedID()).getInventory()-list.get(i).getMedNum();
			medService.ReduceMedicine(MedID,newInventory);
		}

		if(flag1 > 0 && flag2 > 0) {
			return "�������ѳɹ����ɣ�";		
		}else {
			return "����ʧ�ܣ�";
		}		
	}
	
	@ResponseBody
	@RequestMapping("/findAllPresMesByPresIDList")
	public Object findAllPresMesByPresIDList(@RequestParam("DocID") int DocID){
		//���ҵ����к���ҩ����Ϣ��PresID�б�����
		List<Integer> presIDList = medInPresService.findAllPresID();
		
		//�����ʱû���κ��Ѿ�����ɵĲ���������ô�÷���Nothing (���ⱨ��)
		if(presIDList.size() == 0) {
			return "Nothing";
		}
		
		List<Integer> docInfoIDList = docInfoService.findDocInfoIDListByDocID(DocID);

		//�ٸ���DocID��presIDList����λ��----���ҽ������ɵĲ�����
		List<Prescription> presMesList = presService.findAllPresMesPresIDList(presIDList,docInfoIDList);
		
		System.out.println(presMesList);
		
		List<Patient> patBasicMesList = new ArrayList<>();
		for(int i=0;i<presMesList.size();i++){
			patBasicMesList.add(patService.findPatientBasicMesById(presMesList.get(i).getPatID()));
		}
		System.out.println(patBasicMesList);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PresList", presMesList);
		//�Ѳ���ID��List����ȥ
		map.put("patBasicMesList", patBasicMesList);
		return map;
	}
	

}
