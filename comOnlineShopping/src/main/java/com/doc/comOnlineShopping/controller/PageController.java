package com.doc.comOnlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doc.comOnlineShoppingBE.dao.Category;
import com.doc.comOnlineShoppingBE.daoImpl.CategoryImpl;
import com.doc.comOnlineShoppingBE.dto.CategoryDTO;

@Controller
public class PageController {
	
	@Autowired
	Category categoryDao;

	@RequestMapping(value = {"/","/home","/page"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome" , true);
		mv.addObject("title" , "Home");
		mv.addObject("categories", categoryDao.listCategory());
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAbout" , true);
		mv.addObject("title" , "About-Us");
		return mv;
	}
	
	@RequestMapping(value = {"/contactUs"})
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickContact" , true);
		mv.addObject("title" , "Contact-Us");
		return mv;
	}
	

	/*
	 * Methods to load all the products and based on category
	 * */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories", categoryDao.listCategory());
		mv.addObject("userClickAllProducts",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		CategoryDTO category = null;
		
		category = categoryDao.getCategory(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDao.listCategory());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;				
	}
}
