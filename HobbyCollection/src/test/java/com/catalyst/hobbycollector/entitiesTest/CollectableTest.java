package com.catalyst.hobbycollector.entitiesTest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.entities.Brand;
import com.catalyst.hobbycollector.team1.entities.Category;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.Color;
import com.catalyst.hobbycollector.team1.entities.Condition;

public class CollectableTest {
	private Collectable target;
	private Brand target1;
	private Condition target2;
	private Category target3;
	private Color target4;

	@PersistenceContext
	EntityManager em;
@Before
public void setUp() throws Exception {
}

@Test
public void testGettersSettersCollectable(){
	BigDecimal amount = new BigDecimal("1115.37");
	LocalDateTime X = LocalDateTime.now();
	Category category = new Category();
	Condition condition = new Condition();
	Color color = new Color();
	Brand brand = new Brand();
	target = new Collectable();
	target.setName("names");
	target.setCatalogNumber(1);
	target.setQuantity(1);
	target.setModelNumber(1);
	target.setDescription("testing");
	target.setPrice(amount);
	target.setDate(X);
	target.setOwned(true);
	target.setCategory(category);
	target.setBrand(brand);
	target.setColor(color);
	target.setCondition(condition);
	assertEquals(target.getName(), "names");
	assertSame(target.getCatalogNumber(), 1);
	assertSame(target.getQuantity(), 1);
	assertSame(target.getModelNumber(), 1);
	assertEquals(target.getDescription(), "testing");
	assertSame(target.getPrice(), amount);
	assertEquals(target.getDate(), X);
	assertSame(target.getCategory(), category);
	assertSame(target.getBrand(), brand);
	assertSame(target.getColor(), color);
	assertSame(target.getCondition(), condition);
	assertSame(target.IsOwned(), true);
	assertEquals(target.toString(), "Collectable [catalogNumber=" + 1 + ", collectableName=" + "names" + ", quantity=" + 1
				+ ", category=" + category + ", condition=" + condition + ", color=" + color + ", brand=" + brand
				+ ", modelNumber=" + 1 + ", price=" + amount + ", date=" + X + ", description="
				+ "testing" + ", owned=" + true + "]");
	}	

@Test
public void testGettersSettersBrand(){
	target1 = new Brand();
	target1.setBrandId(1);
	target1.setBrandName("Nike");
	assertSame(target1.getBrandId(), 1);
	assertEquals(target1.getBrandName(), "Nike");
}

@Test
public void testGettersSettersCondition(){
	target2 = new Condition();
	target2.setConditionId(1);
	target2.setConditionName("Mint");
	assertSame(target2.getConditionId(), 1);
	assertEquals(target2.getConditionName(), "Mint");
}

@Test
public void testGettersSettersCategory(){
	target3 = new Category();
	target3.setCategoryId(1);
	target3.setCategoryName("Toys");
	assertSame(target3.getCategoryId(), 1);
	assertEquals(target3.getCategoryName(), "Toys");
}

@Test
public void testGettersSettersColors(){
	target4 = new Color();
	target4.setColorId(1);
	target4.setColorName("Red");
	assertSame(target4.getColorId(), 1);
	assertEquals(target4.getColorName(), "Red");
}

}

