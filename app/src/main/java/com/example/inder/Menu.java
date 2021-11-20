package com.example.inder;

public class Menu {

    int image, total;
    String title, desc, price;

    public Menu(int image, String title, String desc, String price){
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.total = 0;
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