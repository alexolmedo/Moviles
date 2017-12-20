package com.alexolmedo.lab6;

/**
 * Created by Alexander on 19/12/2017.
 */

public class Caso {
    private int _id;
    private String _cliente;
    private String _fechaInicio;
    private String _fechaFin;
    private String _estado;

    public Caso() {
    }

    public Caso(int _id, String _cliente, String _fechaInicio, String _fechaFin, String _estado) {
        this._id = _id;
        this._cliente = _cliente;
        this._fechaInicio = _fechaInicio;
        this._fechaFin = _fechaFin;
        this._estado = _estado;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_cliente() {
        return _cliente;
    }

    public void set_cliente(String _cliente) {
        this._cliente = _cliente;
    }

    public String get_fechaInicio() {
        return _fechaInicio;
    }

    public void set_fechaInicio(String _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }

    public String get_fechaFin() {
        return _fechaFin;
    }

    public void set_fechaFin(String _fechaFin) {
        this._fechaFin = _fechaFin;
    }

    public String get_estado() {
        return _estado;
    }

    public void set_estado(String _estado) {
        this._estado = _estado;
    }

    @Override
    public String toString() {
        return "Caso{" +
                "_id=" + _id +
                ", _cliente='" + _cliente + '\'' +
                ", _fechaInicio='" + _fechaInicio + '\'' +
                ", _fechaFin='" + _fechaFin + '\'' +
                ", _estado='" + _estado + '\'' +
                '}';
    }
}
