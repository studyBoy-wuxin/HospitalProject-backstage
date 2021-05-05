package com.hospital.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.Service.DoctorService;
import com.hospital.Service.MedInPrescriptionService;
import com.hospital.Service.MedicineService;
import com.hospital.Service.PatientService;
import com.hospital.Service.PrescriptionService;
import com.hospital.entity.Doctor;
import com.hospital.entity.MedInPrescription;
import com.hospital.entity.Medicine;
import com.hospital.entity.Patient;
import com.hospital.entity.Prescription;

@RequestMapping(value = "/PatientController",params = {"type=patient"})
@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	@Autowired
	private PrescriptionService presService;
	@Autowired
	private DoctorService docService;
	@Autowired
	private MedInPrescriptionService medInPresService;
	@Autowired
	private MedicineService medService;
	
	private String PatientPath="";
	
	//登录
	@ResponseBody
	@RequestMapping("/Login")
	public Object Login(Patient patient) {		
		Patient getPatientById =  patientService.findPatientById(patient.getPatID());
		System.out.println(patient);
		System.out.println(getPatientById);
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		if(getPatientById == null) {
			data.put("arg1", "用户名错误");
		}else {
			if(getPatientById.getPassword().equals(patient.getPassword())) {	
				data.put("arg1", "登陆成功");
				data.put("Patient", getPatientById);
			}else {					//如果输入的密码与数据库的不匹配，就返回false
				data.put("arg1", "密码错误");
			}	
		}	
		return data;
	}
	
	//根据Name寻找到病人
	@ResponseBody
	@RequestMapping("/findPatientByName")
	public Object findPatientByName(Patient pat) {		
		Patient getPatientByName =  patientService.findPatientByName(pat.getName());
		System.out.println(pat);
		System.out.println(getPatientByName);
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		if(getPatientByName == null) {
			data.put("arg1", "用户不存在");
		}else {
			data.put("arg1", "登录成功");
			data.put("Patient", getPatientByName);
		}	
		return data;
	}
	
	//根据id寻找到病人的全部信息
	@ResponseBody
	@RequestMapping("/findPatientById")
	public Patient findPatientById(Patient pat) {
		Patient patient =  patientService.findPatientById(pat.getPatID());
		System.out.println(pat);
		System.out.println(patient);
		return patient;
	}
	
	//根据id寻找到病人的基本信息
	@ResponseBody
	@RequestMapping("/findPatientBasicMesById")
	public Patient findPatientBasicMesById(@RequestParam("PatID")int PatID) {
		Patient patient =  patientService.findPatientBasicMesById(PatID);
		System.out.println(patient);
		return patient;
	}
	
	
	
	//根据id寻找到病人的需要缴纳费用的信息
	@ResponseBody
	@RequestMapping("/findCostById")
	public Object findCostById(@RequestParam("PatID")int PatID) {
			
		Prescription pres = presService.findUnPaidPresByPatID(PatID);
		//通过病单中的医生ID找到医生信息
//		Doctor doc = docService.findDocterById(pres.getDocID());
		//通过PresID来找到该病单包含的药物信息
		List<MedInPrescription> medInPresList = medInPresService.findMedInPresByPresID(pres.getPresID());
		//获取到MedID列表
		List<String> MedIDList = new ArrayList<>();
		for(int i=0;i<medInPresList.size();i++) {
			MedIDList.add(medInPresList.get(i).getMedID());
		}
		//通过MedID列表来找到药品的信息
		List<Medicine> medInfoList = medService.findMedInfoByMedIDList(MedIDList);
		
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("docInfo", doc);
		map.put("medInfoList", medInfoList);
		map.put("presInfo", pres);
		map.put("medInPresList", medInPresList);
		
		return map;
	}
	
		
		
	//更新病人
	@ResponseBody
	@RequestMapping("/UpdatePatient")
	public String UpdatePatient(Patient pat) {		
		int flag =  patientService.UpdatePatient(pat);	
		System.out.println(pat);
		if(flag>0) {
			return "修改成功";
		}else {
			return "修改失败";
		}
	}
	
	//新增病人
	@ResponseBody
	@RequestMapping("/insertPatient")
	public String insertPatient(Patient pat) {
		
		pat.setCardURL(PatientPath);
		System.out.println(PatientPath);		
		System.out.println(pat);
		//调用service层的方法
		int flag =  patientService.insertPatient(pat);
		if(flag>0) {
			System.out.println("注册成功");
			return "注册成功";
		}else {
			System.out.println("注册失败");
			return "注册失败";
		}				
	}	
	//上传方法：使用IO流
		@RequestMapping(value="/upload")
		@ResponseBody
		public String Upload2(@RequestParam("Photo")MultipartFile file ,
								HttpServletRequest request,
								@RequestParam("userName")String userName) {
			try {
				//IO输入流
				InputStream inputStream =  file.getInputStream();
				//动态获取项目路径
				String path = request.getServletContext().getRealPath("/")+"WEB-INF\\"+userName+"\\";	//返回的是项目在服务器的绝对路径
				System.out.println("path:"+path);
				
				File file2 = new File(path);
				if(!file2.exists()) {
					file2.mkdir();				
				}
				//输出流可以指定把文件保存到哪里
				OutputStream outputStream = new FileOutputStream(path+file.getOriginalFilename());
				//字节流当缓冲区
				byte[] bs = new byte[1024];
				int len = -1;		//把输入流读到缓冲区	
				while((len=inputStream.read(bs)) != -1) {
					outputStream.write(bs,0,len);
				}	
				inputStream.close();
				outputStream.close();

				//把路径地址存到PatientPath属性中
				PatientPath = path;
				System.out.println("上传成功！");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "success";
		}
}
