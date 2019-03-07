package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean add(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}	
	}

	@Override
	public boolean delete(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public List<Category> listCategories() {
		
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Category");
			List<Category> listCategories = query.list();
			session.close();
			return listCategories;

	}

	@Override
	public Category getCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class,categoryId);
		session.close();
		return category;
	}
	    

}
