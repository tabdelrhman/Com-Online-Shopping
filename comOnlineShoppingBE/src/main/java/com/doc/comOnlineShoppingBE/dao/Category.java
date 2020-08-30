package com.doc.comOnlineShoppingBE.dao;

import java.util.List;

import com.doc.comOnlineShoppingBE.dto.CategoryDTO;

public interface Category {

	List listCategory();
	CategoryDTO get(int id);
}
