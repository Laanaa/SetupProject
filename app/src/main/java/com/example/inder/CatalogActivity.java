package com.example.inder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class CatalogActivity extends AppCompatActivity {

    private static final String TAG = "CatalogActivity";
    SQLiteDatabase db;
    private static final String DB_INDER = "inderDB.db";
    private static final String TABLE_CATALOG = "catalog";
    private static final String TABLE_TRANSACTION = "transaction";
    private static final String TABLE_TRANSACTION_DETAIL = "transaction_detail";
    EditText name, description, price;
    private static final int PICK_IMAGE_ID = 234; // the number doesn't matter
    Bitmap imageBitmap;
    Button add, show;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        name = (EditText) findViewById(R.id.name);
        description = (EditText) findViewById(R.id.description);
        price = (EditText) findViewById(R.id.price);
        image =  findViewById(R.id.addImage);
        add = (Button) findViewById(R.id.btnAdd);
        show = (Button) findViewById(R.id.btnShow);

//        db = openOrCreateDatabase(DB_INDER, Context.MODE_PRIVATE, null);
//
//        String query = "CREATE TABLE IF NOT EXISTS "
//                + TABLE_CATALOG
//                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, PRICE NUMBER, IMAGE BLOB);";
//        Log.d(TAG, "onCreate: " + query);
//        db.execSQL(query);
//        db.close();

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageBitmap = null;
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                Intent chooseImageIntent = ImagePicker.getPickImageIntent(CatalogActivity.this);
                startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                db = openOrCreateDatabase(DB_INDER, Context.MODE_PRIVATE, null);

                String query = "INSERT INTO " + TABLE_CATALOG + "(NAME, DESCRIPTION, PRICE, IMAGE) VALUES('"
                        + name.getText().toString()
                        + "', '" + description.getText()
                        + "', '" + price.getText()
                        + "', X'" + byteToHexString(getBitmapAsByteArray(imageBitmap)) + "');";
                Log.d(TAG, "onClick: " + query);
                db.execSQL(query);
                db.close();
                name.getText().clear();
                description.getText().clear();
                price.getText().clear();
                image.setImageResource(0);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Add Menu Success",
                        Toast.LENGTH_SHORT);

                toast.show();
            }
        });
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                String abc = name.getText().toString();
//                Intent i = new Intent(CatalogActivity.this, ViewCatalog.class);
//                i.putExtra("hello", abc);
//                startActivity(i);
//                name.getText().clear();
//            }
//        });
    }
    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case PICK_IMAGE_ID:
                imageBitmap = ImagePicker.getImageFromResult(CatalogActivity.this, resultCode, data);
                // TODO use bitmap
                image.setImageBitmap(imageBitmap);
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    private String byteToHexString(byte[] payload) {
        if (payload == null) return "<empty>";
        StringBuilder stringBuilder = new StringBuilder(payload.length);
        for (byte byteChar : payload)
            stringBuilder.append(String.format("%02X", byteChar));
        return stringBuilder.toString();
    }

}