package com.ecomm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.UserDetail;

@Controller
public class OrderController {

	@Autowired
	CartItemDAO cartItemDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@Autowired
	UserDetailDAO userdetailDAO;
	
	@RequestMapping(value="/checkout")
	public String checkOutProcess(HttpSession session,Model m) {
		
		String userName = (String) session.getAttribute("username");
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);

		m.addAttribute("cartitems",listCartItems);
		m.addAttribute("totalCartAmount",this.calTotalCartAmount(listCartItems));
		
		return "MyOrder";
	}
	
	@RequestMapping(value="/payment")
	public String paymentProcess(HttpSession session,Model m) {
		
		String userName = (String) session.getAttribute("username");
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		m.addAttribute("cartitems",listCartItems);
		m.addAttribute("totalCartAmount",this.calTotalCartAmount(listCartItems));
		
		return "Payment";
	}
	
	@RequestMapping(value="/paymentprocess",method=RequestMethod.POST)
	public String paymentProcessing(@RequestParam("paymenttype") String paymentMode,HttpSession session,Model m) {
		
		String userName = (String) session.getAttribute("username");
		
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		m.addAttribute("cartitems",listCartItems);
		int totalCartAmount = this.calTotalCartAmount(listCartItems);
		m.addAttribute("totalCartAmount",totalCartAmount);
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setPaymentMode(paymentMode);
		orderDetail.setUserName(userName);
		orderDetail.setTotalCartAmount(totalCartAmount);
		orderDetail.setOrderDate(new Date());
		m.addAttribute("orderDetail",orderDetail);
		
		orderDetailDAO.insertOrderDetail(orderDetail);
		orderDetailDAO.updateOrderDetail(userName);
		UserDetail userdetail = userdetailDAO.getUserDetail(userName);
		m.addAttribute("userdetail",userdetail);
		return "Receipt";
	}
	
	public int calTotalCartAmount(List<CartItem> listCartItems) {
		
		int totalCartAmount = 0;
		int count = 0 ;
		while(count<listCartItems.size())
		{
			CartItem cartItem = listCartItems.get(count);
			totalCartAmount=totalCartAmount+(cartItem.getQuantity()*cartItem.getPrice());
			count++;
		}
		return totalCartAmount;
	}
}