package com.catalyst.hobbycollector.team1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * use to get info for color
 * 
 * @return
 */
@Entity
@Table(name="color")
public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="color_id")
private Integer colorId;
	
@Column(name="color_name")
private String colorName;

@Column(name="color_value")
private String colorValue;

/**
 * @return the colorId
 */
public Integer getColorId() {
	return colorId;
}

/**
 * @param colorId the colorId to set
 */
public void setColorId(Integer colorId) {
	this.colorId = colorId;
}

/**
 * @return the colorName
 */
public String getColorName() {
	return colorName;
}

/**
 * @param colorName the colorName to set
 */
public void setColorName(String colorName) {
	this.colorName = colorName;
}

/**
 * @return the colorValue
 */
public String getColorValue() {
	return colorValue;
}

/**
 * @param colorValue the colorValue to set
 */
public void setColorValue(String colorValue) {
	this.colorValue = colorValue;
}

}
