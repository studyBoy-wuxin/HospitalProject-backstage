package com.hospital.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Dao.EmployeeDao;
import com.hospital.entity.Employee_BasicInfo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee_BasicInfo findById(int id) {
		return employeeDao.findById(id);
	}
	
	public int UpdateEmployee(Employee_BasicInfo emp) {
		return employeeDao.UpdateEmployee(emp);
	}

}
