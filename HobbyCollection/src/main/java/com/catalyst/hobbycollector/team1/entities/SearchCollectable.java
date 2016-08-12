package com.catalyst.hobbycollector.team1.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * used to query and filter the table returns
 * @author ccrosby
 *
 */
public class SearchCollectable {

	private Integer catalogNumber;
	
	private String name;

	private Integer quantity;
	
	private Category category;

	private Condition condition;
	
	private Color color;
	
	private Brand brand;
	
	private Integer modelNumber;
	
	private BigDecimal price;
	private BigDecimal priceMin;
	private BigDecimal priceMax;
	
	private LocalDateTime date;
	
	private Date dateMax;
	
	private Date dateMin;
	
	private String description;
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Integer getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(Integer modelNumber) {
		this.modelNumber = modelNumber;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getOwned() {
		return owned;
	}

	public void setOwned(Boolean owned) {
		this.owned = owned;
	}

	private Boolean owned;

	public Integer getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(Integer catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public Date getDateMax() {
		return dateMax;
	}

	public void setDateMax(Date dateMax) {
		this.dateMax = dateMax;
	}

	public Date getDateMin() {
		return dateMin;
	}

	public void setDateMin(Date dateMin) {
		this.dateMin = dateMin;
	}

	public BigDecimal getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(BigDecimal priceMin) {
		this.priceMin = priceMin;
	}

	public BigDecimal getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(BigDecimal priceMax) {
		this.priceMax = priceMax;
	}
}
