package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartMenuActivity(View view) {
        Intent myIntent = new Intent(this, Menu.class);
        startActivity(myIntent);
    }

    public void onStartTransactionActivity(View view) {
        Intent myIntent = new Intent(this, Transaction.class);
        startActivity(myIntent);
    }

    public void onStartOrderActivity(View view) {
        Intent myIntent = new Intent(this, Order.class);
        startActivity(myIntent);
    }
}