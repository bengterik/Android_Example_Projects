package com.example.root_layout_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = this.getIntent();

        String extra_string = i.getStringExtra(MainActivity.PARAMETER_1_NAME);
        int extra_int = i.getIntExtra(MainActivity.PARAMETER_2_NAME, -1);

        TextView txt = findViewById(R.id.show_text);
        txt.setText(extra_int);
    }
}