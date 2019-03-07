package com.ecomm.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.UserDetail;

@Controller
public class UserController {

	@Autowired
	UserDetailDAO userdetailDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully...");
		}
		model.setViewName("Login");
		
		return model;

	}
	
	@RequestMapping(value="/login_success")
	public String loginSuccess(Model m,HttpSession session) {
		
		String page="";
		
		Boolean loggedIn=false;
		SecurityContext securitycontext = SecurityContextHolder.getContext();
		Authentication authentication = securitycontext.getAuthentication();
		
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>)authentication.getAuthorities();

		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role",role.getAuthority());
			if(role.getAuthority().equals("USER"))
			{
				loggedIn=true;
				
				page="redirect:/productdisplay";
				m.addAttribute("productlist",productDAO.listProducts());
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
			}
			else
			{
				loggedIn=true;
				page="AdminPage";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
			}
		}
		return page;
	}
	
	@RequestMapping(value="/userprofile")
	public String showUserProfilePage(HttpSession session,Model m) {
		String userName = (String) session.getAttribute("username");
		UserDetail userDetail = userdetailDAO.getUserDetail(userName);
		m.addAttribute("userDetail",userDetail);
		return "UserProfile";
	}
	
	@RequestMapping(value="/edituserdetail/{userName}")
	public String editUserDetails(HttpSession session,Model m,@PathVariable("userName")String userName) {
		
		UserDetail userDetail = userdetailDAO.getUserDetail(userName);
		m.addAttribute("userDetail",userDetail);
		
		return "UpdateUser";
	}
	@RequestMapping(value="/updateuserdetail",method=RequestMethod.POST)
	public String updateUserDetails(@RequestParam("uname")String userName,@RequestParam("mobno")String mobileNo,@RequestParam("address")String address,Model m) {
		
		UserDetail userDetail = userdetailDAO.getUserDetail(userName);
		userDetail.setMobileNo(mobileNo);
		userDetail.setAddress(address);
		
		userdetailDAO.updateUserDetail(userDetail);
		m.addAttribute("userDetail",userDetail);
		return "UserProfile";
	}
}