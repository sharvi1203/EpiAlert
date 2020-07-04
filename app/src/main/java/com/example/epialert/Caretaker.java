package com.example.epialert;

import java.io.Serializable;

public class Caretaker implements Serializable {
        public String Name;
        public String Phone;
        public String EmailAdd;
        public String Address;
        public String Password;
        public String InviteCode;

        public Caretaker() {
        }

        public Caretaker(String name, String phone, String emailAdd, String address, String password, String inviteCode) {
            Name = name;
            Phone = phone;
            EmailAdd = emailAdd;
            Address = address;
            Password = password;
            InviteCode = inviteCode;
        }

    @Override
    public String toString() {
        return "Caretaker{" +
                "Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", EmailAdd='" + EmailAdd + '\'' +
                ", Address='" + Address + '\'' +
                ", Password='" + Password + '\'' +
                ", InviteCode='" + InviteCode + '\'' +
                '}';
    }
}
