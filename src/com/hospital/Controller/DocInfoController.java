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
	
	//点击预约的时候，除了需要更新一次治疗名额，还需要新增处方单的信息
	@ResponseBody
	@RequestMapping("/updateTreatMes")
	public String updateTreatMes(@RequestParam("DocInfoID")int DocInfoID,@RequestParam("PatID")int PatID,@RequestParam("BookedTime")String BookedTime) {
		System.out.println(DocInfoID);
		//在更新治疗名额之前先查询一次原始数据，然后-1
		Doctor_workInfo info = docInfoService.findInfoByID(DocInfoID);
		//判断是否更新成功
		int flag1 = docInfoService.updateTreatNum(DocInfoID,(info.getTreatNum()-1));
		//创建一个处方单，传入被预约的医生ID以及病人ID
		Prescription pres = new Prescription(info.getDocInfoID(),PatID,BookedTime);
		//判断是否插入成功
		int flag2 = prescriptionService.insertPrescription(pres);
		if(flag1 >0 && flag2 >0) {
			return "预约成功";
		}else {
			return "预约失败";
		}		
	}

}
