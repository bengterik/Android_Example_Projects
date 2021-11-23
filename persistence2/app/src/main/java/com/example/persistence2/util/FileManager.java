package com.example.persistence2.util;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileManager {

    public static void writeToFile(Context ctx, String path, String content) {
        try{
            OutputStreamWriter outputStreamWriter=
                    new OutputStreamWriter(
                            ctx.openFileOutput(path, Context.MODE_APPEND));
                    outputStreamWriter.write(content + "\n");
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readFile(Context ctx, String path) {
            String contents = "";
            try{
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(ctx.openFileInput("test.txt")));
                                        String text = br.readLine();
                String line;
                while ((line = br.readLine()) != null) {
                    contents += line;
                }
                Log.i("ddd",text);
                br.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return contents;
    }
}
