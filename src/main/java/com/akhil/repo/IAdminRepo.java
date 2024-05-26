package com.akhil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.model.Admins;

public interface IAdminRepo extends JpaRepository<Admins, Integer> {
	Admins findByAdminUserName(String username);
}
