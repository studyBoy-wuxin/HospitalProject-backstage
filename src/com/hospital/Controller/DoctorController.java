package com.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.Service.DoctorService;
import com.hospital.entity.Doctor;

@RequestMapping(value = "/DoctorController",params = {"type=doctor"})
@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@ResponseBody
	@RequestMapping("/findDocterById")
	public Doctor findDocterById(@RequestParam("DocID")int ID) {
		Doctor doctor = doctorService.findDocterById(ID);
		System.out.println(doctor);
		return doctor;
	}
	
	@ResponseBody
	@RequestMapping("/findDocterByName")
	public List<Doctor> findDocterByName(@RequestParam("DocName")String Name) {
		System.out.println(Name);
		List<Doctor> doctor = doctorService.findDocterByName("%"+Name+"%");
		System.out.println(doctor);
		return doctor;
	}

}
