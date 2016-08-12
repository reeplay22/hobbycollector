package com.catalyst.hobbycollector.team1.daos;

import java.util.List;

import com.catalyst.hobbycollector.team1.entities.Color;
/**
 * color dao
 * 
 */
public interface ColorDao {
	/**
	 * Add color to collectable.
	 * @param color
	 */
	void add(Color color);
	
	/**
	 * Update or change information about a color
	 * @param color
	 */
	void update(Color color);
	
	/**
	 * Return all Colors that are currently stored.
	 * @param <Color>
	 * @return
	 */
	List<Color> getAllColors();
	
	/**
	 * Return information regarding a specific color Id from storage.
	 * @param colorId
	 * @return
	 */
	
	Color getByColorId(Integer colorId);
}
