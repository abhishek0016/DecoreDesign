package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

/*import org.apache.catalina.ha.CatalinaCluster;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/product")
	public String showProduct(Model m) {
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productlist",listProducts);
		
		Product product = new Product();
		m.addAttribute("product",product);
		
		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList",this.getSupplierList(supplierDAO.listSuppliers()));
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory){
		
		LinkedHashMap<Integer,String> listCategories = new LinkedHashMap<Integer,String>();
		
		for(Category category : listCategory) {
			listCategories.put(category.getCategoryId(),category.getCategoryName());
		}
		return listCategories;
	}
	
	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> listSupplier){
		
		LinkedHashMap<Integer,String> listSuppliers = new LinkedHashMap<Integer,String>();
		
		for(Supplier supplier : listSupplier) {
			listSuppliers.put(supplier.getSupplierId(),supplier.getSupplierName());
		}
		return listSuppliers;
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pImage")MultipartFile pImage,Model m) {

		productDAO.addProduct(product);
		
		String path = "E:\\eclipse-workspace1\\InteriorFrontend\\src\\main\\webapp\\resources\\images\\";
		path = path+String.valueOf(product.getProductId())+".jpg";
		File imageFile = new File(path);
		if(!pImage.isEmpty())
			{
				try
				{
					byte[] buffer = pImage.getBytes();
					FileOutputStream fos = new FileOutputStream(imageFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					bos.write(buffer);
					bos.close();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
					m.addAttribute("Error","Exception Occurred During Image Uploading"+e);
				}
			}
		else 
			{
				System.out.println("Error Occurred");
				m.addAttribute("Error","Error Occurred During Image Uploading");
			}
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productlist",listProducts);
		
		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList",this.getSupplierList(supplierDAO.listSuppliers()));
		
		return "Product";
	}
	@RequestMapping(value="/editproduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m) {
		
		Product product = new Product();
		product = productDAO.getProduct(productId);
		
		m.addAttribute(product);
		
		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList",this.getSupplierList(supplierDAO.listSuppliers()));

		return "UpdateProduct";
	}
	@RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,@RequestParam("pImage")MultipartFile pImage,Model m) {
		
		String path = "E:\\eclipse-workspace1\\InteriorFrontend\\src\\main\\webapp\\resources\\images\\";
		path = path+String.valueOf(product.getProductId())+".jpg";
		File imageFile = new File(path);
		if(!pImage.isEmpty())
			{
				try
				{
					byte[] buffer = pImage.getBytes();
					FileOutputStream fos = new FileOutputStream(imageFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					bos.write(buffer);
					bos.close();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
					m.addAttribute("Error","Exception Occurred During Image Uploading"+e);
				}
			}
		else 
			{
				System.out.println("Error Occurred");
				m.addAttribute("Error","Error Occurred During Image Uploading");
			}
		productDAO.updateProduct(product);
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productlist",listProducts);
		
		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList",this.getSupplierList(supplierDAO.listSuppliers()));
		
		return "Product";
	}

	@RequestMapping(value="/deleteproduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m) {
		
		Product product = new Product();
		product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productlist",listProducts);
		
		Product product1 = new Product();
		m.addAttribute(product1);

		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList",this.getSupplierList(supplierDAO.listSuppliers()));
		
		return "redirect:/product";
	}
	
	@RequestMapping(value="/productdisplay")
	public String displayProduct(Model m) {
		
		m.addAttribute("productlist",productDAO.listProducts());
		m.addAttribute("categoryList",categoryDAO.listCategories());
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/productdisplay/{cid}")
	public String displayProductByCategory(Model m,@PathVariable("cid")int categoryId) {
		
		m.addAttribute("productlist",productDAO.listProductByCategory(categoryId));
		m.addAttribute("categoryList",categoryDAO.listCategories());
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/totalproductdisplay/{productId}")
	public String totalProductDisplay(@PathVariable("productId")int productId,Model m) {
		
		Product product = new Product();
		product = productDAO.getProduct(productId);
		
		m.addAttribute("product",product);
		m.addAttribute("categoryName",categoryDAO.getCategory(product.getCategoryId()).getCategoryName());
		return "TotalProductDisplay";
	}
}