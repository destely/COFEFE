package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.Cofefe;
import main.java.ru.eltech.cofefe.core.entity.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Юлия on 23.11.2014.
 */
public class CofefeService {
    public EntityManager em = Persistence.createEntityManagerFactory("COFEFE").createEntityManager();

    public Cofefe add(Cofefe cofefe) {
        em.getTransaction().begin();
        Cofefe cofefeFromDB = em.merge(cofefe);
        em.getTransaction().commit();
        return cofefeFromDB;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(get(id));
    }

    private Cofefe get(long id) {
        return em.find(Cofefe.class, id);
    }

    public void update(Cofefe cofefe) {
        em.getTransaction().begin();
        em.merge(cofefe);
        em.getTransaction().commit();
    }

    public List<Cofefe> getAll() {
        Query query = em.createNamedQuery("SELECT c FROM Cofefe c");
        List results = query.getResultList();
        return results;
    }
}
