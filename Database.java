package com.example.locationloggingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.LocationListener;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tracking.db";
    public static final String TABLE_NAME = "tracking_table";
    public static final String COL_1 = "TimeStamp";
    public static final String COL_2 = "XCoord";
    public static final String COL_3 = "YCoord";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public Database(LocationListener locationListener) {
        super((Context) locationListener, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (TimeStamp TEXT PRIMARY KEY AUTOINCREMENT,XCoord DOUBLE ,YCoord DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String timestamp, double xcoord, double ycoord) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, timestamp);
        contentValues.put(COL_2, xcoord);
        contentValues.put(COL_3, ycoord);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
    /*
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    */

