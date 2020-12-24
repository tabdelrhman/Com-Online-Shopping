package com.doc.comOnlineShoppingBE.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.comOnlineShoppingBE.dao.Category;
import com.doc.comOnlineShoppingBE.dto.CategoryDTO;

public class CategoryTest {

	private static AnnotationConfigApplicationContext AnnConAppContext;
	private static CategoryDTO category;
	private static Category categoryDao;
	
	@BeforeClass
	public static void init() {
		AnnConAppContext = new AnnotationConfigApplicationContext();
		AnnConAppContext.scan("com.doc.comOnlineShoppingBE");
		AnnConAppContext.refresh();
		categoryDao = (Category) AnnConAppContext.getBean("categoryDao");
	}
	
	/*
	@Test
	public void testAddCategory() {
		
		category = new CategoryDTO();
		category.setName("Mobiles");
		category.setActive(true);
		category.setDescription("Mobile Desc..");
		category.setImageURL("untitled.jpg");
		
		assertEquals("Testing adding done successfully",true , categoryDao.addNewCategory(category));
		
	}
*/
	/*@Test
	public void testGetCategory() {
		category = categoryDao.getCategory(3);
		assertEquals("Testing getting cat. done successfully","Laptop" , category.getName());
	}*/

	/*@Test
	public void testUpdateCategory() {
		category = categoryDao.getCategory(3);
		category.setName("Laptops");
		assertEquals("Testing Updating cat. done successfully",true , categoryDao.updateCategory(category));
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDao.getCategory(4);
		assertEquals("Testing Deleting cat. done successfully",true , categoryDao.deleteCategory(category));
	}*/
	
	
	/*
	 * @Test public void testSelectCategory() { List allActiveCategory =
	 * categoryDao.listCategory();
	 * assertEquals("Testing selecting cat. done successfully",2 ,
	 * allActiveCategory.size()); }
	 */
}
