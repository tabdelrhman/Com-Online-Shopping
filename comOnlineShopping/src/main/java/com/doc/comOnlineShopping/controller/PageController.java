package com.doc.comOnlineShopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doc.comOnlineShopping.exception.ProductNotFoundException;
import com.doc.comOnlineShoppingBE.dao.Category;
import com.doc.comOnlineShoppingBE.dao.ProductDAO;
import com.doc.comOnlineShoppingBE.dto.CategoryDTO;
import com.doc.comOnlineShoppingBE.dto.Product;

@Controller
public class PageController {
	
	@Autowired
	Category categoryDao;
	
	@Autowired
	ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@RequestMapping(value = {"/","/home","/page"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome" , true);
		mv.addObject("title" , "Home");
		mv.addObject("categories", categoryDao.listCategory());
		
		logger.info("------------|| INFO");
		logger.debug("------------|| Debug");
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
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if (product == null) {
			throw new ProductNotFoundException();
		}
		
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//---------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
		
	}
	
}
