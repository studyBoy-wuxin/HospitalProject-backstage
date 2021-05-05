package com.hospital.Dao;

import com.hospital.entity.Employee_BasicInfo;

public interface EmployeeDao {
		
	public Employee_BasicInfo findById(int id);
	
	public int insertEmp(Employee_BasicInfo emp);
	
	public int UpdateEmployee(Employee_BasicInfo emp);

}
