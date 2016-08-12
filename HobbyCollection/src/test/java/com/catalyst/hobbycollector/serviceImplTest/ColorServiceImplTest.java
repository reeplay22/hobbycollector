package com.catalyst.hobbycollector.serviceImplTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.daos.CategoryDao;
import com.catalyst.hobbycollector.team1.daos.ColorDao;
import com.catalyst.hobbycollector.team1.entities.Category;
import com.catalyst.hobbycollector.team1.entities.Color;
import com.catalyst.hobbycollector.team1.services.impl.CategoryServiceImpl;
import com.catalyst.hobbycollector.team1.services.impl.ColorServiceImpl;

public class ColorServiceImplTest {

	private ColorServiceImpl target;
	private ColorDao mockColorDao;
	
	@Before
	public void setUp(){
		target = new ColorServiceImpl();
		mockColorDao = mock(ColorDao.class);
		target.setColorDao(mockColorDao);
	}
	
	@Test 
	public void testAdd() {
		target.add(null);
		verify(mockColorDao, times(1)).add(null);
	}
	
	@Test
	public void testUpdate() {
		target.update(null);
		verify(mockColorDao, times(1)).update(null);
	}
	
	private List<Color> colorList(){
		List<Color> color = new ArrayList<>();
		Color c = new Color();
		color.add(c);
		return color;
	}
}


