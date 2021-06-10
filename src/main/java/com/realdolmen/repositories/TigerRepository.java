package com.realdolmen.repositories;

import com.realdolmen.domain.Food;
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
        List<Tiger> findAllTigers = entityManager.createNamedQuery("findAllTigers", Tiger.class).getResultList();
        return findAllTigers;
    }

    @Transactional
    public void addATigerInDb(Tiger tiger) {
        entityManager.persist(tiger);
    }

    public Tiger findById(long id) {
        TypedQuery<Tiger> query = entityManager.createQuery("select t From Tiger t where t.id = :id ", Tiger.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional
    public void updateTigerById(Tiger tiger) {
        entityManager.merge(tiger);
    }

    @Transactional
    public void removeById(long id) {
        Tiger tiger = findById(id);
        entityManager.remove(tiger);
    }
}
