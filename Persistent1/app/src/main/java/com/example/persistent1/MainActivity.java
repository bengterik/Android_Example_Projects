package com.example.persistent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String FILENAME_CONNECTION_PREFERENCES = "conn_prefs";
    private static final String FILENAME_CONNECTION_PREFERENCES_HOST = "host_name";
    private static final String FIELD_CONNECTION_PREFERENCES_PORT = "con";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences(FILENAME_CONNECTION_PREFERENCES, Context.MODE_PRIVATE);
        String host = prefs.getString(FILENAME_CONNECTION_PREFERENCES_HOST, "Upm.es");
        int port = prefs.getInt(FIELD_CONNECTION_PREFERENCES_PORT, 0);


        ((TextView)findViewById(R.id.lbl_saved_hostname)).setText(host);

        Button b = findViewById(R.id.btn_save_preference);
        b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              EditText txt = findViewById(R.id.txt_save_hostname);
              String hostname = txt.getText().toString();
              SharedPreferences.Editor editor = prefs.edit();
              editor.putString(FILENAME_CONNECTION_PREFERENCES_HOST, hostname);
              editor.putInt(FIELD_CONNECTION_PREFERENCES_PORT, 80);
              editor.commit();
          }
        });
    }
}