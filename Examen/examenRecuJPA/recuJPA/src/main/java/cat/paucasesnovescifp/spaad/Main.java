package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.dao.*;
import cat.paucasesnovescifp.spaad.jpa.entitats.Category;
import cat.paucasesnovescifp.spaad.jpa.entitats.City;
import cat.paucasesnovescifp.spaad.jpa.entitats.Film;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

//        provaGetFilm(); // 1
//        provaAllCategories(); // 2
//        provaFindCityByCountry(); // 3
//        provaInserirFilm(); // 4
        provaDeleteLanguage(); // 6
//        provaFindFilmByLenght(); // 7
    }

    // 1
    public static void provaGetFilm() {
        try {
            FilmDAOIplm filmDAOIplm = new FilmDAOIplm();
            Film film =filmDAOIplm.getFilm((short) 1);
            System.out.println(film);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 2
    public static void provaAllCategories() {
        CategoryDAO dao = new CategoryDAOIplm();
        List<Category> category = dao.findAll();

        System.out.println(category);
    }

    // 3
    public static void  provaFindCityByCountry() {
        CityDAO dao = new CityDAOIplm();
        List<City> cities = dao.findByCountry(1);

        System.out.println(cities);
    }

    // 4
    public static void provaInserirFilm() {
        Film film = new Film();
        FilmDAO dao = new FilmDAOIplm();

        film.setFilmId((short) 1001);
        film.setTitle("Test");
        film.setDescription("Test");
        film.setRentalDuration((short) 4);
        film.setRentalRate(BigDecimal.valueOf(5));
        film.setLength((short) 124);
        film.setReplacementCost(BigDecimal.valueOf(4));
        film.setRating("G");
        film.setSpecialFeatures("test");

        Film result = dao.create(film);

        System.out.println(result);
    }

    // 5

    // 6
    public static void provaDeleteLanguage() {
        LanguageDAO dao = new LanguageDAOIplm();
        boolean language = dao.deleteById(3);

        System.out.println(language);
    }

    // 7
    public static void provaFindFilmByLenght() {
        FilmDAO dao = new FilmDAOIplm();
        List<Film> film = dao.getByTime(184); // he posat 184 perque a maxima duració es 185, aixi en surten poc i es facil de veure si funciona

        System.out.println(film);
    }

    // 8
}
