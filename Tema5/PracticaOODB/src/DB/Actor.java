package DB;

public class Actor {
    private int id;
    private String name;
    private String birthdate;
    private String deathdate;
    private String nationality;

    public Actor(int id, String name, String birthdate, String deathdate, String nationality) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(String deathdate) {
        this.deathdate = deathdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", deathdate='" + deathdate + '\'' +
                ", nationality='" + nationality + '\'' +
                "}\n";
    }
}
