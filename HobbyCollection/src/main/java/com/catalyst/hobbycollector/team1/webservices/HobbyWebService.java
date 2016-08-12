package com.catalyst.hobbycollector.team1.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.SearchCollectable;
import com.catalyst.hobbycollector.team1.services.CollectableService;

/**
 * use to go to add and index page
 * 
 * @return
 */
@RestController
public class HobbyWebService {
	@Autowired
	private CollectableService collectableService;

	/**
	 * sets collectable service
	 * 
	 * @param collectableService
	 * @return
	 */

	public void setCollectableDao(CollectableService collectableService) {
		this.collectableService = collectableService;
	}

	/**
	 * used to add a collectable to the array list, implements index
	 * 
	 * @param collectable
	 * @return collectableService.add(collectable)
	 */
	@RequestMapping(value = "/collectable", method = RequestMethod.POST)
	public String addCollectable(@RequestBody Collectable collectable) {

		return collectableService.add(collectable);

	}

	/**
	 * use to prints out all collectables in array list
	 * 
	 * @param owned
	 * 
	 * @return collectableService.getCollectables(owned)
	 */
	@RequestMapping(value = "/collectable", method = RequestMethod.GET)
	public List<Collectable> getAllCollectables(Boolean owned) {
		return collectableService.getCollectables(owned);
	}

	/**
	 * use to get a collectable by id
	 * 
	 * @param id
	 * @return
	 * 
	 * 
	 */
	@RequestMapping(value = "/collectable/{id}", method = RequestMethod.GET)
	public Collectable getCollectableByCatalogNumber(@PathVariable Integer id) {
		return collectableService.getCollectableById(id);
	}

	/**
	 * use to update a collectable in the array list
	 * 
	 * @param collectable
	 * 
	 */
	@RequestMapping(value = "/collectable", method = RequestMethod.PUT)
	public void update(@RequestBody Collectable collectable) {
		collectableService.update(collectable);

	}
	/**
	 * use to apply search filters on returned items
	 * @param searchCollectable
	 * @return
	 */
	 @RequestMapping(value ="/collectables", method=RequestMethod.POST)
	 public List<Collectable> searchCollectable(@RequestBody SearchCollectable searchCollectable) {
		 return collectableService.searchCollectable(searchCollectable);
	 }
}
