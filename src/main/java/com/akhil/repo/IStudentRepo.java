package com.akhil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.model.Students;

public interface IStudentRepo extends JpaRepository<Students, Integer> {
	Students findByStudentUserName(String username);
}
