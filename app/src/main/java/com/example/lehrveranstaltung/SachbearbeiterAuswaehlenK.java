package com.example.lehrveranstaltung;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SachbearbeiterAuswaehlenK {

    private SQLiteDatabase database;

    public SQLiteDatabase getDatabase(Context context){
        SachbearbeiterHelper dbHelper = new SachbearbeiterHelper(context);
        database = dbHelper.getWritableDatabase();
        return database;
    }

    private Cursor getAllItems() {
        return database.query(
                SachbearbeiterContract.SacharbeiterEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                SachbearbeiterContract.SacharbeiterEntry.COLUMN_NAME + " ASC"
        );
    }

    public boolean login(String nameInput, String passwortInput, Context context){

        getDatabase(context);
        Cursor mCursor = getAllItems();

        while (mCursor.moveToNext()) {
            String name = mCursor.getString(mCursor.getColumnIndex(  SachbearbeiterContract.SacharbeiterEntry.COLUMN_NAME));
            String passwort = mCursor.getString(mCursor.getColumnIndex(  SachbearbeiterContract.SacharbeiterEntry.COLUMN_PASSWORT));

            if(name == nameInput){
                if(passwort == passwortInput){
                  return true;
                }
            }
        }
        return false;
    }

    public void addSachbearbeiter(String nameInput, String passwortInput, Berechtigung berechtigung){
        ContentValues cv = new ContentValues();
        cv.put(SachbearbeiterContract.SacharbeiterEntry.COLUMN_NAME, nameInput);
        cv.put(SachbearbeiterContract.SacharbeiterEntry.COLUMN_PASSWORT, passwortInput);
        cv.put(SachbearbeiterContract.SacharbeiterEntry.COLUMN_BERECHTIGUNG, berechtigung.getValue());

        database.insert(SachbearbeiterContract.SacharbeiterEntry.TABLE_NAME, null, cv);

    }

    public void removeSachbearbeiter(String nameInput){

        database.delete(SachbearbeiterContract.SacharbeiterEntry.TABLE_NAME,
                SachbearbeiterContract.SacharbeiterEntry.COLUMN_NAME + "=" + nameInput, null);

    }
}
