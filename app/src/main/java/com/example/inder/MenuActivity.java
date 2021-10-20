package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity";
    List<Menu> menuList;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.d(TAG, "onCreate: ");
//        homeList = new ArrayList<>();
        menuList = ((MyApplication) this.getApplication()).getMenu();
        Log.d(TAG, "onCreate: ");
        listView = (ListView) findViewById(R.id.menuList);
        Log.d(TAG, "onCreate: ");

        //untuk menambahkan data baru
        menuList.add(new Menu(R.drawable._38483109, "Pancong ", "Pancong dengan beraneka rasa", "Rp. 20.000"));
        menuList.add(new Menu(R.drawable.panduan_singkat_cara_membuat_kopi_espresso, "Espresso", "Espresso rasa kopi yang sesungguhnya", "Rp. 15.000"));
        MenuListAdapter adapter = new MenuListAdapter(MenuActivity.this, R.layout.list_layout_menu, menuList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int image =  menuList.get(position).image;
                String title =  menuList.get(position).title;
                System.out.println(image);
                Intent myIntent = new Intent(view.getContext(), DetailMenu.class);
                myIntent.putExtra("image", image);
                myIntent.putExtra("title", title);
                myIntent.putExtra("desc", menuList.get(position).desc);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        MenuListAdapter adapter = new MenuListAdapter(MenuActivity.this, R.layout.list_layout_menu, menuList);
        listView.setAdapter(adapter);
    }
}
