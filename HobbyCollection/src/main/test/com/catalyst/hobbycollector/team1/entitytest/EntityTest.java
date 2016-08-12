package com.catalyst.hobbycollector.team1.entitytest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import com.catalyst.hobbycollector.team1.entities.Brand;
import com.catalyst.hobbycollector.team1.entities.Category;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.Color;
import com.catalyst.hobbycollector.team1.entities.Condition;


public class EntityTest {

	private Collectable target;
	private Collectable mockCollectable;
	
	private Category mockCategory;
	private Condition mockCondition;
	private Color mockColor;
	private Brand mockBrand;
	
	@Before
	public void setup(){
		target = new Collectable();
		
		target.setCatalogNumber(1);
		target.setName("stuff");
		target.setQuantity(30);
		
		mockCategory = new Category();
		mockCategory.setCategoryId(1);
		mockCategory.setCategoryName("toys");
		
		mockCondition = new Condition();
		mockCondition.setConditionId(1);
		mockCondition.setConditionName("mint");
		
		mockColor = new Color();
		mockColor.setColorId(1);
		mockColor.setColorName("red");
		
		mockBrand = new Brand();
		mockBrand.setBrandId(1);
		mockBrand.setBrandName("gucci");
		
		target.setModelNumber(29384);
		target.setPrice(null);
		
		//target.setDate(11/9/15);
		
		target.setDescription("Wtf is this");
		target.setOwned(true);		
	}
	
	@Test
	public void catelogNumberTest(){
		Integer expected = 1;
		Integer actual= target.getCatalogNumber();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void collectableNameTest(){
		String expected = "stuff";
		String actual= target.getName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void quantityTest(){
		Integer expected = 30;
		Integer actual= target.getQuantity();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void catagoryTest(){
		
		Category category= new Category();
		
		category.setCategoryId(1);
		Integer expected= category.getCategoryId();
		
		category.setCategoryName("toys");
		String expected1 = category.getCategoryName();
				
		assertEquals(expected, mockCategory.getCategoryId());
		assertEquals(expected1, mockCategory.getCategoryName());
	}
	@Test
	public void conditionTest(){
		
		Condition condition= new Condition();
		
		condition.setConditionId(1);
		Integer expected= condition.getConditionId();
		
		condition.setConditionName("mint");
		String expected1 = condition.getConditionName();		
		
		assertEquals(expected, mockCondition.getConditionId());
		assertEquals(expected1, mockCondition.getConditionName());
	}
	@Test
	public void colorTest(){	
		
		Color color= new Color();
		
		color.setColorId(1);
		Integer expected= color.getColorId();
		
		color.setColorName("red");
		String expected1 = color.getColorName();
				
		assertEquals(expected, mockColor.getColorId());
		assertEquals(expected1, mockColor.getColorName());
	}
	@Test
	public void brandTest(){
		
		Brand brand= new Brand();
		
		brand.setBrandId(1);
		Integer expected = brand.getBrandId();
		
		brand.setBrandName("gucci");
		String expected1 = brand.getBrandName();
				
		assertEquals(expected, mockBrand.getBrandId());
		assertEquals(expected1, mockBrand.getBrandName());
	}
	@Test
	public void modelNumberTest(){
		Integer expected = 29384;
		Integer actual= target.getModelNumber();
		
		assertEquals(expected, actual);
	}
	@Test
	public void priceTest(){
		int expected = 1;
		int actual= target.getCatalogNumber();
		
		assertEquals(expected, actual);
	}
//	@Test
//	public void dateTest(){
//		LocalDateTime expected = 11/9/2015;
//		LocalDateTime actual= target.getDate();
//		
//		assertEquals(expected, actual);
//	}
	@Test
	public void desciptionTest(){
		String expected = "Wtf is this";
		String actual= target.getDescription();
		
		assertEquals(expected, actual);
	}
	@Test
	public void ownedTest(){
		boolean expected = true;
		boolean actual= target.IsOwned();
		
		assertEquals(expected, actual);
	}
	
	
}
