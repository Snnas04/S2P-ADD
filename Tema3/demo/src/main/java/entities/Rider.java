package entities;

import javax.persistence.*;

@Entity
//@NamedQueries(name = "rider.byTeam", "SELECT r FROM ");
public class Rider {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dorsal")
    private int dorsal;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "country")
    private String country;
    @ManyToOne
    @JoinColumn(name = "team", referencedColumnName = "id_team")
    private Team teamObject;

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rider rider = (Rider) o;

        if (dorsal != rider.dorsal) return false;
        if (age != null ? !age.equals(rider.age) : rider.age != null) return false;
        if (name != null ? !name.equals(rider.name) : rider.name != null) return false;
        if (country != null ? !country.equals(rider.country) : rider.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dorsal;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public Team getTeamObject() {
        return teamObject;
    }

    public void setTeamObject(Team teamObject) {
        this.teamObject = teamObject;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "dorsal=" + dorsal +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", teamObject=" + teamObject +
                '}';
    }
}
