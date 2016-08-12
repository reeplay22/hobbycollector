package com.catalyst.hobbycollector.team1.hibernatetest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.daos.hibernate.CollectableDaoHibernate;
import com.catalyst.hobbycollector.team1.entities.Collectable;

public class HibernateTest {

	private CollectableDaoHibernate target;

	private EntityManager mockEm;

	@Before
	public void setup() {
		target = new CollectableDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	 @Test
	 public void testAddMethodException() {
	
		 Collectable mockcollectable1= mock(Collectable.class);
			Exception e = new NoResultException();
			TypedQuery<Collectable> mockTypedQuery = mock(TypedQuery.class);
		 
			
		// verify(mockTypedQuery, times(8)).setParameter(anyString(), any());
			when(mockEm.createQuery(anyString(), eq(Collectable.class))).thenReturn(mockTypedQuery);
			when(mockTypedQuery.setParameter(anyString(), any())).thenReturn(mockTypedQuery);
			when(mockTypedQuery.getSingleResult()).thenReturn(mockcollectable1);
			
			when(mockTypedQuery.getSingleResult()).thenThrow(e);
			target.add(mockcollectable1);
			verify(mockEm, times(1)).persist(any());
	 }

	@Test
	public void testAddMethod() {

		Collectable mockcollectable = mock(Collectable.class);
		Collectable mockcollectable1= mock(Collectable.class);
		Exception e = new NoResultException();
		
		mockcollectable.setQuantity(30);
		mockcollectable1.setQuantity(30);
		//Integer expectedquantity = mockcollectable.getQuantity();
		
		TypedQuery<Collectable> mockTypedQuery = mock(TypedQuery.class);
	
		when(mockEm.createQuery(anyString(), eq(Collectable.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), any())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(mockcollectable);
		
		target.add(mockcollectable);
		
//		verify(mockTypedQuery, times(8)).setParameter(anyString(), any());
//	
//		target.add(mockcollectable1);
//		when(mockTypedQuery.getSingleResult()).thenThrow(e);
//		
		verify(mockEm, times(1)).persist(any());
		
	}

	@Test
	public void testGetAllCollectables() {

		List<Collectable> expected = new ArrayList<>();
		Collectable mockcollectable = mock(Collectable.class);

		
		TypedQuery<Collectable> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Collectable.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllCollectables();

		verify(mockTypedQuery, times(1)).getResultList();

	}

	@Test
	public void testGetByCatalogNumber() {
		TypedQuery<Collectable> mockTypedQuery = mock(TypedQuery.class);
		Collectable mockcollectable = mock(Collectable.class);
		mockcollectable.getCatalogNumber();

		when(mockEm.createQuery(anyString(), eq(Collectable.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);

		target.getByCatalogNumber(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));

	}

	@Test
	public void testUpdate() {
		Collectable expected = new Collectable();
		expected.setCatalogNumber(1);

		target.update(expected);

		verify(mockEm, times(1)).merge(expected);
	}

	// @Test
	// public void testDelete() {
	// Collectable employeeToDelete = new Collectable();
	// employeeToDelete.setCatalogNumber(5);
	//
	// TypedQuery<Collectable> mockTypedQuery = mock(TypedQuery.class);
	//
	// when(mockEm.createQuery(anyString(),
	// eq(Collectable.class))).thenReturn(mockTypedQuery);
	// when(mockTypedQuery.setParameter(anyString(),
	// anyInt())).thenReturn(mockTypedQuery);
	// when(mockTypedQuery.getSingleResult()).thenReturn(employeeToDelete);
	//
	// target.delete(5);
	//
	// verify(mockEm, times(1)).remove(employeeToDelete);
	// verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(5));
	//
	// }

}
