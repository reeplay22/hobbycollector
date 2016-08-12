package com.catalyst.hobbycollector.team1.service.impltest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.hobbycollector.team1.daos.CollectableDao;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.services.InvalidInputException;
import com.catalyst.hobbycollector.team1.services.impl.HobbyServiceImpl;



public class ServiceImplTest {

	private HobbyServiceImpl target;
	private CollectableDao mockDao;
	
	@Before
	public void setup(){
		target = new HobbyServiceImpl();
		mockDao = mock (CollectableDao.class);
		target.setCollectableDao(mockDao);	
		
	}
	
	@Test
	public void testAddCollectable(){
		target.add(null);
		verify(mockDao, times(1)).add(null);
	}
	
	@Test
	public void testUpdateCollectable(){
		target.update(null);
		verify(mockDao, times(1)).update(null);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testGetbyCatalogNumberNull() throws InvalidInputException {
		target.getCollectableById(null);
	}
	
	@Test(expected=InvalidInputException.class)
	public void testGetByCatalogNumberZero() throws InvalidInputException{
		target.getCollectableById(-1);
	}
	
	@Test
	public void testGetByCatalogNumberSuccess() throws InvalidInputException{
		target.getCollectableById(1);
		
		verify(mockDao, times(1)).getByCatalogNumber(any());
	}
	
	@Test
	public void testGetEmployeesActive(){
		int expected = 1;
		List<Collectable> employees = collectableList();
		when(mockDao.getAllCollectables()).thenReturn(employees);
		List<Collectable> actual = target.getCollectables(true);
		assertEquals(expected, actual.size());
	}
	
	@Test
	public void testGetEmployeesInactive(){
		int expected = 1;
		List<Collectable> employees = collectableList();
		when(mockDao.getAllCollectables()).thenReturn(employees);
		List<Collectable> actual = target.getCollectables(false);
		assertEquals(expected, actual.size());
	}
	
	private List<Collectable> collectableList() {
		List<Collectable> collectable = new ArrayList<>();
		Collectable c = new Collectable();
		c.setOwned(true);
		collectable.add(c);
		c = new Collectable();
		c.setOwned(false);
		collectable.add(c);
		return collectable;
	}
}
