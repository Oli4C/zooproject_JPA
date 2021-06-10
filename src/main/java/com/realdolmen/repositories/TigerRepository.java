package com.realdolmen.repositories;

import com.realdolmen.domain.Tiger;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

//Repository communicates with the database
//Anatomy of a Class: AccessModifier class ClassName
@Repository
public class TigerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TigerRepository() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("animalPu");
//        this.entityManager = emf.createEntityManager();
    }

    public List<Tiger> getTigersFromDb() {
        TypedQuery<Tiger> tigers = entityManager.createQuery("select t from Tiger t", Tiger.class);
        return tigers.getResultList();
    }

    @Transactional
    public void addATigerInDb(Tiger tiger) {
        entityManager.persist(tiger);
    }

    public Tiger findById(int id) {
        return entityManager.find(Tiger.class, id);
    }

    public void updateTigerById(Tiger tiger) {
        entityManager.merge(tiger);
    }

    public void removeById(int id) {
        Tiger tiger = findById(id);
        entityManager.remove(tiger);
    }
}
