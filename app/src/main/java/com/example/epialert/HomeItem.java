package com.example.epialert;

public class HomeItem {
    public int image;
    public String Name;
    public String Description;

    public HomeItem(int image, String name, String description) {
        this.image = image;
        Name = name;
        Description = description;
    }

    public HomeItem() {

    }

    @Override
    public String toString() {
        return "HomeItem{" +
                "image=" + image +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
