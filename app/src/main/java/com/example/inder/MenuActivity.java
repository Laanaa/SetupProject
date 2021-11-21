package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity";
    List<Menu> menuList;
    ListView listView;
    Button btnCatalog;

    SQLiteDatabase db;
    private static final String DB_INDER = "inderDB.db";
    private static final String TABLE_CATALOG = "catalog";
    Cursor result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Log.d(TAG, "onCreate: " + "1");
//        homeList = new ArrayList<>();
        menuList = ((MyApplication) this.getApplication()).getMenu();
        Log.d(TAG, "onCreate: " + "2");
        listView = (ListView) findViewById(R.id.menuList);
        Log.d(TAG, "onCreate: " + "3");
        loadMenuData();
        Log.d(TAG, "onCreate: " + "4");

//        Button btnCatalog = findViewById(R.id.btnCatalog);

//        btnCatalog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(MenuActivity.this, CatalogActivity.class);
//                startActivity(myIntent);
//            }
//        });


        //untuk menambahkan data baru
//        menuList.add(new Menu(R.drawable._38483109, "Pancong", "Pancong dengan beraneka rasa", "Rp. 20.000"));
//        menuList.add(new Menu(R.drawable.rotibakar, "Roti Bakar", "Roti dengan bakaran yang merata dengan varian rasa yang beragam", "Rp. 18.000"));
//        menuList.add(new Menu(R.drawable.basoaci, "Baso Aci", "Baso aci cocok untuk orang yang suka aci dan tantangan pedas", "Rp. 20.000"));
//        menuList.add(new Menu(R.drawable.mie_kuah_pedas_pengusahasukses_314x314, "Mie Kuah", "Mie kuah dengan tambahan toping yang dapat dipilih sendiri", "Rp. 15.000"));
//        menuList.add(new Menu(R.drawable.mie_goreng_magelangan_pedas, "Mie Goreng", "Mie goreng dengan tambahan toping yang dapat dipilih sendiri", "Rp. 15.000"));
//        menuList.add(new Menu(R.drawable.mangopunch, "Mango Punch", "Minuman non coffe dengan campuran sari buah mangga dan yakult", "Rp. 23.000"));
//        menuList.add(new Menu(R.drawable.cappuccino_1, "Cappuccino", "Coffe paling laris dengan kemanisan yang bisa diatur", "Rp. 18.000"));
//        menuList.add(new Menu(R.drawable.latte, "Latte", "Coffe dengan tingkat kemanisan yang tidak terlalu manis", "Rp. 18.000"));
//        menuList.add(new Menu(R.drawable.redvalvet, "Red Valvet", "Minuman non coffe, cocok untuk penyuka minuman manis dengan rasa unik", "Rp. 24.000"));
//        menuList.add(new Menu(R.drawable.panduan_singkat_cara_membuat_kopi_espresso, "Espresso", "Espresso rasa kopi yang sesungguhnya", "Rp. 15.000"));
//        MenuListAdapter adapter = new MenuListAdapter(MenuActivity.this, R.layout.list_layout_menu, menuList);
//
//        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d(TAG, "onItemClick: " + position);
//                int image =  menuList.get(position).image;
//                String title =  menuList.get(position).title;
//                String price = menuList.get(position).price;
//                System.out.println(image);
//                Intent myIntent = new Intent(view.getContext(), DetailMenu.class);
//                myIntent.putExtra("image", image);
//                myIntent.putExtra("title", title);
//                myIntent.putExtra("desc", menuList.get(position).desc);
//                myIntent.putExtra("price", price);
////                Intent myIntent = new Intent(this, MenuActivity.class);
////                Log.d(TAG, "onCreate: 2");
//                startActivity(myIntent);
////                Log.d(TAG, "onCreate: 3");
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        MenuListAdapter adapter = new MenuListAdapter(MenuActivity.this, R.layout.list_layout_menu, menuList);
        listView.setAdapter(adapter);
    }

    private void loadMenuData(){
        Log.d(TAG, "loadMenuData: " + "HERE");
        db = openOrCreateDatabase(DB_INDER, Context.MODE_PRIVATE, null);

        String query = "SELECT * FROM " + TABLE_CATALOG;
        Log.d(TAG, "onCreate: " + query);
        result = db.rawQuery(query, null);

        menuList.clear();

        if (result.moveToFirst()) {
            do {
                String ID, NAME, DESCRIPTION, PRICE;
                byte[] IMAGE;
//                ID = result.getString(0);
                NAME = result.getString(1);
                DESCRIPTION = result.getString(2);
                PRICE = result.getString(3);
//                IMAGE = result.getString(4);

                IMAGE = result.getBlob(4);

                Bitmap imageBitmap = BitmapFactory.decodeByteArray(IMAGE, 0, IMAGE.length);
//                imageView.setImageBitmap(imageBitmap);

                menuList.add(new Menu(imageBitmap, NAME, DESCRIPTION, PRICE));
                MenuListAdapter adapter = new MenuListAdapter(MenuActivity.this, R.layout.list_layout_menu, menuList);
                listView.setAdapter(adapter);

            } while (result.moveToNext());
        }

        db.close();

    }
}
