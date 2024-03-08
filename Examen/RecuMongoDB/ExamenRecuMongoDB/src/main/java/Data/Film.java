package Data;

import java.util.ArrayList;
import java.util.Objects;

public class Film {
    private String title;
    private String plot;
    private int year;
    private int runtime;
    private String cast;
    private IMDB imdb;
    private String type;

    public Film(String title, String plot, int year, int runtime, String cast, IMDB imdb, String type) {
        this.title = title;
        this.plot = plot;
        this.year = year;
        this.runtime = runtime;
        this.cast = cast;
        this.imdb = imdb;
        this.type = type;
    }

    public Film(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", plot='" + plot + '\'' +
                ", year=" + year +
                ", runtime=" + runtime +
                ", cast='" + cast + '\'' +
                ", imdb='" + imdb + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public IMDB getImdb() {
        return imdb;
    }

    public void setImdb(IMDB imdb) {
        this.imdb = imdb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
