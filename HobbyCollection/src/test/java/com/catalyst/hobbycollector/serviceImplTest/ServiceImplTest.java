package com.catalyst.hobbycollector.serviceImplTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.daos.CollectableDao;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.services.impl.HobbyServiceImpl;

public class ServiceImplTest {
	private HobbyServiceImpl target;
	private CollectableDao mockCollectableDao;

	@Before
	public void setup() {
		target = new HobbyServiceImpl();
		mockCollectableDao = mock(CollectableDao.class);
		target.setCollectableDao(mockCollectableDao);
	}

	@Test
	public void testAdd() {
		target.add(null);
		verify(mockCollectableDao, times(1)).add(null);
	}

	@Test
	public void testAddAndUpdate() {
		target.add(new Collectable());
		target.add(new Collectable());
		verify(mockCollectableDao, times(2)).add(isA(Collectable.class));
	}

	@Test
	public void testGetAllTasks() {
		int expected = 1;
		List<Collectable> collectable = collectableList();
		when(mockCollectableDao.getAllCollectables()).thenReturn(collectable);
		List<Collectable> actual = target.getCollectables(null);
		assertEquals(expected, actual.size());
	}

	@Test
	public void testGetCollectablesOwned() {
		int expected = 0;
		List<Collectable> collectables = collectableList();
		when(mockCollectableDao.getAllCollectables()).thenReturn(collectables);
		List<Collectable> actual = target.getCollectables(true);
		assertEquals(expected, actual.size());
	}

	@Test
	public void testGetCollectablesUnowned() {
		int expected = 1;
		List<Collectable> collectables = collectableList();
		when(mockCollectableDao.getAllCollectables()).thenReturn(collectables);
		List<Collectable> actual = target.getCollectables(false);
		assertEquals(expected, actual.size());
	}

	private List<Collectable> collectableList() {
		List<Collectable> collectable = new ArrayList<>();
		Collectable c = new Collectable();
		c.setOwned(true);
		c = new Collectable();
		c.setOwned(false);
		collectable.add(c);
		return collectable;
	}

}
