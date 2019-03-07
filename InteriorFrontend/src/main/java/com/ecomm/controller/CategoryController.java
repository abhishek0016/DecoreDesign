package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/category")
	public String showCategoryPage(Model m)
	{
		List<Category> listcategories = categoryDAO.listCategories();
		m.addAttribute("categorylist",listcategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/addcategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("cname")String categoryName,@RequestParam("cdesc")String categoryDesc,Model m)
	{
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.add(category);
		
		List<Category> listcategories = categoryDAO.listCategories();
		m.addAttribute("categorylist",listcategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/deletecategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m) 
	{
		Category category = new Category();
		category = categoryDAO.getCategory(categoryId);
		categoryDAO.delete(category);
		
		List<Category> listcategories = categoryDAO.listCategories();
		m.addAttribute("categorylist",listcategories);
		
		return "redirect:/category";
	}
	
	@RequestMapping(value="/editcategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category = new Category();
		category = categoryDAO.getCategory(categoryId);
		m.addAttribute("categoryData",category);
		
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/updatecategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("cid")int categoryId,@RequestParam("cname")String categoryName,@RequestParam("cdesc")String categoryDesc,Model m)
	{
		Category category = new Category();
		category = categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.update(category);
		
		List<Category> listcategories = categoryDAO.listCategories();
		m.addAttribute("categorylist",listcategories);
		
		return "Category";
	}
}
