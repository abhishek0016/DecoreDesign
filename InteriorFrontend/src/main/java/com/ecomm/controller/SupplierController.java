package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/supplier")
	public String showSupplierPage(Model m) {
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist",listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/addsupplier",method=RequestMethod.POST)
	public String insertSupplier(@RequestParam("sname")String supplierName,@RequestParam("sadd")String supplierAddress,Model m)
	{
		Supplier supplier = new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddress(supplierAddress);
		
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist",listSuppliers);
		
		return "Supplier";
	}
	@RequestMapping(value="/deletesupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m) 
	{
		Supplier supplier = new Supplier();
		supplier = supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist",listSuppliers);
		
		return "redirect:/supplier";
	}
	@RequestMapping(value="/editsupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier = new Supplier();
		supplier = supplierDAO.getSupplier(supplierId);
		m.addAttribute("supplierData",supplier);
		
		return "UpdateSupplier";
	}
	@RequestMapping(value="/updatesupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("sid")int supplierId,@RequestParam("sname")String supplierName,@RequestParam("sadd")String supplierAddress,Model m)
	{
		Supplier supplier = new Supplier();
		supplier = supplierDAO.getSupplier(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddress(supplierAddress);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist",listSuppliers);
		
		return "Supplier";
	}
}