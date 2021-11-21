package com.example.inder;

import android.graphics.Bitmap;

public class Menu {

    int total;
    String title, desc, price;
    Bitmap image;

    public Menu(Bitmap image, String title, String desc, String price){
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.total = 0;
    }

    public Bitmap getImage(){
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

    public int getTotal(){ return total;}

    public void incTotal(){
        total += 1;
    }

    public void decTotal(){
        total -= 1;
        if (total < 0) {
            total = 0;
        }
    }
}