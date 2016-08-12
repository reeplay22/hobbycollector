package com.catalyst.hobbycollector.team1.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.hobbycollector.team1.daos.ColorDao;
import com.catalyst.hobbycollector.team1.entities.Color;
/**
 * color hibernate functions
 * @author ccrosby
 *
 */
@Component
@Transactional
/**
 * color hibernate functions
 * @author ccrosby
 *
 */
public class ColorDaoHibernate implements ColorDao{
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	public void setEm(EntityManager em){
		this.em = em;
		
	}
	
	@Override
	public void add(Color color) {
	em.persist(color);
	}


	@Override
	public Color getByColorId(Integer colorId) {
		return em.
				createQuery("SELECT c FROM Color c WHERE c.colorId = :id", Color.class)
				.setParameter("id", colorId)
				.getSingleResult();
	}
	
	@Override
	public List<Color> getAllColors() {
		return em.createQuery("SELECT c FROM Color c", Color.class).getResultList();
	}
	
	@Override
	public void update(Color color) {
		em.merge(color);
		
	}

}