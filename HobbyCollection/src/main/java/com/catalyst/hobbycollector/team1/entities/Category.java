package com.catalyst.hobbycollector.team1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * use to get category info
 * 
 * @return
 */
@Entity
@Table(name="category")
public class Category {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="category_id")
private Integer categoryId;

@Column(name="category_name")
private String categoryName;

/**
 * @return the categoryId
 */
public Integer getCategoryId() {
	return categoryId;
}

/**
 * @param categoryId the categoryId to set
 */
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

/**
 * @return the categoryName
 */
public String getCategoryName() {
	return categoryName;
}

/**
 * @param categoryName the categoryName to set
 */
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}


}





