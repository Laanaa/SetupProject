package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {

    TextView title;
    TextView desc;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        title = findViewById(R.id.textTitle);
        image = findViewById(R.id.image);
        desc = findViewById(R.id.textDescription);

        Intent intentInput = getIntent();
        String titleText = intentInput.getStringExtra("title");
        int imageId = intentInput.getIntExtra("sampah", -1);
        String descText = intentInput.getStringExtra("desc");

        title.setText(titleText);
        image.setImageDrawable(getApplicationContext().getResources().getDrawable(imageId));
        desc.setText(descText);
    }
}