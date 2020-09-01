package com.doc.comOnlineShoppingBE.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.doc.comOnlineShoppingBE.dao.Category;
import com.doc.comOnlineShoppingBE.dto.CategoryDTO;

@Repository(value = "categoryDao")
@Transactional
public class CategoryImpl implements Category {

	private static List<CategoryDTO> categories = new ArrayList<CategoryDTO>();

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List listCategory() {

		String selectQuery= "FROM CategoryDTO WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
		query.setParameter("active", true);
			
		return query.getResultList();
	}

	@Override
	public CategoryDTO getCategory(int id) {
		return sessionFactory.getCurrentSession().get(CategoryDTO.class, Integer.valueOf(id));
	}

	@Override
	public boolean addNewCategory(CategoryDTO category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCategory(CategoryDTO category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(CategoryDTO category) {
		try {
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
