package com.akhil.service;

import com.akhil.model.StudentCreds;
import com.akhil.model.Students;

public interface IStudentService {
	String savingData(Students student);
	Integer validateStudent(StudentCreds studentCreds);
}
