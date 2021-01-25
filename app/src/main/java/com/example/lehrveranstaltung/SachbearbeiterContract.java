package com.example.lehrveranstaltung;

import android.provider.BaseColumns;

public class SachbearbeiterContract {


    private SachbearbeiterContract() {
    }

    public static final class SacharbeiterEntry implements BaseColumns {
        public static final String TABLE_NAME = "sacharbeiterListe";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PASSWORT = "passwort";
        public static final String COLUMN_BERECHTIGUNG = "berechtigung";
    }

}
