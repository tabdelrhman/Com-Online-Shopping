package com.doc.comOnlineShoppingBE.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.doc.comOnlineShoppingBE.dao.Category;
import com.doc.comOnlineShoppingBE.dto.CategoryDTO;

@Repository(value = "categoryDao")
public class CategoryImpl implements Category {

	private static List<CategoryDTO> categories = new ArrayList<CategoryDTO>();

	static {
		CategoryDTO category = new CategoryDTO();

		category.setId(0);
		category.setName("Mobiles");
		categories.add(category);
		
		category = new CategoryDTO();
		category.setId(1);
		category.setName("TVs");
		categories.add(category);
		
		category = new CategoryDTO();
		category.setId(2);
		category.setName("Fridges");
		categories.add(category);
		
	}
	
	@Override
	public List listCategory() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public CategoryDTO get(int id) {

		for (CategoryDTO categoryDTO : categories) {
			if (categoryDTO.getId() == id) {
				return categoryDTO;
			}
		}
		return null;
	}

}
