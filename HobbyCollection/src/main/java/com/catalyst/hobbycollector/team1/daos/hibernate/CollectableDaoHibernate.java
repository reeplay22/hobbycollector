package com.catalyst.hobbycollector.team1.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.catalyst.hobbycollector.team1.daos.CollectableDao;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.SearchCollectable;

/**
 * use to implement database control through hql
 * 
 * @return
 */

@Component
@Transactional
public class CollectableDaoHibernate implements CollectableDao {

	Collectable collectable = new Collectable();
	private static final String MODEL_NUMBER = "modelNumber";
	private static final String DESCRIPTION_COLUMN = "description";
	private static final String NAME_COLUMN = "name";

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;

	}

	/**
	 * use to add to database
	 * 
	 * @return
	 */
	@Override
	public String add(Collectable collectable) {
		Integer quantity = collectable.getQuantity();
		try {
			collectable = em
					.createQuery(
							"SELECT c FROM Collectable c WHERE (c.name = :name)" + "AND (c.category = :category)"
									+ "AND (c.condition = :condition)" + "AND (c.color = :color)"
									+ "AND (c.brand = :brand)" + "AND (c.modelNumber = :modelNumber)"
									+ "AND (c.price = :price)" + "AND (c.description = :description)",
							Collectable.class)
					.setParameter(NAME_COLUMN, collectable.getName())
					.setParameter("category", collectable.getCategory())
					.setParameter("condition", collectable.getCondition()).setParameter("color", collectable.getColor())
					.setParameter("brand", collectable.getBrand())
					.setParameter(MODEL_NUMBER, collectable.getModelNumber())
					.setParameter("price", collectable.getPrice())
					.setParameter(DESCRIPTION_COLUMN, collectable.getDescription()).getSingleResult();
			collectable.setQuantity(quantity + collectable.getQuantity());

			em.persist(collectable);
			return "updated";

		} catch (NoResultException e) {
			em.persist(collectable);
			return "added";
		}
	}

	@Override
	public void update(Collectable collectable) {

		em.merge(collectable);
	}

	/**
	 * use to return all collectables and their info
	 * 
	 * @return
	 */
	@Override
	public List<Collectable> getAllCollectables() {
		return em.createQuery("SELECT c From Collectable c", Collectable.class).getResultList();
	}

	@Override
	public Collectable getByCatalogNumber(Integer catalogNumber) {
		return em.createQuery("SELECT c FROM Collectable c WHERE c.catalogNumber = :id", Collectable.class).

		setParameter("id", catalogNumber).getSingleResult();
	}

	@Override
	public List<Collectable> searchCollectables(SearchCollectable searchCollectable) {

		CriteriaBuilder build = em.getCriteriaBuilder();
		CriteriaQuery<Collectable> criteria = build.createQuery(Collectable.class);
		Root<Collectable> collectableRoot = criteria.from(Collectable.class);
		List<Predicate> predicates = new ArrayList<Predicate>();


		
		if (!StringUtils.isEmpty(searchCollectable.getName()) && searchCollectable.getName() != null) {
			Predicate name = build.equal(collectableRoot.get(NAME_COLUMN), searchCollectable.getName());
			predicates.add(name);

		}

		if (!StringUtils.isEmpty(searchCollectable.getDescription()) && searchCollectable.getDescription() != null) {
			Predicate description = build.equal(collectableRoot.get(DESCRIPTION_COLUMN),
					searchCollectable.getDescription());
			predicates.add(description);

		}

		if (searchCollectable.getModelNumber() != null && !searchCollectable.getModelNumber().toString().isEmpty()) {
			Predicate modelNumber = build.equal(collectableRoot.get(MODEL_NUMBER), searchCollectable.getModelNumber());
			predicates.add(modelNumber);

		}

		if (searchCollectable.getCategory() != null && searchCollectable.getCategory().getCategoryId() > 0) {
			Predicate category = build.equal(collectableRoot.get("category").get("categoryId"),
					searchCollectable.getCategory().getCategoryId());
			predicates.add(category);

		}

		if (searchCollectable.getCondition() != null && searchCollectable.getCondition().getConditionId() > 0) {
			Predicate condition = build.equal(collectableRoot.get("condition").get("conditionId"),
					searchCollectable.getCondition().getConditionId());
			predicates.add(condition);

		}

		if (searchCollectable.getColor() != null && searchCollectable.getColor().getColorId() > 0) {
			Predicate color = build.equal(collectableRoot.get("color").get("colorId"),
					searchCollectable.getColor().getColorId());
			predicates.add(color);

		}

		if (searchCollectable.getBrand() != null && searchCollectable.getBrand().getBrandId() > 0) {
			Predicate brand = build.equal(collectableRoot.get("brand").get("brand_id"),
					searchCollectable.getBrand().getBrandId());
			predicates.add(brand);

		}

		if (searchCollectable.getQuantity() != null && !searchCollectable.getQuantity().toString().isEmpty()) {
			if(searchCollectable.getQuantity() == 0){
				
				Predicate showDeleteItems = build.equal(collectableRoot.get("quantity"), 0);
				predicates.add(showDeleteItems);	
			}
			Predicate quantity = build.equal(collectableRoot.get("quantity"), searchCollectable.getQuantity());
			predicates.add(quantity);

		}
		else{
			Predicate noShowDeletedItems = build.gt(collectableRoot.get("quantity"), 0);
		predicates.add(noShowDeletedItems);
		}

		if (searchCollectable.getDate() != null && !searchCollectable.getDate().toString().isEmpty()) {

			Predicate dateMin = build.lessThanOrEqualTo(collectableRoot.get("date"), searchCollectable.getDate());
			predicates.add(dateMin);
			
		}

		if (searchCollectable.getDateMin() != null && !searchCollectable.getDateMin().toString().isEmpty()) {

			Predicate dateMin = build.greaterThanOrEqualTo(collectableRoot.get("date"), searchCollectable.getDateMin());
			predicates.add(dateMin);
			
		}

		if (searchCollectable.getDateMax() != null && !searchCollectable.getDateMax().toString().isEmpty()) {

			Predicate dateMax = build.lessThanOrEqualTo(collectableRoot.get("date"), searchCollectable.getDateMax());
			predicates.add(dateMax);
			
		}

		if (searchCollectable.getPriceMin() != null && !searchCollectable.getPriceMin().toString().isEmpty()) {

			Predicate priceMin = build.greaterThanOrEqualTo(collectableRoot.get("price"),
					searchCollectable.getPriceMin());
			predicates.add(priceMin);
			
		}

		if (searchCollectable.getPriceMax() != null && !searchCollectable.getPriceMax().toString().isEmpty()) {

			Predicate priceMax = build.lessThanOrEqualTo(collectableRoot.get("price"), searchCollectable.getPriceMax());
			predicates.add(priceMax);
		}

		

		criteria.select(collectableRoot).where(predicates.toArray(new Predicate[] {}));
		TypedQuery<Collectable> query = em.createQuery(criteria);
		return query.getResultList();


	}

}

