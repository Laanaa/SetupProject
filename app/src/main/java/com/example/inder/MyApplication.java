package com.example.inder;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    public List<Menu> menuList;

    @Override
    public void onCreate() {
        super.onCreate();
        menuList = new ArrayList<>();
    }

    //    private String someVariable;

    public List<Menu> getMenu() {
        return menuList;
    }
//
//    public void setSomeVariable(String someVariable) {
//        this.someVariable = someVariable;
//    }
}
