package dao;

import entities.Team;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeamDAOImpl implements TeamDAO {

    @Override
    public List<Team> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        TypedQuery<Team> query = em.createQuery("select t from Team t", Team.class);
        List<Team> teams = query.getResultList();

        em.close();

        return teams;
    }

    @Override
    public Team findByID(byte idTeam) {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        Team team = em.find(Team.class, idTeam);

        em.close();
        return team;
    }

    @Override
    public Team findByName(String name) {
        EntityManager em = JPAUtil.getEntityManagerFactory();

        Team team = em.find(Team.class, name);

        em.close();
        return team;
    }

    @Override
    public Team create(Team team) {
        return null;
    }

    @Override
    public Team update(Team team) {
        return null;
    }

    @Override
    public boolean deleteByID(String name) {
        return false;
    }
}
