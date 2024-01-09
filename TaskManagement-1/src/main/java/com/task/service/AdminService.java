package com.task.service;

import com.task.entities.Admin;

public interface AdminService {
	String saveAdmin(Admin admin);
	String updateAdmin(int adminid, Admin admin);
	String updatePassword(int adminid, String password);
	Admin getAdmin(String username);

}
