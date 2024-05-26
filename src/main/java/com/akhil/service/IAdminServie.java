package com.akhil.service;

import com.akhil.model.AdminCreds;
import com.akhil.model.AdminData;
import com.akhil.model.Admins;

public interface IAdminServie {
	String savingData(Admins admin);
	Integer validateAdmin(AdminCreds adminCreds);
	AdminData getAdminData(Integer adminId);
}
