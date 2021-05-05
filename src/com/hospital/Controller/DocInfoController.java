package com.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.Service.DocInfoService;
import com.hospital.Service.PrescriptionService;
import com.hospital.entity.Doctor_workInfo;
import com.hospital.entity.Prescription;

@Controller
@RequestMapping("/DocInfoController")
public class DocInfoController {
	
	@Autowired
	private DocInfoService docInfoService;
	@Autowired
	private PrescriptionService prescriptionService;
	
	@ResponseBody
	@RequestMapping("/findAllInfoByDocID")
	public List<Doctor_workInfo> findAllInfoByDocID(@RequestParam("docId")int docId) {
		System.out.println(docId);
		List<Doctor_workInfo> info = docInfoService.findAllInfoByDocID(docId);
		System.out.println(info);
		return info;
	}
	
	//���ԤԼ��ʱ�򣬳�����Ҫ����һ�������������Ҫ��������������Ϣ
	@ResponseBody
	@RequestMapping("/updateTreatMes")
	public String updateTreatMes(@RequestParam("DocInfoID")int DocInfoID,@RequestParam("PatID")int PatID,@RequestParam("BookedTime")String BookedTime) {
		System.out.println(DocInfoID);
		//�ڸ�����������֮ǰ�Ȳ�ѯһ��ԭʼ���ݣ�Ȼ��-1
		Doctor_workInfo info = docInfoService.findInfoByID(DocInfoID);
		//�ж��Ƿ���³ɹ�
		int flag1 = docInfoService.updateTreatNum(DocInfoID,(info.getTreatNum()-1));
		//����һ�������������뱻ԤԼ��ҽ��ID�Լ�����ID
		Prescription pres = new Prescription(info.getDocInfoID(),PatID,BookedTime);
		//�ж��Ƿ����ɹ�
		int flag2 = prescriptionService.insertPrescription(pres);
		if(flag1 >0 && flag2 >0) {
			return "ԤԼ�ɹ�";
		}else {
			return "ԤԼʧ��";
		}		
	}

}
