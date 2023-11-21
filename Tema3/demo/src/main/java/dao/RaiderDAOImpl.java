package dao;

import entities.Rider;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RaiderDAOImpl implements RiderDAO{
    @Override
    public List<Rider> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        TypedQuery<Rider> query = em.createQuery("select r from Rider r", Rider.class);
        List<Rider> riders = query.getResultList();

        em.close();

        return riders;
    }

    @Override
    public Rider findByDorsal(int dorsal) {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        TypedQuery<Rider> query = em.createQuery("select r from Rider r where dorsal = :dorsal", Rider.class);
        query.setParameter("dorsal", dorsal);

        Rider rider = query.getSingleResult();

        return rider;
    }

    @Override
    public List<Rider> findByCountry(String country) {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        TypedQuery<Rider> query = em.createQuery("select r from Rider r where r.country = :country", Rider.class);
        query.setParameter("country", country);

        List<Rider> riders = query.getResultList();

        return riders;
    }

    @Override
    public Rider create(Rider rider) {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        try {
            em.getTransaction().begin();
            em.persist(rider);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return rider;
    }

    @Override
    public Rider update(Rider rider) {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        Rider updated = null;

        try {
            em.getTransaction().begin();
            updated = em.merge(rider);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return updated;
    }

    @Override
    public boolean deleteByDorsal(int dorsal) {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        try {
            em.getTransaction().begin();
            Rider rider = findByDorsal(dorsal);
            Rider merged = em.merge(rider);
            em.remove(merged);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

        return true;
    }
}
