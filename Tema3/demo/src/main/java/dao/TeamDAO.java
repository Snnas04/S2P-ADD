package dao;

import entities.Team;

import java.util.List;

public interface TeamDAO {
    List<Team> findAll();
    Team findByID(byte idTeam);
    Team findByName(String name);
    Team create(Team team);
    Team update(Team team);
    boolean deleteByID(String name);
}
