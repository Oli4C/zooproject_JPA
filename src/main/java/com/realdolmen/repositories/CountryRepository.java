package com.realdolmen.repositories;

import com.realdolmen.domain.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Country> findAll() {
       return entityManager.createQuery("select c from Country c", Country.class).getResultList();
    }
}
