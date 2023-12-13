package cat.paucasesnovescifp.spaad.dao;

import cat.paucasesnovescifp.spaad.jpa.entitats.Film;

import java.util.List;

public interface FilmDAO {
    Film getFilm(short id);
    List<Film> getByTime(int filmLenght);
    Film create(Film film);
}
