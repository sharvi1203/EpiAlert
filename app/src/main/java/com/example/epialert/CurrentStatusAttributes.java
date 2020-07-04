package com.example.epialert;

import java.io.Serializable;

public class CurrentStatusAttributes implements Serializable {
    public  int image;
    public  String Name;
    public  String range;

    public CurrentStatusAttributes() {
    }

    public CurrentStatusAttributes(int image, String name, String range) {
        this.image = image;
        Name = name;
        this.range = range;
    }

    @Override
    public String toString() {
        return "CurrentStatusAttributes{" +
                "image=" + image +
                ", Name='" + Name + '\'' +
                ", range='" + range + '\'' +
                '}';
    }
}
