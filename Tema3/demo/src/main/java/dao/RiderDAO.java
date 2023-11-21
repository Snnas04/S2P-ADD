package dao;

import entities.Rider;

import java.util.List;

public interface RiderDAO {
    List<Rider> findAll();
    Rider findByDorsal(int dorsal);
    List<Rider> findByCountry(String country);
    Rider create(Rider rider);
    Rider update(Rider rider);
    boolean deleteByDorsal(int dorsal);
}
