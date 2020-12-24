package com.doc.comOnlineShoppingBE.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.comOnlineShoppingBE.dao.ProductDAO;
import com.doc.comOnlineShoppingBE.dto.Product;


public class ProductTest {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.doc.comOnlineShoppingBE");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct() {
		
		// create operation
		product = new Product();
				
		product.setName("Oppo Selfie S5344");
		product.setBrand("Oppo22");
		product.setDescription("This is some description for oppo22 mobile phones!");
		product.setUnitPrice(22000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.add(product));		
		
		
		// reading and updating the category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record!",
				true,productDAO.update(product));		
				
		assertEquals("Something went wrong while deleting the existing record!",
				true,productDAO.delete(product));		
		
		// list
		assertEquals("Something went wrong while fetching the list of products!",
				7,productDAO.list().size());		
				
	}
}
	