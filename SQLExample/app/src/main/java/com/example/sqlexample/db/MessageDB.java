package com.example.sqlexample.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.sqlexample.model.Message;
import com.example.sqlexample.util.DateTimeUtils;

import java.util.LinkedList;
import java.util.List;

public class MessageDB {
    public static List<Message> getAllMessages(Context ctx) {
        List<Message> res = new LinkedList<>();

        ChatSQLiteHelper charDB = new ChatSQLiteHelper(ctx);
        SQLiteDatabase connection = charDB.getReadableDatabase();
        Cursor resultset = connection.rawQuery("SELECT * FROM message;", null);
        while (resultset.moveToNext()) {
            res.add(new Message(resultset.getInt(0), resultset.getLong(1), resultset.getString(2)));
        }
        connection.close();
        return res;
    }

    public static void insertNewMessage(Context ctx, String message) {
        ChatSQLiteHelper charDB = new ChatSQLiteHelper(ctx);
        SQLiteDatabase connection = charDB.getWritableDatabase();
        connection.execSQL("INSERT INTO message (timestamp,msg) VALUES " +
                "(" + DateTimeUtils.getCurrentTime()+ ", '"+message+"');");
    }
}

