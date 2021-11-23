package com.example.sqlexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlexample.db.ChatSQLiteHelper;
import com.example.sqlexample.db.MessageDB;
import com.example.sqlexample.model.Message;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Message> data = MessageDB.getAllMessages(this);
        ArrayAdapter<Message> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, data);
        ListView lv = findViewById(R.id.lst_messages);
        lv.setAdapter(adapter);

        Button btn = findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edTxt = findViewById(R.id.txt_message);
                String txt = edTxt.getText().toString();
                if (!txt.trim().equals("")) {
                    MessageDB.insertNewMessage(MainActivity.this, txt);
                    data.clear();
                    data.addAll(MessageDB.getAllMessages(MainActivity.this));
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}