package com.java04.service;

import com.java04.entity.Favorite;
import com.java04.utils.XJPA;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FavoriteDAOImpl implements FavoriteDAO {
    EntityManager em = XJPA.getEntityManager();
    protected void finaly() throws Throwable {
        em.close();
    }
    @Override
    public List<Favorite> findAll() {
        String jpql = "SELECT o FROM Favorite o";
        TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
        return query.getResultList();
    }

    @Override
    public Favorite findById(Long id) {
        return em.find(Favorite.class, id);
    }

    @Override
    public void create(Favorite entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Favorite entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteById(Long id) {
        Favorite entity = em.find(Favorite.class, id);
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}

