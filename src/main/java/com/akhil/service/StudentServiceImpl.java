package com.akhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akhil.Exception.UserNotFoundException;
import com.akhil.Exception.WrongPasswordException;
import com.akhil.model.StudentCreds;
import com.akhil.model.Students;
import com.akhil.repo.IStudentRepo;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo repo;
	
	private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	@Override
	public String savingData(Students student) {
		student.setStudentPassword(passwordEncoder.encode(student.getStudentPassword()));
		return "Data saved with student name: "+repo.save(student).getStudentName();
	}
	@Override
	public Integer validateStudent(StudentCreds studentCreds) {
		Students student=repo.findByStudentUserName(studentCreds.getStudentUserName());
		if(student ==null) {
			throw new UserNotFoundException("User Not Found with user Name: "+studentCreds.getStudentUserName());
//			return student.getStudentPassword().equals(studentCreds.getStudentPassword());
		}
		if(!passwordEncoder.matches(studentCreds.getStudentPassword(), student.getStudentPassword())) {
			throw new WrongPasswordException("User Password was Wrong");
		}
		return student.getStudentId();
	}
	

}
