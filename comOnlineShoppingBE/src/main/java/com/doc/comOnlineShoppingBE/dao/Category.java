package com.doc.comOnlineShoppingBE.dao;

import java.util.List;

import com.doc.comOnlineShoppingBE.dto.CategoryDTO;

public interface Category {

	List listCategory();
	CategoryDTO getCategory(int id);
	boolean addNewCategory(CategoryDTO category);
	boolean updateCategory(CategoryDTO category);
	boolean deleteCategory(CategoryDTO category);

}
