package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.CartItem;
import com.ecomm.model.Category;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCartItem(CartItem cartItem) {
		
		try 
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}	
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		
		try 
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		
		try 
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public List<CartItem> listCartItems(String userName) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CartItem where username=:myusername and status='NA'");
		query.setParameter("myusername",userName);
		List<CartItem> listCartItems = (List<CartItem>)query.list();
		session.close();
		return listCartItems;

	}

	@Override
	public CartItem getCartItem(int cartItemId) {
		
		Session session = sessionFactory.openSession();
		CartItem cartitem = session.get(CartItem.class,cartItemId);
		session.close();
		return cartitem;
	}

}
