package com.example.root_layout_example;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static public final String PARAMETER_1_NAME = "parameter1";
    static public final String PARAMETER_2_NAME = "parameter2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText field_nbr = findViewById(R.id.textField_nbr);

        Button btn_call = findViewById(R.id.button_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = field_nbr.getText().toString();

                if (phoneNumber.trim() != "") {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    ComponentName cn = intent.resolveActivity(getPackageManager());

                    if (cn != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "The app does not have permission to make a call", Toast.LENGTH_SHORT);
                    }
                }
            }
        });

        Button btn_next = findViewById(R.id.button_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                String phoneNumber = field_nbr.getText().toString();

                Intent iNext = new Intent(MainActivity.this, MainActivity2.class);
                iNext.putExtra(PARAMETER_1_NAME, phoneNumber);

                int phone_number = -1;

                try {
                    phone_number = Integer.parseInt(phoneNumber);
                } catch (Exception e) {
                    Log.d(TAG, ""+phone_number+" cannot be converted to int");
                }

                iNext.putExtra(PARAMETER_2_NAME, phone_number);
                startActivity(iNext);
            }
        });
    }
}