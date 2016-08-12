package com.catalyst.hobbycollector.team1.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.hobbycollector.team1.daos.ColorDao;
import com.catalyst.hobbycollector.team1.entities.Color;
import com.catalyst.hobbycollector.team1.services.ColorService;
/**
 * implements service functions
 * @author ccrosby
 *
 */
@Service
/**
 * implements service functions
 * @author ccrosby
 *
 */
public class ColorServiceImpl implements ColorService {
	
	@Autowired
	private ColorDao colorDao;
	
	public void setColorDao(ColorDao colorDao) {
		this.colorDao = colorDao;
	}

	@Override
	public void add(Color color) {
		colorDao.add(color);
		
	}

	@Override
	public List<Color> getColors() {
		
		return colorDao.getAllColors();
	}

	@Override
	public void update(Color color) {
		colorDao.update(color);
		
	}

	@Override
	public Color getColorById(Integer colorId) {
		return colorDao.getByColorId(colorId);
	}

}
