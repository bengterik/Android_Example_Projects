package com.example.sqlexample.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class DateTimeUtils {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long getCurrentTime() {
        long timeInMillis = LocalDateTime.now().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
        long timeInMillis2 = System.currentTimeMillis();

        LocalDateTime dateTime = Instant.ofEpochMilli(timeInMillis).atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTime2 = Instant.ofEpochMilli(timeInMillis2).atZone(ZoneId.systemDefault()).toLocalDateTime();

        return timeInMillis;
    }
}
