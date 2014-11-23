package main.java.ru.eltech.cofefe.web.controller;
import main.java.ru.eltech.cofefe.core.entity.Order;

import javax.persistence.*;
import java.util.List;
/**
 * Created by Юлия on 23.11.2014.
 */
public class OrderService {
    public EntityManager em = Persistence.createEntityManagerFactory("COFEFE").createEntityManager();

    public Order add(Order order){
        em.getTransaction().begin();
        Order orderFromDB = em.merge(order);
        em.getTransaction().commit();
        return orderFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
    }

    private Order get(long id) {
        return em.find(Order.class, id);
    }

    public void update(Order order){
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }

    public List<Order> getAll() {
        Query query = em.createNamedQuery("SELECT c FROM Order c");
        List results = query.getResultList();
        return results;
    }
}
