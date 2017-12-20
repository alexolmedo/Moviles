package com.alexolmedo.olmedoalexander;

/**
 * Created by Alexander on 20/12/2017.
 */

public class Nota {
    private int codigo;
    private String materia;
    private String nota;

    public Nota() {
    }

    public Nota(int codigo, String materia, String nota) {
        this.codigo = codigo;
        this.materia = materia;
        this.nota = nota;
    }

    public Nota(String materia, String nota) {
        this.materia = materia;
        this.nota = nota;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "codigo=" + codigo +
                ", materia='" + materia + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
