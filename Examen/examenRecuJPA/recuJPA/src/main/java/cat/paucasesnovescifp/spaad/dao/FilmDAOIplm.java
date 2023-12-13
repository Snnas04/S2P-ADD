package cat.paucasesnovescifp.spaad.dao;

import cat.paucasesnovescifp.spaad.auxiliars.JPAUtiles;
import cat.paucasesnovescifp.spaad.jpa.entitats.Film;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FilmDAOIplm implements FilmDAO {

    @Override
    public Film getFilm(short id) {
        EntityManager em = JPAUtiles.getEntityManager();
        Film film = em.find(Film.class, id);
        em.close();

        return film;
    }

    @Override
    public List<Film> getByTime(int filmLenght) {
        EntityManager em = JPAUtiles.getEntityManager();

        TypedQuery<Film> query = em.createQuery("select f from Film f where f.length > " + filmLenght, Film.class);
        List<Film> films = query.getResultList();

        em.close();

        return films;
    }

    @Override
    public Film create(Film film) {
        EntityManager em = JPAUtiles.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(film);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return film;
    }
}
