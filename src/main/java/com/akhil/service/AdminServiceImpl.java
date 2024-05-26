package com.akhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akhil.Exception.UserNotFoundException;
import com.akhil.Exception.WrongPasswordException;
import com.akhil.model.AdminCreds;
import com.akhil.model.AdminData;
import com.akhil.model.Admins;
import com.akhil.repo.IAdminRepo;
@Service
public class AdminServiceImpl implements IAdminServie {
	@Autowired
	private IAdminRepo repo;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public String savingData(Admins admin) {
		admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));
		return "Data saved of admin: "+repo.save(admin).getAdminName();	
	}

	@Override
	public Integer validateAdmin(AdminCreds adminCreds) {
		Admins admin = repo.findByAdminUserName(adminCreds.getAdminUserName());
		if(admin==null) {
			throw new UserNotFoundException("User Not Found with "+adminCreds.getAdminUserName());
//			 admin.getAdminPassword().equals(adminCreds.getAdminPassword()); 
		}
		if(!passwordEncoder.matches(adminCreds.getAdminPassword(), admin.getAdminPassword())) {
			throw new WrongPasswordException("User password was wrong");
		}
		return admin.getAdminId();
	}

	@Override
	public AdminData getAdminData(Integer adminId) {
		Admins admin = repo.findById(adminId).get();
		AdminData adminData=new AdminData();
		adminData.setAdminId(admin.getAdminId());
		adminData.setAdminName(admin.getAdminName());
		return adminData;
	}
	

}
