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
		
		Employee_BasicInfo getEmpByID = employeeService.findById(emp.getEmpID());		//根据上传来的信息查找这个ID的医生
		System.out.println(emp);
		System.out.println(getEmpByID);
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		if(getEmpByID == null) {
			data.put("arg1", "用户名错误");
		}else {
			if(getEmpByID.getPassword().equals(emp.getPassword())) {	
				data.put("arg1", "登陆成功");
				data.put("Employee", getEmpByID);
			}else {					//如果输入的密码与数据库的不匹配，就返回false
				data.put("arg1", "密码错误");
			}	
		}
		return data;
	}
	
	//更新员工
	@ResponseBody
	@RequestMapping("/UpdateEmployee")
	public String UpdateEmployee(Employee_BasicInfo emp) {		
		int flag =  employeeService.UpdateEmployee(emp);	
		System.out.println(emp);
		if(flag>0) {
			return "修改成功";
		}else {
			return "修改失败";
		}
	}
	

}
