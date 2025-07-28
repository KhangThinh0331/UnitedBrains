package com.java04.service;

import com.java04.entity.Share;
import com.java04.util.XJPA;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShareDAOImpl implements ShareDAO {
    EntityManager em = XJPA.getEntityManager();
    protected void finaly() throws Throwable {
        em.close();
    }
    @Override
    public List<Share> findAll() {
        String jpql = "SELECT o FROM Share o";
        TypedQuery<Share> query = em.createQuery(jpql, Share.class);
        return query.getResultList();
    }

    @Override
    public Share findById(Long id) {
        return em.find(Share.class, id);
    }

    @Override
    public void create(Share entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Share entity) {
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
        Share entity = em.find(Share.class, id);
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Object[]> getShareVideoInfo() {
        String jpql = "select s.video.title, count(s), min(s.shareDate), max(s.shareDate) from Share s group by s.video";
        TypedQuery<Object[]> query = em.createQuery(jpql,Object[].class);
        return query.getResultList();
    }
}
