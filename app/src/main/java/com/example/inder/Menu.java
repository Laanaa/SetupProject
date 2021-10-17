package com.example.inder;

public class Menu {

    int image;
    String title, desc, price;

    public Menu(int image, String title, String desc, String price){
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public int getImage(){
        return image;
    }

    public String getTitle(){
        return title;
    }

    public String getDesc(){
        return desc;
    }

    public String getPrice(){
        return price;
    }

}