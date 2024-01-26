package Data;

public class Subject {
    private String code;
    private String name;
    private String course;

    public Subject(String code, String name, String course) {
        this.code = code;
        this.name = name;
        this.course = course;
    }

    public String getCodi() {
        return code;
    }

    public void setCodi(String code) {
        this.code = code;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getCurs() {
        return course;
    }

    public void setCurs(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
