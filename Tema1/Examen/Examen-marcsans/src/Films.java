import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Films {
    private ArrayList<Film> films = new ArrayList<Film>();

    public Films() {}

    public Films(ArrayList<Film> films) {
        this.films = films;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Films{" +
                "films=" + films +
                '}';
    }
}
