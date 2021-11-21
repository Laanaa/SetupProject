package com.example.inder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TransactionListAdpter extends ArrayAdapter<Menu>{
    List<Menu> menuList;

    Context context;

    int resource;

    public TransactionListAdpter(Context context, int resource, List<Menu> homeList){
        super(context, resource, homeList);
        this.context = context;
        this.resource = resource;
        this.menuList = homeList;
    }
    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Get the view of the xml for our list item
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //getting the view
        //njupuk xml
        View view = layoutInflater.inflate(resource, null, false);

        return view;
    }
}
