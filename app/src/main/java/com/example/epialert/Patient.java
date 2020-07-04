package com.example.epialert;

import java.io.Serializable;

public class Patient implements Serializable {
    public String name;
    public String Phone;
    public String DOB;
    public String EmailAdd;
    public String  password;
    public String Address;
    public String CaretakersName;
    public String CaretakersPhone;

    public Patient() {
    }

    public Patient(String name, String phone, String DOB, String emailAdd, String password, String address, String caretakersName, String caretakersPhone) {
        this.name = name;
        Phone = phone;
        this.DOB = DOB;
        EmailAdd = emailAdd;
        this.password = password;
        Address = address;
        CaretakersName = caretakersName;
        CaretakersPhone = caretakersPhone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", DOB='" + DOB + '\'' +
                ", EmailAdd='" + EmailAdd + '\'' +
                ", password='" + password + '\'' +
                ", Address='" + Address + '\'' +
                ", CaretakersName='" + CaretakersName + '\'' +
                ", CaretakersPhone='" + CaretakersPhone + '\'' +
                '}';
    }
}
