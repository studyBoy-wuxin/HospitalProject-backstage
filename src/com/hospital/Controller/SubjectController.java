package com.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.Service.SubjectService;
import com.hospital.entity.Doctor;
import com.hospital.entity.Subject;

@RequestMapping(value = "/SubjectController")
@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@ResponseBody
	@RequestMapping("/findAllSubject")
	public List<Subject> findAllSubject() {		
		List<Subject> findAllSubject =  subjectService.findAll();
		System.out.println(findAllSubject);		
		return findAllSubject;
	}
	
	@ResponseBody
	@RequestMapping("/findDoctorByBranchSubject")
	public List<Doctor> findDoctorByBranchSubject(@RequestParam("BranchSubject") String BranchSubject) {		
		System.out.println(BranchSubject);
		List<Doctor> doctor =  subjectService.findDoctorByBranchSubject(BranchSubject);
		System.out.println(doctor);		
		return doctor;
	}

}




