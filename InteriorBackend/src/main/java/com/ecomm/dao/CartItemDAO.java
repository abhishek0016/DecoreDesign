package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.CartItem;

public interface CartItemDAO {

	public boolean addCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	
	public List<CartItem> listCartItems(String userName);
	public CartItem getCartItem(int cartItemId);
}

