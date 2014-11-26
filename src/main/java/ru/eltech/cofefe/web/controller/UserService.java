package main.java.ru.eltech.cofefe.web.controller;
import main.java.ru.eltech.cofefe.core.entity.User;

import javax.persistence.*;
import java.util.List;
/**
 * Created by Юлия on 23.11.2014.
 */
public class UserService {
    public EntityManager em = Persistence.createEntityManagerFactory("COFEFE").createEntityManager();

    public User add(User user){
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        em.getTransaction().commit();
        return userFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
    }

    private User get(long id) {
        return em.find(User.class, id);
    }

    public void update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public List<User> getAll() {
        Query query = em.createQuery("SELECT c FROM User c");
        List results = query.getResultList();
        return results;
    }

    public List<User> findByLogin(Object login) {
        Query query = em.createQuery("SELECT h FROM User h WHERE h.login = :login");
        query.setParameter("login", login);
        List result = query.getResultList();
        return result;
    }
}
