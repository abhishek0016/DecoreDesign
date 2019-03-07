package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.OrderDetail;

@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean insertOrderDetail(OrderDetail orderDetail) {
	
		try 
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
		
	}

	@Override
	public boolean updateOrderDetail(String userName) {
		
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update CartItem set status='P' where username=:myusername and status='NA'");
			query.setParameter("myusername",userName);
			int row_effected = query.executeUpdate();
			if(row_effected>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

}
