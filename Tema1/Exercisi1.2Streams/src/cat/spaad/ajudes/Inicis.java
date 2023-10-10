package cat.spaad.ajudes;

import java.io.Serializable;
import java.util.Objects;

public class Inicis implements Serializable {

    private int num;
    private String alfa;

    public Inicis() {
    }

    public Inicis(int num, String alfa) {
        this.num = num;
        this.alfa = alfa;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAlfa() {
        return alfa;
    }

    public void setAlfa(String alfa) {
        this.alfa = alfa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inicis inicis = (Inicis) o;
        return num == inicis.num && Objects.equals(alfa, inicis.alfa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, alfa);
    }

    @Override
    public String toString() {
        return "Inicis{" +
                "num=" + num +
                ", alfa='" + alfa + '\'' +
                '}';
    }
}
