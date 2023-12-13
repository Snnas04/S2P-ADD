package cat.paucasesnovescifp.spaad.dao;

import cat.paucasesnovescifp.spaad.jpa.entitats.City;

import java.util.List;

public interface CityDAO {
    List<City> findByCountry(int country);
}
