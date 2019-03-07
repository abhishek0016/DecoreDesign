package com.ecomm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.UserDetail;

@Repository("userdetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUserDetail(UserDetail userdetail) {
		try 
		{
			sessionFactory.getCurrentSession().save(userdetail);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}	
	}

	@Override
	public boolean deleteUserDetail(UserDetail userdetail) {
		
		try 
		{
			sessionFactory.getCurrentSession().delete(userdetail);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean updateUserDetail(UserDetail userdetail) {
		try 
		{
			sessionFactory.getCurrentSession().update(userdetail);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public List<UserDetail> listUsers() {
		
		try
		{
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from UserDetail");
			List<UserDetail> listUsers = query.list();
			session.close();
			return listUsers;
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	@Override
	public UserDetail getUserDetail(String userName) {
		
		try
		{
			Session session = sessionFactory.openSession();
			UserDetail userdetail = session.get(UserDetail.class,userName);
			session.close();
			return userdetail;
		} 
		catch (Exception e) 
		{
			return null;
		}
	}

}
