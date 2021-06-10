package com.realdolmen.repositories;

import com.realdolmen.domain.Food;
import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.util.PropertiesLoader;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public FoodRepository() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("animalPu");
//        this.entityManager = emf.createEntityManager();
    }

    public List<Food> getAllFoodFromDb() {
        return entityManager.createNamedQuery("findAllFood", Food.class).getResultList();
    }


    public void deleteFoodById(int id){

    }

    public void updateFoodName(int id, String foodName){

    }

    public Food findById(Long id) {
        return entityManager.find(Food.class,id);
    }

    @Transactional
    public void save(Food newFood) {
        entityManager.persist(newFood);
    }
}
