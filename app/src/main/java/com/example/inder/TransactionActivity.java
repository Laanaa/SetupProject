package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;

import android.os.Bundle;

public class TransactionActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity";
    List<Menu> menuList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Log.d(TAG, "onCreate: ");
//        homeList = new ArrayList<>();
        menuList = ((MyApplication) this.getApplication()).getMenu();
        Log.d(TAG, "onCreate: ");
        listView = (ListView) findViewById(R.id.menuList);
        Log.d(TAG, "onCreate: ");

        //untuk menambahkan data baru
        menuList.add(new Menu(R.drawable._38483109, "Pancong", "Pancong dengan beraneka rasa", "Rp. 20.000"));
        menuList.add(new Menu(R.drawable.rotibakar, "Roti Bakar", "Roti dengan bakaran yang merata dengan varian rasa yang beragam", "Rp. 18.000"));
        menuList.add(new Menu(R.drawable.basoaci, "Baso Aci", "Baso aci cocok untuk orang yang suka aci dan tantangan pedas", "Rp. 20.000"));
        menuList.add(new Menu(R.drawable.mie_kuah_pedas_pengusahasukses_314x314, "Mie Kuah", "Mie kuah dengan tambahan toping yang dapat dipilih sendiri", "Rp. 15.000"));
        menuList.add(new Menu(R.drawable.mie_goreng_magelangan_pedas, "Mie Goreng", "Mie goreng dengan tambahan toping yang dapat dipilih sendiri", "Rp. 15.000"));
        menuList.add(new Menu(R.drawable.mangopunch, "Mango Punch", "Minuman non coffe dengan campuran sari buah mangga dan yakult", "Rp. 23.000"));
        menuList.add(new Menu(R.drawable.cappuccino_1, "Cappuccino", "Coffe paling laris dengan kemanisan yang bisa diatur", "Rp. 18.000"));
        menuList.add(new Menu(R.drawable.latte, "Latte", "Coffe dengan tingkat kemanisan yang tidak terlalu manis", "Rp. 18.000"));
        menuList.add(new Menu(R.drawable.redvalvet, "Red Valvet", "Minuman non coffe, cocok untuk penyuka minuman manis dengan rasa unik", "Rp. 24.000"));
        menuList.add(new Menu(R.drawable.panduan_singkat_cara_membuat_kopi_espresso, "Espresso", "Espresso rasa kopi yang sesungguhnya", "Rp. 15.000"));
        TransactionListAdpter adapter = new TransactionListAdpter(TransactionActivity.this, R.layout.list_layout_transaction, menuList);

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
        TransactionListAdpter adapter = new TransactionListAdpter(TransactionActivity.this, R.layout.list_layout_menu, menuList);
        listView.setAdapter(adapter);
    }
}