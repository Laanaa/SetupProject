package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button btnMenu, btnTransaction, btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btnMenu);
        btnTransaction = findViewById(R.id.btnTransaction);
        btnOrder = findViewById(R.id.btnOrder);
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
}