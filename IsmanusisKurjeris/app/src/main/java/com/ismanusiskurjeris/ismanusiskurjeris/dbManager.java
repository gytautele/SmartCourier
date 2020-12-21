package com.ismanusiskurjeris.ismanusiskurjeris;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbManager extends SQLiteOpenHelper {
    public dbManager(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        //DB.execSQL("create Table Userdetails(name TEXT primary key, contact TEXT, dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        //DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(double LocationX, double LocationY, String Status, String Details, int ID)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("LocationX", LocationX);
        contentValues.put("LocationY", LocationY);
        contentValues.put("Status", Status);
        contentValues.put("Details", Details);
        contentValues.put("ID", ID);
        contentValues.put("ClientID", 1002);
        contentValues.put("Registred", "2020-12-20 15:16:23");
        contentValues.put("Delivered", "");
        contentValues.put("Time_chosen", 900);
        contentValues.put("UserID", 2);
        long result=DB.insert("Package", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean updateuserdata(String id, String status) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Status", status);
        Cursor cursor = DB.rawQuery("Select * from Package where ID = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.update("Package", contentValues, "ID=?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean LogIn(String username, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Users where LogInID = ? and Password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public Boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata (String packageID) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select Package.LocationX, Package.LocationY, ClientID, Status, Time_chosen, Details from Package where ID = ? ", new String[]{packageID}, null);
        return cursor;
    }
    public Cursor getdata1 (String clientID) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select Name, LastName, PhoneNumber, Address, LocationX, LocationY from Client where Client.ID = ?", new String[]{clientID}, null);
        return cursor;
    }
}