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
	
	//��¼
	@ResponseBody
	@RequestMapping("/Login")
	public Object Login(Patient patient) {		
		Patient getPatientById =  patientService.findPatientById(patient.getPatID());
		System.out.println(patient);
		System.out.println(getPatientById);
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		if(getPatientById == null) {
			data.put("arg1", "�û�������");
		}else {
			if(getPatientById.getPassword().equals(patient.getPassword())) {	
				data.put("arg1", "��½�ɹ�");
				data.put("Patient", getPatientById);
			}else {					//�����������������ݿ�Ĳ�ƥ�䣬�ͷ���false
				data.put("arg1", "�������");
			}	
		}	
		return data;
	}
	
	//����NameѰ�ҵ�����
	@ResponseBody
	@RequestMapping("/findPatientByName")
	public Object findPatientByName(Patient pat) {		
		Patient getPatientByName =  patientService.findPatientByName(pat.getName());
		System.out.println(pat);
		System.out.println(getPatientByName);
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		if(getPatientByName == null) {
			data.put("arg1", "�û�������");
		}else {
			data.put("arg1", "��¼�ɹ�");
			data.put("Patient", getPatientByName);
		}	
		return data;
	}
	
	//����idѰ�ҵ����˵�ȫ����Ϣ
	@ResponseBody
	@RequestMapping("/findPatientById")
	public Patient findPatientById(Patient pat) {
		Patient patient =  patientService.findPatientById(pat.getPatID());
		System.out.println(pat);
		System.out.println(patient);
		return patient;
	}
	
	//����idѰ�ҵ����˵Ļ�����Ϣ
	@ResponseBody
	@RequestMapping("/findPatientBasicMesById")
	public Patient findPatientBasicMesById(@RequestParam("PatID")int PatID) {
		Patient patient =  patientService.findPatientBasicMesById(PatID);
		System.out.println(patient);
		return patient;
	}
	
	
	
	//����idѰ�ҵ����˵���Ҫ���ɷ��õ���Ϣ
	@ResponseBody
	@RequestMapping("/findCostById")
	public Object findCostById(@RequestParam("PatID")int PatID) {
			
		Prescription pres = presService.findUnPaidPresByPatID(PatID);
		//ͨ�������е�ҽ��ID�ҵ�ҽ����Ϣ
//		Doctor doc = docService.findDocterById(pres.getDocID());
		//ͨ��PresID���ҵ��ò���������ҩ����Ϣ
		List<MedInPrescription> medInPresList = medInPresService.findMedInPresByPresID(pres.getPresID());
		//��ȡ��MedID�б�
		List<String> MedIDList = new ArrayList<>();
		for(int i=0;i<medInPresList.size();i++) {
			MedIDList.add(medInPresList.get(i).getMedID());
		}
		//ͨ��MedID�б����ҵ�ҩƷ����Ϣ
		List<Medicine> medInfoList = medService.findMedInfoByMedIDList(MedIDList);
		
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("docInfo", doc);
		map.put("medInfoList", medInfoList);
		map.put("presInfo", pres);
		map.put("medInPresList", medInPresList);
		
		return map;
	}
	
		
		
	//���²���
	@ResponseBody
	@RequestMapping("/UpdatePatient")
	public String UpdatePatient(Patient pat) {		
		int flag =  patientService.UpdatePatient(pat);	
		System.out.println(pat);
		if(flag>0) {
			return "�޸ĳɹ�";
		}else {
			return "�޸�ʧ��";
		}
	}
	
	//��������
	@ResponseBody
	@RequestMapping("/insertPatient")
	public String insertPatient(Patient pat) {
		
		pat.setCardURL(PatientPath);
		System.out.println(PatientPath);		
		System.out.println(pat);
		//����service��ķ���
		int flag =  patientService.insertPatient(pat);
		if(flag>0) {
			System.out.println("ע��ɹ�");
			return "ע��ɹ�";
		}else {
			System.out.println("ע��ʧ��");
			return "ע��ʧ��";
		}				
	}	
	//�ϴ�������ʹ��IO��
		@RequestMapping(value="/upload")
		@ResponseBody
		public String Upload2(@RequestParam("Photo")MultipartFile file ,
								HttpServletRequest request,
								@RequestParam("userName")String userName) {
			try {
				//IO������
				InputStream inputStream =  file.getInputStream();
				//��̬��ȡ��Ŀ·��
				String path = request.getServletContext().getRealPath("/")+"WEB-INF\\"+userName+"\\";	//���ص�����Ŀ�ڷ������ľ���·��
				System.out.println("path:"+path);
				
				File file2 = new File(path);
				if(!file2.exists()) {
					file2.mkdir();				
				}
				//���������ָ�����ļ����浽����
				OutputStream outputStream = new FileOutputStream(path+file.getOriginalFilename());
				//�ֽ�����������
				byte[] bs = new byte[1024];
				int len = -1;		//������������������	
				while((len=inputStream.read(bs)) != -1) {
					outputStream.write(bs,0,len);
				}	
				inputStream.close();
				outputStream.close();

				//��·����ַ�浽PatientPath������
				PatientPath = path;
				System.out.println("�ϴ��ɹ���");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "success";
		}
}
