package com.ecomm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.UserDetail;

@Controller
public class RegisterController {

	@Autowired
	UserDetailDAO userdetailDAO;
	
	@RequestMapping(value="/newuser")
	public String addNewUser(@RequestParam("emailId")String emailId,@RequestParam("userName")String userName,@RequestParam("password")String password,@RequestParam("address")String address,@RequestParam("mobileNo")String mobileNo,@RequestParam("role")String role,Model m) {
		
		
		List<UserDetail> listUsers = userdetailDAO.listUsers();
		
		ArrayList<String> userNames = new ArrayList<String>();
		for(UserDetail user : listUsers)
		{
			userNames.add(user.getUserName());
		}
		
		if(userNames.contains(userName))
		{
			m.addAttribute("error"," !..Username may exist Please select another..!");
			return "Register";
		}
		else 
		{
			UserDetail userDetail = new UserDetail();
			
			userDetail.setEmailId(emailId);
			userDetail.setUserName(userName);
			userDetail.setPassword(password);
			userDetail.setAddress(address);
			userDetail.setMobileNo(mobileNo);
			userDetail.setRole(role);
			userDetail.setEnabled(true);
			
			userdetailDAO.addUserDetail(userDetail);
			
			return "RegisterSuccessfull";
		}
		
		
		
	}
}
