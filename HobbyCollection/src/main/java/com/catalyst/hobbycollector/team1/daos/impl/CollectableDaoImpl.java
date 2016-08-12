package com.catalyst.hobbycollector.team1.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.hobbycollector.team1.daos.CollectableDao;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.SearchCollectable;

/**
 * Implementation is used to store Collectables within a list
 * @author mhenry
 *
 */
public class CollectableDaoImpl implements CollectableDao {
	
	private List<Collectable> collectables = new ArrayList<>();
	


	@Override
	public void update(Collectable collectable) {
		Integer index = collectables.indexOf(collectable);
		collectables.set(index, collectable);
		
	}

	@Override
	public List<Collectable> getAllCollectables() {
		return collectables;
	}

	@Override
	public Collectable getByCatalogNumber(Integer catalogNumber) {
		for (Collectable c : collectables){
			if(c.getCatalogNumber().equals(catalogNumber)){
				return c;
			}
		}
		return null;
	}

	@Override
	public String add(Collectable collectable) {
		
		return null;
	}


	@Override
	public List<Collectable> searchCollectables(SearchCollectable searchCollectable) {
		// TODO Auto-generated method stub
		return null;
	}

}
