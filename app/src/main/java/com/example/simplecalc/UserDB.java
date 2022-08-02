package com.example.simplecalc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Dictionary;
import java.util.Hashtable;

public class UserDB extends AppCompatActivity {
    SQLiteDatabase userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    UserDB(MainActivity activity) {
        super();
        try {
            Log.e("DB-Path:", activity.getFilesDir().getPath());
            userDB = activity.openOrCreateDatabase("TestDB", activity.MODE_PRIVATE, null);
            userDB.execSQL("CREATE TABLE IF NOT EXISTS User (userId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name NVARCHAR, email NVARCHAR, phoneNo NCHAR(10), " +
                    "gender NCHAR(15), birthday NCHAR(10), address NVARCHAR, password NVARCHAR, profilePic NVARCHAR, loggedIn NCHAR(5))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertUser(String name, String email, String phoneNo, String gender, String birthday, String address, String password, String profilePic, boolean loggedIn) {
        try {
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("email", email);
            values.put("phoneNo", phoneNo);
            values.put("gender", gender);
            values.put("birthday", birthday);
            values.put("address", address);
            values.put("password", password);
            values.put("profilePic", profilePic);
            values.put("loggedIn", loggedIn);
            try {
                userDB.insertOrThrow("User", null, values);
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

    public Hashtable getUser(int userId) {
        Hashtable<String, String> userDict = new Hashtable<String, String>();
        try {
            Cursor c = userDB.rawQuery("SELECT * FROM User WHERE userId="+userId, null);
            int idIndex = c.getColumnIndex("userId");
            int nameIndex = c.getColumnIndex("name");
            int emailIndex = c.getColumnIndex("email");
            int phoneNoIndex = c.getColumnIndex("phoneNo");
            int genderIndex = c.getColumnIndex("gender");
            int birthdayIndex = c.getColumnIndex("birthday");
            int addressIndex = c.getColumnIndex("address");
            int passwordIndex = c.getColumnIndex("password");
            int profilePicIndex = c.getColumnIndex("password");
            int loggedInIndex = c.getColumnIndex("loggedIn");
            Log.e("Total results:", c.getCount() + "");
            
            if (c.getCount() == 0)
                return userDict;   //0 row
            
            if (c != null  && c.moveToFirst()) {
                userDict.put("userId", c.getInt(idIndex) + "");
                userDict.put("name", c.getString(nameIndex));
                userDict.put("email", c.getString(emailIndex));
                userDict.put("phoneNo", c.getString(phoneNoIndex));
                userDict.put("gender", c.getString(genderIndex));
                userDict.put("birthday", c.getString(birthdayIndex));
                userDict.put("address", c.getString(addressIndex));
                userDict.put("password", c.getString(passwordIndex));
                userDict.put("profilePic", c.getString(profilePicIndex));
                userDict.put("loggedIn", c.getString(loggedInIndex));
                c.close();
            }
        } catch (Exception e) {
            Log.e("ERROR:-", e.getMessage());
            e.printStackTrace();
        }
        return userDict;
    }
}