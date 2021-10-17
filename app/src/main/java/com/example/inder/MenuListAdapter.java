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

public class MenuListAdapter extends ArrayAdapter<Menu> {
    List<Menu> menuList;

    Context context;

    int resource;

    public MenuListAdapter(Context context, int resource, List<Menu> homeList){
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
        //
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        //njupuk xml
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.textTitle);
        TextView desc = view.findViewById(R.id.textDescription);
        TextView price = view.findViewById(R.id.textPrice);

        //getting the specified position
        Menu home = menuList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(home.getImage()));
        title.setText(home.getTitle());
        desc.setText(home.getDesc());
        price.setText(home.getPrice());

        return view;
    }
}


