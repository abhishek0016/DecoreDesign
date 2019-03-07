package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Supplier;

public interface SupplierDAO {

	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	
	public Supplier getSupplier(int supplierId);
	public List<Supplier> listSuppliers();
}
