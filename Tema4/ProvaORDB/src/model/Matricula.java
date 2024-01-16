package model;

import java.math.BigDecimal;

public class Matricula {
private Alumne alumne;
    private Assignatura assignatura;
    private BigDecimal[] nota; // BigDeciaml perque es un numero decimal a la base de dades

    public Matricula(Alumne alumne, Assignatura assignatura, BigDecimal[] nota) {
        this.alumne = alumne;
        this.assignatura = assignatura;
        this.nota = nota;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public Assignatura getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
    }

    public BigDecimal[] getNota() {
        return nota;
    }

    public void setNota(BigDecimal[] nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Matricula {\n" +
                "alumne = " + alumne + '\n' +
                "assignatura = " + assignatura + '\n' +
                "nota = " + nota + '\n' +
                '}';
    }
}
