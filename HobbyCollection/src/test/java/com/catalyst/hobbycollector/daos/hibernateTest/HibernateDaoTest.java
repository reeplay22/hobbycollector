package com.catalyst.hobbycollector.daos.hibernateTest;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Before;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.daos.hibernate.CollectableDaoHibernate;
import com.catalyst.hobbycollector.team1.entities.Brand;
import com.catalyst.hobbycollector.team1.entities.Category;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.Collectable;
import com.catalyst.hobbycollector.team1.entities.Color;
import com.catalyst.hobbycollector.team1.entities.Condition;
import com.catalyst.hobbycollector.team1.entities.SearchCollectable;


public class HibernateDaoTest{

    private CollectableDaoHibernate target;

    private EntityManager mockEm;

    private CriteriaBuilder mockCriteriaBuilder;

    private TypedQuery<Collectable> mockTypedQuery;

    private Predicate mockPredicate;

    private List<Predicate> mockPredicateList;

    private Collectable mockCollectable;

    private CriteriaQuery<Collectable> mockCriteriaQuery;

    private Root<Collectable> mockCollectableRoot;

    private List<Collectable> mockResultList;


    @Before
    public void setup() {
        target = new CollectableDaoHibernate();
        mockEm = mock(EntityManager.class);
        target.setEm(mockEm);
        mockCriteriaQuery = mock (CriteriaQuery.class);
         mockPredicate = mock (Predicate.class);
         mockPredicateList = mock (ArrayList.class);
        mockCriteriaBuilder = mock (CriteriaBuilder.class);
        mockTypedQuery = mock(TypedQuery.class);
         mockCollectable = mock(Collectable.class);
         mockCollectableRoot= mock (Root.class);
         mockResultList= mock(List.class);
    }

    @Test
     public void testAddMethodException() {

    Exception e= new NoResultException();
    mockCollectable.setQuantity(30);

    Integer expectedquantity = mockCollectable.getQuantity();

    when(mockEm.createQuery(anyString(), eq(Collectable.class))).thenReturn(mockTypedQuery);
    when(mockTypedQuery.setParameter(anyString(), any())).thenReturn(mockTypedQuery);
    when(mockTypedQuery.getSingleResult()).thenReturn(mockCollectable);

    when(mockTypedQuery.getSingleResult()).thenThrow(e);

    target.add(mockCollectable);

    verify(mockEm, times(1)).persist(any());
 }


    @Test
    public void testAddMethod() {

        mockCollectable.setQuantity(30);
        Integer expectedquantity = mockCollectable.getQuantity();

        TypedQuery<Collectable> mockTypedQuery = mock(TypedQuery.class);

        when(mockEm.createQuery(anyString(), eq(Collectable.class))).thenReturn(mockTypedQuery);
        when(mockTypedQuery.setParameter(anyString(), any())).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getSingleResult()).thenReturn(mockCollectable);

        target.add(mockCollectable);

        verify(mockTypedQuery, times(8)).setParameter(anyString(), any());
        verify(mockEm, times(1)).persist(any());

    }

    @Test
    public void testGetAllCollectables() {

        List<Collectable> expected = new ArrayList<>();

        Collectable mockcollectable = mock(Collectable.class);

        TypedQuery<Collectable> mockTypedQuery = mock(TypedQuery.class);

        when(mockEm.createQuery(anyString(), eq(Collectable.class))).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(expected);

        target.getAllCollectables();

        verify(mockTypedQuery, times(1)).getResultList();

    }

    @Test
    public void testUpdate() {
        Collectable expected = new Collectable();
        expected.setCatalogNumber(1);

        target.update(expected);

        verify(mockEm, times(1)).merge(expected);
    }

    @Ignore
    public void testSearchCollectables() {

        SearchCollectable expected = mock (SearchCollectable.class);
        SearchCollectable actual = mock (SearchCollectable.class);

        Date testDate = new Date();
        BigDecimal testPrice = new BigDecimal(111);

        Boolean testBoolean = true;
        expected.setName("name");
        expected.setDescription("description");
        expected.setModelNumber(12345);

        Category testCategory = new Category();
        testCategory.setCategoryId(2);
        expected.setCategory(testCategory);

        Condition testCondition = new Condition();
        testCondition.setConditionId(2);
        expected.setCondition(testCondition);

        Color testColor = new Color();
        testColor.setColorId(2);
        expected.setColor(testColor);

        Brand testBrand= new Brand();
        testBrand.setBrandId(2);
        expected.setBrand(testBrand);

        expected.setQuantity(20);
        expected.setPrice(testPrice);
        expected.setDateMin(testDate);
        expected.setDateMax(testDate);
        expected.setPriceMin(testPrice);
        expected.setPriceMax(testPrice);

//        expected.getName();
//        expected.getDescription();
//        expected.getModelNumber();
//        expected.getCategory();
//        expected.getCondition();
//        expected.getColor();
//        expected.getBrand();
//        expected.getQuantity();
//        expected.getPrice();
//        expected.getDateMin();
//        expected.getDateMax();
//        expected.getPriceMin();
//        expected.getPriceMax();




        when(mockEm.getCriteriaBuilder()).thenReturn(mockCriteriaBuilder);
        when(mockCriteriaBuilder.createQuery(Collectable.class)).thenReturn(mockCriteriaQuery);
        when(mockCriteriaQuery.from(Collectable.class)).thenReturn(mockCollectableRoot);

        when(mockCriteriaBuilder.equal(mockCollectableRoot,expected)).thenReturn(mockPredicate);
        when(mockPredicateList.add(mockPredicate)).thenReturn(true);

        when(mockCriteriaQuery.select(mockCollectableRoot)).thenReturn(mockCriteriaQuery);
        when(mockCriteriaQuery.where(mockPredicateList.toArray(new Predicate[]{}))).thenReturn(mockCriteriaQuery);
        when(mockPredicateList.toArray(new Predicate[]{})).thenReturn(any());

        when(mockEm.createQuery(mockCriteriaQuery)).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(mockResultList);

        target.searchCollectables(expected);
        verify(mockPredicateList, times(16)).add(mockPredicate);
        verify(mockCriteriaQuery, times(1)).select(mockCollectableRoot);
        verify(mockCriteriaQuery, times(1)).where(mockPredicateList.toArray(new Predicate[]{}));

        //assertEquals(mockPredicateList, mockResultList);
        verify(mockTypedQuery, times(1)).getResultList();
    }


    // @Test
    // public void testDelete() {
    // Collectable employeeToDelete = new Collectable();
    // employeeToDelete.setCatalogNumber(5);
    //
    // TypedQuery<Collectable> mockTypedQuery = mock(TypedQuery.class);
    //
    // when(mockEm.createQuery(anyString(),
    // eq(Collectable.class))).thenReturn(mockTypedQuery);
    // when(mockTypedQuery.setParameter(anyString(),
    // anyInt())).thenReturn(mockTypedQuery);
    // when(mockTypedQuery.getSingleResult()).thenReturn(employeeToDelete);
    //
    // target.delete(5);
    //
    // verify(mockEm, times(1)).remove(employeeToDelete);
    // verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(5));
    //
    // }

}

