package dao;

import entities.Team;

import java.util.List;

public interface TeamDAO {
    List<Team> findAll();
    Team findByID(int idTeam);
    Team findByName(String name);
    Team findByDirector(String director);
    Team create(Team team);
    Team update(Team team);
    boolean deleteByID(String name);
}
