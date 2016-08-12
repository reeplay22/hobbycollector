package com.catalyst.hobbycollector.team1.services;

import java.util.List;

import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.SearchCollectable;
/**
 * Collectable Service Interface
 * @author mhenry
 *
 */
public interface CollectableService {
	
	/**
	 * Update information on existing collectable. catalogId is used to find unique items information
	 * @param collectable
	 */
	void update(Collectable collectable);
	
	/**
	 * Retrieves all items from the collectables
	 * @param isOwned
	 * @return
	 */
	List<Collectable> getCollectables(Boolean isOwned);
	
	/**
	 * Retrieves an items information provided the items catalogNumber matches the supplied catalogNumber.
	 * @param catalogNumber
	 * @return
	 */	
	Collectable getCollectableById(Integer catalogNumber);

	
	/**
	 * Retrieves a list of collectables according to values searched by
	 * @param searchCollectable
	 * @return
	 */
	List<Collectable> searchCollectable(SearchCollectable searchCollectable);

	/**
	 * add information to collectable. catalogId is used to find unique items information
	 * @param collectable
	 * @return
	 */
	String add(Collectable collectable);
}


	


	
