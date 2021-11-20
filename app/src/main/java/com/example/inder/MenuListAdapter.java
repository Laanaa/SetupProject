package com.example.inder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MenuListAdapter extends ArrayAdapter<Menu> {
    private static final String TAG = "MenuListAdapter";
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
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //getting the view
        //njupuk xml
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.textTitle);
        TextView desc = view.findViewById(R.id.textDescription);
        TextView price = view.findViewById(R.id.textPrice);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        Button btnDecrease = view.findViewById(R.id.btnDecrease);
        TextView textTotal = view.findViewById(R.id.textTotal);
        Button btnIncrease = view.findViewById(R.id.btnIncrease);
        LinearLayout layoutAdd = view.findViewById(R.id.layoutAdd);
        LinearLayout layoutTotal = view.findViewById(R.id.layoutTotal);

        LinearLayout layoutDisplay = view.findViewById(R.id.layoutDisplay);

        //getting the specified position
        Menu menu = menuList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(menu.getImage()));
        title.setText(menu.getTitle());
        desc.setText(menu.getDesc());
        price.setText(menu.getPrice());
        textTotal.setText("");

        layoutDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + "YOO");
                int image =  menuList.get(position).image;
                String title =  menuList.get(position).title;
                String price = menuList.get(position).price;
                System.out.println(image);
                Intent myIntent = new Intent(view.getContext(), DetailMenu.class);
                myIntent.putExtra("image", image);
                myIntent.putExtra("title", title);
                myIntent.putExtra("desc", menuList.get(position).desc);
                myIntent.putExtra("price", price);
//                Intent myIntent = new Intent(this, MenuActivity.class);
//                Log.d(TAG, "onCreate: 2");
                Activity activity = (Activity) context;
                activity.startActivity(myIntent);
//                Log.d(TAG, "onCreate: 3");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutTotal.setVisibility(View.VISIBLE);
                layoutAdd.setVisibility(View.GONE);
                menu.incTotal();
                textTotal.setText(String.valueOf(menu.getTotal()));
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.decTotal();
                textTotal.setText(String.valueOf(menu.getTotal()));
                if (menu.getTotal() == 0){
                    layoutTotal.setVisibility(View.GONE);
                    layoutAdd.setVisibility(View.VISIBLE);
                }
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.incTotal();
                textTotal.setText(String.valueOf(menu.getTotal()));
            }
        });

        return view;
    }
}


