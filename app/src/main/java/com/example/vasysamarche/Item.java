package com.example.vasysamarche;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private String description;
    private String imageResId;

    public Item(String name, String description, String imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    public  String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getDescription() {return description;    }
    public void setDescription(String description){this.description=description;}


    public String getImageResId() {
        return imageResId;
    }
    public void setImageResId(String imageResId){this.imageResId=imageResId;}

    @Override
    public String toString() {
        return name;
    }
}
