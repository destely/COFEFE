package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.Comment;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Юлия on 30.11.2014.
 */
public class CommentService {
    public EntityManager em = Persistence.createEntityManagerFactory("COFEFE").createEntityManager();

    public Comment add(Comment comment) {
        em.getTransaction().begin();
        Comment commentFromDB = em.merge(comment);
        em.getTransaction().commit();
        return commentFromDB;
    }

    private Comment get(long id) {
        return em.find(Comment.class, id);
    }

    public void update(Comment comment) {
        em.getTransaction().begin();
        em.merge(comment);
        em.getTransaction().commit();
    }

    public List<Comment> getAll() {
        Query query = em.createQuery("SELECT k FROM Comment k");
       List results = query.getResultList();
        return results;
    }

}
