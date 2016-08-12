package com.catalyst.hobbycollector.team1.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.hobbycollector.team1.entities.Color;
import com.catalyst.hobbycollector.team1.services.ColorService;
/**
 * web service for color
 * @author ccrosby
 *
 */
@RestController
public class ColorWebService {
	@Autowired
	private ColorService colorService;	
	
	public void setColorDao(ColorService colorService) {
		this.colorService = colorService;
	}
	
	/**
	 * get all colors
	 * @return
	 */
	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public List<Color> getAllColors() {
	return colorService.getColors();
		
	}
	/**
	 * add a color
	 * @param color
	 */
	@RequestMapping(value = "/color", method = RequestMethod.POST)
	public void addColor(@RequestBody Color color) {

		colorService.add(color);
		
	}
	/**
	 * get a color by id
	 * @param colorId
	 * @return
	 */
	@RequestMapping(value = "/color/{colorId}", method = RequestMethod.GET)
	public Color getColorByColorId(@PathVariable Integer colorId)  {
		return colorService.getColorById(colorId);
	}
	/**
	 * update a color
	 * @param colorId
	 * @param color
	 */
	@RequestMapping(value = "/color/{colorId}", method = RequestMethod.PUT)
	public void update(@PathVariable Integer colorId,@RequestBody Color color) {
		colorService.update(color);

	}
}
