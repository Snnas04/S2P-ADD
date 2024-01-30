package models;

import org.postgresql.util.PGobject;

import java.sql.SQLException;

import static Utile.EinesCadenes.parseValue;
import static Utile.EinesCadenes.tanca;

public class Address extends PGobject {
    private String carrer;
    private String localitat;
    private String cp;
    private String pais;

    public Address() {
    }

    public Address(String carrer, String localitat, String cp, String pais) {
        this.carrer = carrer;
        this.localitat = localitat;
        this.cp = cp;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Address{" +
                "carrer='" + carrer + '\'' +
                ", localitat='" + localitat + '\'' +
                ", cp='" + cp + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    @Override
    public String getValue() {
        String result = "(";
        result += tanca(carrer) + ",";
        result += tanca(localitat) + ",";
        result += tanca(cp) + ",";
        result += tanca(pais) + ")";

        return result;
    }

    @Override
    public void setValue(String value) throws SQLException {
        super.setValue(value);

        String[] atrubuts = parseValue(value);

        carrer = atrubuts[0];
        localitat = atrubuts[1];
        cp = atrubuts[2];
        pais = atrubuts[3];
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getLocalitat() {
        return localitat;
    }

    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
