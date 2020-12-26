package com.doc.comOnlineShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doc.comOnlineShoppingBE.dao.ProductDAO;
import com.doc.comOnlineShoppingBE.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	ProductDAO product;
	
	@RequestMapping("/all/products")
	@ResponseBody
	List<Product> getAllProducts(){
		return product.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	List<Product> getProductsByCategory(@PathVariable int id){
		return product.listActiveProductsByCategory(id);
	}
	
	
}
