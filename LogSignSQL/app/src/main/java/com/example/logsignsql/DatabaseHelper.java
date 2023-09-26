package com.example.logsignsql;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Signup.db";

    public DatabaseHelper(@Nullable Context context) {

        super(context, "signup.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("CREATE TABLE allusers(email TEXT PRIMARY KEY, fullname TEXT, password TEXT)");
        Log.d("Database", "Table 'allusers' created successfully with 'fullname' column.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {
        MyDatabase.execSQL("DROP TABLE IF EXISTS allusers");
        Log.d("Database", "Table 'allusers' dropped.");
        onCreate(MyDatabase); // Recreate the table with the updated schema
    }

    public Boolean insertData(String fullname, String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("fullname", fullname);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDatabase.insert("allusers", null, contentValues);

        if(result == -1){
            return false;
        } else {
            return true;
        }
    }


    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ?", new String[] {email});

        if(cursor.getCount() >0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkEmailPassowrd(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allusers WHERE email = ? AND password = ?", new String[] {email, password});

        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public String getUserName(String email, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        String[] columns = {"email"}; // Change "name" to the actual column name
        String[] selectionArgs = {email, password};
        Cursor cursor = MyDatabase.query("allusers", columns, "email=? AND password=?", selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            // Retrieve the user's name (assuming it's stored in the "name" column)
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("email"));
            cursor.close();
            return name;
        } else {
            cursor.close();
            return null;
        }
    }

}
