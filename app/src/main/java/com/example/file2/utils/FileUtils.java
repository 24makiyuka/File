package com.example.file2.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileUtils {
    public static String readFile(Context context, String saveFileName) throws FileNotFoundException {
        return FileUtils.readStream(context.openFileInput(saveFileName));
    }


    public static String readStream(FileInputStream fis) {
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();}
        } catch (IOException e) {

        }
        return stringBuilder.toString().trim();
    }

    public static void writeFile(Context context, String saveFileName, String data) {
        try (FileOutputStream fos = context.openFileOutput(saveFileName, context.MODE_PRIVATE)) {
            fos.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

