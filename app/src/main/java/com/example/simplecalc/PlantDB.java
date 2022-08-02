package com.example.simplecalc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Hashtable;

public class PlantDB extends AppCompatActivity {
    SQLiteDatabase plantDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    PlantDB(MainActivity activity) {
        super();
        try {
            Log.e("DB-Path:", activity.getFilesDir().getPath());
            plantDB = activity.openOrCreateDatabase("TestDB", activity.MODE_PRIVATE, null);
            plantDB.execSQL("CREATE TABLE IF NOT EXISTS Plant (plantId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name NVARCHAR, " +
                    "description NVARCHAR, light NCHAR(30), temperature NCHAR(20), fertilize NCHAR(30), botanicalName NVARCHAR, family NVARCHAR, " +
                    "type NCHAR(20), category NCHAR(20), profilePic NVARCHAR, size NVARCHAR,humidity NCHAR(10), repotting NVARCHAR, bloom  NCHAR(20), nativeArea NVARCHAR)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertPlant(String name, String description, String light, String temperature, String fertilize, String botanicalName, String family,String type,String category, String profilePic, String humidity, String size, String repotting, String bloom, String nativeArea) {
        try {
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("description", description);
            values.put("light", light);
            values.put("temperature", temperature);
            values.put("fertilize", fertilize);
            values.put("botanicalName", botanicalName);
            values.put("family", family);
            values.put("type", type);
            values.put("category", category);
            values.put("profilePic", profilePic);
            values.put("humidity", humidity);
            values.put("size", size);
            values.put("repotting", repotting);
            values.put("bloom", bloom);
            values.put("nativeArea", nativeArea);
            try {
                plantDB.insertOrThrow("Plant", null, values);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } catch (Exception e) {
            Log.e("ERROR:--", e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public Hashtable getPlant(int plantId) {
        Hashtable<String, String> plantDict = new Hashtable<String, String>();
        try {
            Cursor c = plantDB.rawQuery("SELECT * FROM Plant WHERE plantId=" + plantId, null);
            int plantIdIndex = c.getColumnIndex("plantId");
            int nameIndex = c.getColumnIndex("name");
            int descriptionIndex = c.getColumnIndex("description");
            int lightIndex = c.getColumnIndex("light");
            int temperatureIndex = c.getColumnIndex("temperature");
            int fertilizeIndex = c.getColumnIndex("fertilize");
            int botanicalNameIndex = c.getColumnIndex("botanicalName");
            int familyIndex = c.getColumnIndex("family");
            int typeIndex = c.getColumnIndex("type");
            int categoryIndex = c.getColumnIndex("category");
            int profilePicIndex = c.getColumnIndex("profilePic");
            int humidityIndex = c.getColumnIndex("humidity");
            int sizeIndex = c.getColumnIndex("size");
            int repottingIndex = c.getColumnIndex("repotting");
            int bloomIndex = c.getColumnIndex("bloom");
            int nativeAreaIndex = c.getColumnIndex("nativeArea");
            if (c.getCount() == 0)
                return plantDict;

            for (c.move(0); c.moveToNext(); c.isAfterLast()) {
                plantDict.put("plantIndex", c.getInt(plantIdIndex) + "");
                plantDict.put("name", c.getString(nameIndex));
                plantDict.put("description", c.getString(descriptionIndex));
                plantDict.put("light", c.getString(lightIndex));
                plantDict.put("temperature", c.getString(temperatureIndex));
                plantDict.put("fertilize", c.getString(fertilizeIndex));
                plantDict.put("botanicalName", c.getString(botanicalNameIndex));
                plantDict.put("family", c.getString(familyIndex));
                plantDict.put("type", c.getString(typeIndex));
                plantDict.put("category", c.getString(categoryIndex));
                plantDict.put("profilePic", c.getString(profilePicIndex));
                plantDict.put("humidity", c.getString(humidityIndex));
                plantDict.put("size", c.getString(sizeIndex));
                plantDict.put("repotting", c.getString(repottingIndex));
                plantDict.put("bloom", c.getString(bloomIndex));
                plantDict.put("nativeArea", c.getString(nativeAreaIndex));
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plantDict;
    }

    public ArrayList<Hashtable<String, String>> getPlants() {
        ArrayList<Hashtable<String, String>> plantDictArr = new ArrayList<Hashtable<String, String>>();

        try {
            Cursor c = plantDB.rawQuery("SELECT * FROM Plant", null);
            int plantIdIndex = c.getColumnIndex("plantId");
            int nameIndex = c.getColumnIndex("name");
            int descriptionIndex = c.getColumnIndex("description");
            int lightIndex = c.getColumnIndex("light");
            int temperatureIndex = c.getColumnIndex("temperature");
            int fertilizeIndex = c.getColumnIndex("fertilize");
            int botanicalNameIndex = c.getColumnIndex("botanicalName");
            int familyIndex = c.getColumnIndex("family");
            int typeIndex = c.getColumnIndex("type");
            int categoryIndex = c.getColumnIndex("category");
            int profilePicIndex = c.getColumnIndex("profilePic");
            int humidityIndex = c.getColumnIndex("humidity");
            int sizeIndex = c.getColumnIndex("size");
            int repottingIndex = c.getColumnIndex("repotting");
            int bloomIndex = c.getColumnIndex("bloom");
            int nativeAreaIndex = c.getColumnIndex("nativeArea");
            Log.e("Total results:", c.getCount() + "");

            if (c.getCount() == 0) {
                return plantDictArr;
            }
            for (c.move(0); c.moveToNext(); c.isAfterLast()) {
                Hashtable<String, String> plantDict = new Hashtable<String, String>();

                plantDict.put("plantIndex", c.getInt(plantIdIndex) + "");
                plantDict.put("name", c.getString(nameIndex));
                plantDict.put("description", c.getString(descriptionIndex));
                plantDict.put("light", c.getString(lightIndex));
                plantDict.put("temperature", c.getString(temperatureIndex));
                plantDict.put("fertilize", c.getString(fertilizeIndex));
                plantDict.put("botanicalName", c.getString(botanicalNameIndex));
                plantDict.put("family", c.getString(familyIndex));
                plantDict.put("type", c.getString(typeIndex));
                plantDict.put("category", c.getString(categoryIndex));
                plantDict.put("profilePic", c.getString(profilePicIndex));
                plantDict.put("humidity", c.getString(humidityIndex));
                plantDict.put("size", c.getString(sizeIndex));
                plantDict.put("repotting", c.getString(repottingIndex));
                plantDict.put("bloom", c.getString(bloomIndex));
                plantDict.put("nativeArea", c.getString(nativeAreaIndex));
                plantDictArr.add(plantDict);
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plantDictArr;
    }
}