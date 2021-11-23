package com.example.sqlexample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqlexample.util.DateTimeUtils;

public class ChatSQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="chat.db";
    private static final int DATABASE_VERSION = 1;

    public ChatSQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE message (\n" +
                    " _id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                    " timestamp INTEGER, \n" +
                    " msg TEXT " +
            ");");

            sqLiteDatabase.execSQL("INSERT INTO message (timestamp,ms) VALUES" +
                                   "("+ DateTimeUtils.getCurrentTime() + ", 'Welcome to my app');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("INSERT INTO message (timestamp,ms) VALUES" +
                "("+ DateTimeUtils.getCurrentTime() + ", 'Upgraded from v'" + i +" to v" + i1+");");

    }
}
