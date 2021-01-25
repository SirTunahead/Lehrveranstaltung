package com.example.lehrveranstaltung;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lehrveranstaltung.SachbearbeiterContract.*;

public class SachbearbeiterHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sachbearbeiter.db";
    public static final int DATABASE_VERSION = 1;

    public SachbearbeiterHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " +
                SachbearbeiterContract.SacharbeiterEntry.TABLE_NAME + " (" +
                SachbearbeiterContract.SacharbeiterEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SachbearbeiterContract.SacharbeiterEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                SachbearbeiterContract.SacharbeiterEntry.COLUMN_PASSWORT + " TEXT NOT NULL, " +
                SachbearbeiterContract.SacharbeiterEntry.COLUMN_BERECHTIGUNG + " INTEGER NOT NULL" +
                ");";
        db.execSQL(SQL_CREATE_USER_TABLE);

        //Standard User einfügen

        ContentValues cv = new ContentValues();
        cv.put(SachbearbeiterContract.SacharbeiterEntry.COLUMN_NAME, "Ralf");
        cv.put(SachbearbeiterContract.SacharbeiterEntry.COLUMN_PASSWORT, "test");
        cv.put(SachbearbeiterContract.SacharbeiterEntry.COLUMN_BERECHTIGUNG, Berechtigung.ADMIN.getValue());

        db.insert(SachbearbeiterContract.SacharbeiterEntry.TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SachbearbeiterContract.SacharbeiterEntry.TABLE_NAME);
        onCreate(db);
    }
}
