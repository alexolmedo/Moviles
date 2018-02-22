package com.alexolmedo.olmedoalexander;

public class Usuario {
    private String _usuario;
    private String _nombre;
    private String _fechaNacimiento;
    private String _cedula;
    private String _password;

    public Usuario() {
    }

    public Usuario(String _usuario, String _nombre, String _fechaNacimiento, String _cedula, String _password) {
        this._usuario = _usuario;
        this._nombre = _nombre;
        this._fechaNacimiento = _fechaNacimiento;
        this._cedula = _cedula;
        this._password = _password;
    }

    public String get_usuario() {
        return _usuario;
    }

    public void set_usuario(String _usuario) {
        this._usuario = _usuario;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_fechaNacimiento() {
        return _fechaNacimiento;
    }

    public void set_fechaNacimiento(String _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }

    public String get_cedula() {
        return _cedula;
    }

    public void set_cedula(String _cedula) {
        this._cedula = _cedula;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    @Override
    public String toString() {
        return _nombre;
    }
}
