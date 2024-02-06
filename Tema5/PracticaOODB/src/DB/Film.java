package DB;

import java.util.List;

public class Film {
    private String id;
    private String title;
    private String duration;
    private String director;
    private String plot;
    private String genre;
    private String rating;
    private List<Actor> actors;

    public Film(String id, String title, String duration, String director, String plot, String genre, String rating,
                List<Actor> actors) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.plot = plot;
        this.genre = genre;
        this.rating = rating;
        this.actors = actors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", director='" + director + '\'' +
                ", plot='" + plot + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                ", actors=" + actors +
                "}\n";
    }
}
