package com.akhil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.model.AdminCreds;
import com.akhil.model.AdminData;
import com.akhil.model.Admins;
import com.akhil.model.StudentCreds;
import com.akhil.model.Students;
import com.akhil.service.AdminServiceImpl;
import com.akhil.service.StudentServiceImpl;

@RestController
public class UserServiceController {
	@Autowired
	private StudentServiceImpl studentService;
	@Autowired
	private AdminServiceImpl adminService;
	
	@GetMapping("/")
	public ResponseEntity<String> demo(){
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}
	
	@PostMapping("/student/signup")
	public ResponseEntity<String> studentSignup(@RequestBody Students student){
		return new ResponseEntity<>(studentService.savingData(student),HttpStatus.OK);
	}
	
	@PostMapping("/admin/save")
	public ResponseEntity<String> saveAdmin(@RequestBody Admins admin){
		return new ResponseEntity<>(adminService.savingData(admin),HttpStatus.OK);
	}
	
	@PostMapping("/admin/login")
	public ResponseEntity<Integer> adminLogin(@RequestBody AdminCreds admin){
		return new ResponseEntity<>(adminService.validateAdmin(admin),HttpStatus.OK);
	}
	@GetMapping("/adminData/{adminId}")
	public ResponseEntity<AdminData> getAdminData(@PathVariable Integer adminId){
		return new ResponseEntity<>(adminService.getAdminData(adminId),HttpStatus.OK);
	}
	@PostMapping("/student/login")
	public ResponseEntity<Integer> studentLogin(@RequestBody StudentCreds student){
		return new ResponseEntity<>(studentService.validateStudent(student),HttpStatus.OK);
	}

}
