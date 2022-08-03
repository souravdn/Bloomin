package com.example.simplecalc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Hashtable;

public class ReminderDB  extends AppCompatActivity {
    SQLiteDatabase reminderDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ReminderDB(MainActivity activity) {
        super();
        try {
            Log.e("DB-Path:", activity.getFilesDir().getPath());
            reminderDB = activity.openOrCreateDatabase("TestDB", activity.MODE_PRIVATE, null);
            reminderDB.execSQL("CREATE TABLE IF NOT EXISTS Reminder (reminderId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, type NVARCHAR, " +
                    "time NCHAR(10), date NCHAR(30), temperature NCHAR(20), fertilize NCHAR(30), botanicalName NVARCHAR, family NVARCHAR, " +
                    "type NCHAR(20), category NCHAR(20), profilePic NVARCHAR)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertReminder(String name, String description, String light, String temperature, String fertilize, String botanicalName, String family,String type,String category, String profilePic, String humidity, String size, String repotting, String bloom, String nativeArea) {
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

            reminderDB.insertOrThrow("reminder", null, values);
            return true;
        } catch (Exception e) {
            Log.e("ERROR:--", e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public Hashtable getReminder(int reminderId) {
        Hashtable<String, String> reminderDict = new Hashtable<String, String>();
        try {
            Cursor c = reminderDB.rawQuery("SELECT * FROM reminder WHERE reminderId=" + reminderId, null);
            int reminderIdIndex = c.getColumnIndex("reminderId");
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
            if (c.getCount() == 0)
                return reminderDict;

            for (c.move(0); c.moveToNext(); c.isAfterLast()) {
                reminderDict.put("reminderIndex", c.getInt(reminderIdIndex) + "");
                reminderDict.put("name", c.getString(nameIndex));
                reminderDict.put("description", c.getString(descriptionIndex));
                reminderDict.put("light", c.getString(lightIndex));
                reminderDict.put("temperature", c.getString(temperatureIndex));
                reminderDict.put("fertilize", c.getString(fertilizeIndex));
                reminderDict.put("botanicalName", c.getString(botanicalNameIndex));
                reminderDict.put("family", c.getString(familyIndex));
                reminderDict.put("type", c.getString(typeIndex));
                reminderDict.put("category", c.getString(categoryIndex));
                reminderDict.put("profilePic", c.getString(profilePicIndex));
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reminderDict;
    }

    public ArrayList<Hashtable<String, String>> getReminders() {
        ArrayList<Hashtable<String, String>> reminderDictArr = new ArrayList<Hashtable<String, String>>();

        try {
            Cursor c = reminderDB.rawQuery("SELECT * FROM reminder", null);
            int reminderIdIndex = c.getColumnIndex("reminderId");
            int nameIndex = c.getColumnIndex("name");
            int typeIndex = c.getColumnIndex("type");
            Log.e("Total results:", c.getCount() + "");

            if (c.getCount() == 0) {
                return reminderDictArr;
            }
            for (c.move(0); c.moveToNext(); c.isAfterLast()) {
                Hashtable<String, String> reminderDict = new Hashtable<String, String>();

                reminderDict.put("reminderIndex", c.getInt(reminderIdIndex) + "");
                reminderDict.put("name", c.getString(nameIndex));
                reminderDict.put("type", c.getString(typeIndex));
                reminderDictArr.add(reminderDict);
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reminderDictArr;
    }
}
