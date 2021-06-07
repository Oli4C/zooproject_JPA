package com.realdolmen.repositories;

import com.realdolmen.domain.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;


public class CountryRepository {

//    @PersistenceContext
    private EntityManager entityManager;

    public CountryRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("animalPu");
        this.entityManager = emf.createEntityManager();
    }

    public List<Country> findAll() {
       return entityManager.createQuery("select c from Country c ", Country.class).getResultList();
    }
}
