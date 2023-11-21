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
        Team team = dao.findByID(25);

        System.out.println(team);
    }

    @Test
    void findByDirector() {
        Team team = dao.findByDirector("Eusebio Unzue");

        System.out.println(team);
    }

    @Test
    void create() {
        Team team = new Team();

        team.setName("Movistar");
        team.setDirector("Eusebio Unzue");

        Team result = dao.create(team);

        System.out.println(result);
    }

    @Test
    void update() {
        Team team = dao.findByName("Movistar");
        System.out.println(team);
        team.setDirector("Eusebio Unzue Fernandez");

        Team updated = dao.update(team);

        System.out.println(updated);
    }

    @Test
    void deleteByName() {
        boolean deleted = dao.deleteByID("Movistar");

        System.out.println(deleted);
    }
}
