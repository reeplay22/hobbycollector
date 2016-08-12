package com.catalyst.hobbycollector.team1.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.hobbycollector.team1.daos.CollectableDao;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.SearchCollectable;
import com.catalyst.hobbycollector.team1.services.CollectableService;
/**
 * use functions to add to Dao
 * 
 * @return
 */
@Service
public class HobbyServiceImpl implements CollectableService {
	
	@Autowired
	private CollectableDao collectableDao;
	
	public void setCollectableDao (CollectableDao collectableDao) {
		this.collectableDao = collectableDao;
	}
	
	@Override
	public String add(Collectable collectable) {
		return collectableDao.add(collectable);
		
	}

	@Override
	public void update(Collectable collectable) {
		collectableDao.update(collectable);
		
	}

	@Override
	public List<Collectable> getCollectables(Boolean owned) {
		
		List<Collectable> collectables = collectableDao.getAllCollectables();
		if(owned !=null) {
			List<Collectable> activeCollectables = new ArrayList<>();
			for(Collectable c : collectables){
				if(c.IsOwned().equals(owned)){
					activeCollectables.add(c);
				}
			}
			return activeCollectables;
		}
		return collectables;
	}

	@Override
	public Collectable getCollectableById(Integer catalogNumber) {
		return collectableDao.getByCatalogNumber(catalogNumber);
		
	}
	

	@Override
	public List<Collectable> searchCollectable(SearchCollectable searchCollectable) {
		return collectableDao.searchCollectables(searchCollectable);
	}

}
	
	
	

