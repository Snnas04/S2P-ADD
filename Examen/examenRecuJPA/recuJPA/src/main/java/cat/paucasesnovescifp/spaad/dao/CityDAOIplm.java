package cat.paucasesnovescifp.spaad.dao;

import cat.paucasesnovescifp.spaad.auxiliars.JPAUtiles;
import cat.paucasesnovescifp.spaad.jpa.entitats.City;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAOIplm implements CityDAO {
    @Override
    public List<City> findByCountry(int  country) {
        EntityManager em = JPAUtiles.getEntityManager();

        TypedQuery<City> query = em.createQuery("select c from City c where c.countryId = :country_id", City.class);
        query.setParameter("country_id", country);

        List<City> cities = query.getResultList();

        return cities;
    }
}
