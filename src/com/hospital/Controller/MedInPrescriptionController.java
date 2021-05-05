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
		System.out.println("已访问-----------------");
		System.out.println(pres);
		System.out.println(list);
		
		//首先，需要更新病历单信息
		int flag1 = presService.updatePresMes(pres);
		//其次，对病历单的药品栏添加药品
		int flag2 = medInPresService.insertPresMedList(list);
		//更新药品库存
		for(int i=0;i<list.size();i++) {
			String MedID = list.get(i).getMedID();
			//根据MedID找到库存后，减去用药量
			int newInventory = (int)medService.findMedByID(list.get(i).getMedID()).getInventory()-list.get(i).getMedNum();
			medService.ReduceMedicine(MedID,newInventory);
		}

		if(flag1 > 0 && flag2 > 0) {
			return "处方单已成功生成！";		
		}else {
			return "生成失败！";
		}		
	}
	
	@ResponseBody
	@RequestMapping("/findAllPresMesByPresIDList")
	public Object findAllPresMesByPresIDList(@RequestParam("DocID") int DocID){
		//先找到所有含有药物信息的PresID列表数组
		List<Integer> presIDList = medInPresService.findAllPresID();
		
		//如果此时没有任何已就诊完成的病历单，那么久返回Nothing (避免报错)
		if(presIDList.size() == 0) {
			return "Nothing";
		}
		
		List<Integer> docInfoIDList = docInfoService.findDocInfoIDListByDocID(DocID);

		//再根据DocID和presIDList来定位到----这个医生所完成的病历单
		List<Prescription> presMesList = presService.findAllPresMesPresIDList(presIDList,docInfoIDList);
		
		System.out.println(presMesList);
		
		List<Patient> patBasicMesList = new ArrayList<>();
		for(int i=0;i<presMesList.size();i++){
			patBasicMesList.add(patService.findPatientBasicMesById(presMesList.get(i).getPatID()));
		}
		System.out.println(patBasicMesList);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PresList", presMesList);
		//把病人ID的List传回去
		map.put("patBasicMesList", patBasicMesList);
		return map;
	}
	

}
