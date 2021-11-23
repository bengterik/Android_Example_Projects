package com.example.intentssecondday;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final int OPEN_IMAGE_REQUEST_CODE = 1;
    private static final int OPEN_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenImage = findViewById(R.id.btn_open_image);
        btnOpenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOpenImage = new Intent(Intent.ACTION_GET_CONTENT);
                intentOpenImage.setType("image/*");
                intentOpenImage.addCategory(Intent.CATEGORY_OPENABLE);
            }
        });

        Button btnShare = findViewById(R.id.btn_send);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode){
                case OPEN_IMAGE_REQUEST_CODE:
                    InputStream stream = null;
                    try {
                        stream = getContentResolver().openInputStream(data.getData());
                        Bitmap bitmap = BitmapFactory.decodeStream(stream);
                        ((ImageView)findViewById(R.id.imageView)).setImageBitmap(bitmap);
                    } catch (Exception e) {
                        Log.e("MainActivity",e.getMessage());
                    } finally {
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case OPEN_REQUEST_CODE:
                    // do other things
                    break;
            }
        }
    }
}