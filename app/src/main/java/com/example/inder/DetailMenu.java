package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {

    TextView title;
    TextView desc;
    TextView price;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        title = findViewById(R.id.textTitle);
        image = findViewById(R.id.image);
        desc = findViewById(R.id.textDescription);
        price = findViewById(R.id.textPrice);

        Intent intentInput = getIntent();
        String titleText = intentInput.getStringExtra("title");
        Bitmap imageBitmap = (Bitmap) intentInput.getExtras().get("image");
        String descText = intentInput.getStringExtra("desc");
        String priceText = intentInput.getStringExtra("price");

        title.setText(titleText);
        image.setImageBitmap(imageBitmap);
        desc.setText(descText);
        price.setText("Rp." + priceText);
    }
}