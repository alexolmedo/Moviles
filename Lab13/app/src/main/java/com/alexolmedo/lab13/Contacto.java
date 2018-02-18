package com.alexolmedo.lab13;

/**
 * Created by Alexander on 19/12/2017.
 */

public class Contacto {
    private String _id;
    private String _name;
    private String _email;
    private String _address;
    private String _gender;

    public Contacto() {
    }

    public Contacto(String _id, String _name, String _email, String _address, String _gender) {
        this._id = _id;
        this._name = _name;
        this._email = _email;
        this._address = _address;
        this._gender = _gender;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    @Override
    public String toString() {
        return _name;
    }
}
