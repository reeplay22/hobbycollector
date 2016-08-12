package com.catalyst.hobbycollector.team1.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * use to make and assign values to collectable
 * 
 * @return
 */
@Entity
@Table(name = "collectable", schema = "")
public class Collectable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catalog_number")
	private Integer catalogNumber;
	@Column(name = "collectable_name")
	private String name;
	@Column(name = "quantity")
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;
	@ManyToOne
	@JoinColumn(name = "condition")
	private Condition condition;
	@ManyToOne
	@JoinColumn(name = "color")
	private Color color;
	@ManyToOne
	@JoinColumn(name = "brand")
	private Brand brand;
	@Column(name = "model_number")
	private Integer modelNumber;
	@Column(name = "price")
	private BigDecimal price;

	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "date")
	private LocalDateTime date;
	@Column(name = "description")
	private String description;
	@JsonProperty
	private Boolean owned;

	/**
	 * creates collectable with a date
	 * 
	 * @return
	 */
	public Collectable() {
		this.date = LocalDateTime.now();
	}

	/**
	 * @return the catalogNumber
	 */
	public Integer getCatalogNumber() {
		return catalogNumber;
	}

	/**
	 * @param catalogNumber
	 *            the catalogNumber to set
	 */
	public void setCatalogNumber(Integer catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the condition
	 */
	public Condition getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 *            the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the owned
	 */
	public Boolean IsOwned() {
		return owned;
	}

	/**
	 * @param owned
	 *            the owned to set
	 */
	public void setOwned(Boolean isOwned) {
		this.owned = isOwned;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the modelNumber
	 */
	@Override
	public String toString() {
		return "Collectable [catalogNumber=" + catalogNumber + ", collectableName=" + name + ", quantity=" + quantity
				+ ", category=" + category + ", condition=" + condition + ", color=" + color + ", brand=" + brand
				+ ", modelNumber=" + modelNumber + ", price=" + price + ", date=" + date + ", description="
				+ description + ", owned=" + owned + "]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the modelNumber
	 */
	public Integer getModelNumber() {
		return modelNumber;
	}

	/**
	 * @param modelNumber
	 *            the modelNumber to set
	 */
	public void setModelNumber(Integer modelNumber) {
		this.modelNumber = modelNumber;
	}
	
	/**
	 * hashcode generator
	 * @return result
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((catalogNumber == null) ? 0 : catalogNumber.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((modelNumber == null) ? 0 : modelNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owned == null) ? 0 : owned.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}
}