package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.UserDetail;

public interface UserDetailDAO {

	public boolean addUserDetail(UserDetail userdetail);
	public boolean deleteUserDetail(UserDetail userdetail);
	public boolean updateUserDetail(UserDetail userdetail);
	
	public List<UserDetail> listUsers();
	public UserDetail getUserDetail(String userName);
	
}