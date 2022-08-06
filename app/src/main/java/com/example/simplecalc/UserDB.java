package com.example.simplecalc;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton$InspectionCompanion;

import java.util.ArrayList;

class UserDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BloominTest";

    public UserDB(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    public UserDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS User (userId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name NVARCHAR, email NVARCHAR  NOT NULL UNIQUE, " +
                "phoneNo NCHAR(10), gender NCHAR(15), birthday NCHAR(10), address NVARCHAR, password NVARCHAR, profilePic NVARCHAR, loggedIn NCHAR(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS User");
//        onCreate(db);
    }

    public boolean insertUser(String name, String email, String phoneNo, String gender, String birthday, String address, String password, String profilePic, String loggedIn) {
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

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("User", null, values);
        return true;
    }

    public boolean loginUser(String email,String password) {
        ContentValues values = new ContentValues();
        SQLiteDatabase dbr = this.getReadableDatabase();
        Cursor c = dbr.rawQuery("select * from User where email='" + email + "';", null);

        SQLiteDatabase dbw = this.getWritableDatabase();
        values.put("loggedIn", "false");
        dbw.update("User", values, "loggedIn = ? ", new String[]{"true"});
        if (c.getCount() == 1) {
            values.put("loggedIn", "true");
            dbw.update("User", values, "email = ? ", new String[]{email});
        }
        else {
            values.put("name", "");
            values.put("email", email);
            values.put("phoneNo", "");
            values.put("gender", "");
            values.put("birthday", "");
            values.put("address", "");
            values.put("password", password);
            values.put("profilePic", "");
            values.put("loggedIn", "true");
            dbw.insert("User", null, values);
        }
        return true;
    }

    public boolean signOut() {
        SQLiteDatabase dbw = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("loggedIn", "false");
        dbw.update("User", values, "loggedIn = ? ", new String[]{"true"});
        return true;
    }


    public Hashtable<String, String> getUser() {
        Hashtable<String, String> userDict = new Hashtable<String, String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from User where loggedIn='" + true + "';", null);
        int idIndex = c.getColumnIndex("userId");
        int nameIndex = c.getColumnIndex("name");
        int emailIndex = c.getColumnIndex("email");
        int phoneNoIndex = c.getColumnIndex("phoneNo");
        int genderIndex = c.getColumnIndex("gender");
        int birthdayIndex = c.getColumnIndex("birthday");
        int addressIndex = c.getColumnIndex("address");
        int passwordIndex = c.getColumnIndex("password");
        int profilePicIndex = c.getColumnIndex("profilePic");
        int loggedInIndex = c.getColumnIndex("loggedIn");
        Log.e("Total results -getUser:", c.getCount() + "");

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
        return userDict;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "User");
        return numRows;
    }

    public boolean updateUser(String name, String email, String phoneNo, String gender, String birthday, String address, String password, String profilePic) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phoneNo", phoneNo);
        values.put("gender", gender);
        values.put("birthday", birthday);
        values.put("address", address);
        values.put("password", password);
        values.put("profilePic", profilePic);

        Log.e("contentValues", values.toString());
        db.update("User", values, "loggedIn = ? ", new String[]{"true"});
        return true;
    }
}
