package com.catalyst.hobbycollector.team1.daos;

import java.util.List;

import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.SearchCollectable;

/**
 * Interface used to provide Creation, Indexing and Updating Functionality for your
 * grubby little paws and your Collectible objects.
 */

public interface CollectableDao {
	
	/**
	 * Add stolen item to collectable.
	 * @param collectable
	 * @return
	 */
	String add(Collectable collectable);
	
	/**
	 * Update or change information about a stolen item
	 *	@param collectable 
	 **/
	void update(Collectable collectable);
	
	/**
	 * Return all Collectables that are currently stored.
	 * @return Collectable
	 */
	List<Collectable> getAllCollectables();
	
	/**
	 * Return information regarding a specific stolen item from storage with a matching id.
	 * @param catalogNumber
	 * @return
	 */
	Collectable getByCatalogNumber(Integer catalogNumber);

	/**
	 * Return a list of collectables through a criteria builder	
	 * @param searchCollectable
	 * @return <SearchCollectable>
	 */
	List<Collectable> searchCollectables(SearchCollectable searchCollectable);
		
	
	
}
