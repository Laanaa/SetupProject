package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button btnMenu, btnTransaction, btnOrder, btnCatalog;
    SQLiteDatabase db;
    private static final String DB_INDER = "inderDB.db";
    private static final String TABLE_CATALOG = "catalog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTable();
        btnMenu = findViewById(R.id.btnMenu);
        btnTransaction = findViewById(R.id.btnTransaction);
        btnOrder = findViewById(R.id.btnOrder);
        btnCatalog = findViewById(R.id.btnCatalog);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartMenuActivity(v);
            }
        });
        btnTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartTransactionActivity(v);
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartOrderActivity(v);
            }
        });
        btnCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CatalogActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public void onStartMenuActivity(View view) {
        Log.d(TAG, "onCreate: 1");
        Intent myIntent = new Intent(this, MenuActivity.class);
        Log.d(TAG, "onCreate: 2");
        startActivity(myIntent);
        Log.d(TAG, "onCreate: 3");
    }

    public void onStartTransactionActivity(View view) {
        Intent myIntent = new Intent(this, TransactionActivity.class);
        startActivity(myIntent);
    }

    public void onStartOrderActivity(View view) {
        Intent myIntent = new Intent(this, Order.class);
        startActivity(myIntent);
    }

    public void createTable(){
        db = openOrCreateDatabase(DB_INDER, Context.MODE_PRIVATE, null);

        String query = "CREATE TABLE IF NOT EXISTS "
                + TABLE_CATALOG
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, PRICE NUMBER, IMAGE BLOB);";
        Log.d(TAG, "onCreate: " + query);
        db.execSQL(query);
        db.close();
    }
}