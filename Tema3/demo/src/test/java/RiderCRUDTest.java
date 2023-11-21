import dao.RaiderDAOImpl;
import dao.RiderDAO;
import entities.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RiderCRUDTest {
    RiderDAO dao;

    @BeforeEach
    void setUp() {
        dao = new RaiderDAOImpl();
    }

    @Test
    void findAll() {
        List<Rider> riders = dao.findAll();

        System.out.println(riders);
    }

    @Test
    void findByDorsal() {
        Rider rider = dao.findByDorsal(10);

        System.out.println(rider);
    }

    @Test
    void findByCountry() {
        List<Rider> riders = dao.findByCountry("Spain");

        System.out.println(riders);
    }

    @Test
    void create() {
        Rider rider = new Rider();

        rider.setDorsal(400);
        rider.setName("Pepito");
        rider.setAge(20);
        rider.setCountry("Spain");

        Rider result = dao.create(rider);

        System.out.println(result);
    }

    @Test
    void update() {
        Rider rider = dao.findByDorsal(400);
        System.out.println(rider);
        rider.setName("Pepito Grillo");

        Rider updated = dao.update(rider);

        System.out.println(updated);
    }

    @Test
    void deleteByDorsal() {
        boolean result = dao.deleteByDorsal(400);
        System.out.println(result);
    }
}
