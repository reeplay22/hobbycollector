package com.catalyst.hobbycollector.team1.daos.hibernate;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.hobbycollector.team1.daos.CategoryDao;
import com.catalyst.hobbycollector.team1.entities.Category;
/**
 * use to interact with the PostgresSql database
 * @author ccrosby
 *
 */
@Component
@Transactional
public class CategoryDaoHibernate implements CategoryDao{
	@PersistenceContext
	private EntityManager em;
	
	
	
	public void setEm(EntityManager em){
		this.em = em;
		
	}
	
	@Override
	public void add(Category category) {
		em.persist(category);
	}


	@Override
	public void update(Category category) {
		em.merge(category);
		
	}


	@Override
	public List<Category> getAllCategories() {
		return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
	}
	
	@Override
	public Category getByCategoryId(Integer categoryId) {
		return em.
				createQuery("SELECT c FROM Category c WHERE c.categoryId = :id",Category.class).

				setParameter("id", categoryId)
				.getSingleResult();
	}
}
