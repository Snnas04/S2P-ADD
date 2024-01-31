package Data;

public class Subject2 {
    private String code;
    private String name;
    private Course course;

    public Subject2(String code, String name, Course course) {
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

    public Course getCurs() {
        return course;
    }

    public void setCurs(Course course) {
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
