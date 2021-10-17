package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartMenuActivity(View view) {
        Log.d(TAG, "onCreate: 1");
        Intent myIntent = new Intent(this, MenuActivity.class);
        Log.d(TAG, "onCreate: 2");
        startActivity(myIntent);
        Log.d(TAG, "onCreate: 3");
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