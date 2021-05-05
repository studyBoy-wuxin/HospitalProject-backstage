package com.hospital.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.Service.EmployeeService;
import com.hospital.entity.Employee_BasicInfo;
import com.hospital.entity.Patient;

@RequestMapping(value = "/EmployeeController")
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ResponseBody
	@RequestMapping("/Login")
	public Object Login(Employee_BasicInfo emp) {
		
		Employee_BasicInfo getEmpByID = employeeService.findById(emp.getEmpID());		//�����ϴ�������Ϣ�������ID��ҽ��
		System.out.println(emp);
		System.out.println(getEmpByID);
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		if(getEmpByID == null) {
			data.put("arg1", "�û�������");
		}else {
			if(getEmpByID.getPassword().equals(emp.getPassword())) {	
				data.put("arg1", "��½�ɹ�");
				data.put("Employee", getEmpByID);
			}else {					//�����������������ݿ�Ĳ�ƥ�䣬�ͷ���false
				data.put("arg1", "�������");
			}	
		}
		return data;
	}
	
	//����Ա��
	@ResponseBody
	@RequestMapping("/UpdateEmployee")
	public String UpdateEmployee(Employee_BasicInfo emp) {		
		int flag =  employeeService.UpdateEmployee(emp);	
		System.out.println(emp);
		if(flag>0) {
			return "�޸ĳɹ�";
		}else {
			return "�޸�ʧ��";
		}
	}
	

}
