package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Category;

public interface CategoryDAO {

	public boolean add(Category category);
	public boolean delete(Category category);
	public boolean update(Category category);
	
	public List<Category> listCategories();
	public Category getCategory(int categoryId); 
}
