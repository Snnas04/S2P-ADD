package entities;

import javax.persistence.*;

@Entity
public class Team {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_team")
    private byte idTeam;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "director")
    private String director;

    public byte getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(byte idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (idTeam != team.idTeam) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (director != null ? !director.equals(team.director) : team.director != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idTeam;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "idTeam=" + idTeam +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                '}' + "\n";
    }
}
