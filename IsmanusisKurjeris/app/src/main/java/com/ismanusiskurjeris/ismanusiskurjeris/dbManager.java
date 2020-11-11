package com.ismanusiskurjeris.ismanusiskurjeris;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class dbManager extends SQLiteOpenHelper {

    private static final String dbName = "SmartKurjer.db";

    public dbManager(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE user (id integer PRIMARY KEY AUTOINCREMENT, name text, password text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public String addUser(String p1, String p2) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", p1);
        cv.put("password", p2);

        long res = db.insert("user", null, cv);

        if (res == -1)
            return "Failed";
        else
            return "Succesfully inserted";
    }
}
