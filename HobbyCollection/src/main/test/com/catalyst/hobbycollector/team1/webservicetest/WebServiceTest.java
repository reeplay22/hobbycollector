package com.catalyst.hobbycollector.team1.webservicetest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.services.CollectableService;
import com.catalyst.hobbycollector.team1.webservices.HobbyWebService;


public class WebServiceTest {

	private CollectableService mockCollectableService;
	private HobbyWebService hobbyWebService;

	@Before
	public void createCollectableWebService() throws Exception {
		mockCollectableService = mock(CollectableService.class);
		hobbyWebService = new HobbyWebService();
		hobbyWebService.setCollectableDao(mockCollectableService);
	}

	@Test
	public void testAddCollectables() throws Exception {
		hobbyWebService.addCollectable(null);
		verify(mockCollectableService, times(1)).add(null);
	}

	@Test
	public void testGetCollectables() throws Exception {

		hobbyWebService.getAllCollectables(null);
		verify(mockCollectableService, times(1)).getCollectables(null);
	}

	@Test
	public void testGetCollectableById() throws Exception {
		hobbyWebService.getCollectableByCatalogNumber(null);
		verify(mockCollectableService, times(1)).getCollectableById(null);
	}

	@Test
	public void testUpdateCollectable() throws Exception {
		hobbyWebService.update(null);
		verify(mockCollectableService, times(1)).update(null);
	}

//	@Test
//	public void testRemoveEmployee() throws Exception {
//		hobbyWebService.removeCollectable(null);
//		verify(mockCollectableService, times(1)).delete(null);
//	}

}
