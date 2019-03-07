package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.Product;

@Controller
public class CartController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartItemDAO cartItemDAO;
	
	@RequestMapping(value="/cart")
	public String showCartItem(HttpSession session,Model m) {
		
		String userName = (String) session.getAttribute("username");
	
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		m.addAttribute("cartitems",listCartItems);
		m.addAttribute("totalCartAmount",this.calTotalCartAmount(listCartItems));
		
		return "Cart";
	}
	
	@RequestMapping(value="/addtocart/{productId}")
	public String addcartItem(@RequestParam("quantity")int quantity,@PathVariable("productId")int productId,HttpSession session,Model m) {
		
		Product product = productDAO.getProduct(productId);
		String userName = (String) session.getAttribute("username");
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		
		boolean present=false;
		CartItem cartPresent=null;
		for(CartItem cartItem:listCartItems) {
			if(cartItem.getProductId()==productId) {
				present=true;
				cartPresent=cartItem;
				break;
			}
		}
		
		if(present) {
			
			cartPresent.setQuantity(quantity+1);

			
			cartItemDAO.updateCartItem(cartPresent);
			
		}
		else {
		
		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setUserName(userName);
		cartItem.setStatus("NA");
		
		cartItemDAO.addCartItem(cartItem);
		}
		
		listCartItems = cartItemDAO.listCartItems(userName);
		m.addAttribute("cartitems",listCartItems);
		m.addAttribute("totalCartAmount",this.calTotalCartAmount(listCartItems));
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/updatecartitem/{cartItemId}")
	public String updateCartItem(@RequestParam("quantity")int quantity,@PathVariable("cartItemId")int cartItemId,HttpSession session,Model m) {
		
		CartItem cartItem = cartItemDAO.getCartItem(cartItemId);
		String userName = (String) session.getAttribute("username");
		cartItem.setQuantity(quantity);
		cartItemDAO.updateCartItem(cartItem);
		
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		
		m.addAttribute("cartitems",listCartItems);
		m.addAttribute("totalCartAmount",this.calTotalCartAmount(listCartItems));
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/deletecartitem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,HttpSession session,Model m) {
		
		CartItem cartItem = cartItemDAO.getCartItem(cartItemId);
		String userName = (String) session.getAttribute("username");
		
		cartItemDAO.deleteCartItem(cartItem);
		
		List<CartItem> listCartItems = cartItemDAO.listCartItems(userName);
		
		m.addAttribute("cartitems",listCartItems);
		m.addAttribute("totalCartAmount",this.calTotalCartAmount(listCartItems));
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/continueshopping")
	public String continueShopping(Model m) {
		
		m.addAttribute("productlist",productDAO.listProducts());
		return "redirect:/productdisplay";
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