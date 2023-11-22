import dao.TeamDAOImpl;
import dao.TeamDAO;
import entities.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TeamCRUDTest {
    TeamDAO dao;

    @BeforeEach
    void setUp() {
        dao = new TeamDAOImpl();
    }

    @Test
    void findAll() {
        List<Team> teams = dao.findAll();

        System.out.println(teams);
    }

    @Test
    void findById() {
        Team team = dao.findByID((byte) 1);

        System.out.println(team);
    }

    @Test
    void findByName() {
        Team team = dao.findByName("Carrera");

        System.out.println(team);
    }
}
