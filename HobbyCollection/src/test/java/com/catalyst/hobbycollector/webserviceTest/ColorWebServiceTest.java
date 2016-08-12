package com.catalyst.hobbycollector.webserviceTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.services.ColorService;
import com.catalyst.hobbycollector.team1.webservices.ColorWebService;

public class ColorWebServiceTest {
	private ColorService mockColorService;
	private ColorWebService colorWebService;
	
	@Before
	public void createColorWebService() throws Exception {
		mockColorService = mock(ColorService.class);
		colorWebService = new ColorWebService();
		colorWebService.setColorDao(mockColorService);

	}
	
	@Test
	public void testAddColory() throws Exception {
		colorWebService.addColor(null);
		verify(mockColorService, times(1)).add(null);
	}
	
	@Test
	public void testGetColor() throws Exception {
		colorWebService.getAllColors();
		verify(mockColorService, times(1)).getColors();
	}
}
