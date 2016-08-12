package com.catalyst.hobbycollector.team1.services;

import java.util.List;

import com.catalyst.hobbycollector.team1.entities.Color;
/**
 * color service functions
 * @author ccrosby
 *
 */
public interface ColorService {
	
	/**
	 * Adds new item to color
	 * @param color
	 */
	void add (Color color);
	
	/**
	 * Retrieves all items from color
	 * @return
	 */
	List<Color> getColors();
	
	/**
	 * Update information on existing color.
	 * @param color
	 */
	void update (Color color);
	
	/**
	 * Retrieves color information
	 * @param colorId
	 * @return
	 */
	
	Color getColorById(Integer colorId);
}