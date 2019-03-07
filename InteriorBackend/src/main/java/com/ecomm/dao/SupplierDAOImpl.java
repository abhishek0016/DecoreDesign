package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addSupplier(Supplier supplier) {
		try 
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		try 
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try 
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public Supplier getSupplier(int supplierId) {
		try 
		{
			Session session = sessionFactory.openSession();
			Supplier supplier = session.get(Supplier.class,supplierId);
			session.close();
			return supplier;
		} 
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public List<Supplier> listSuppliers() {
		try 
		{
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Supplier");
			List<Supplier> listSuppliers = query.list();
			session.close();
			return listSuppliers;
		} 
		catch (Exception e)
		{
			return null;
		}
	}

}
