package com.example.lehrveranstaltung;

public class Sachbearbeiter {

    public String name ="";
    public String passwort = "";
    public Berechtigung berechtigung;

    public Sachbearbeiter(String name, String passwort, Berechtigung berechtigung){
        this.name = name;
        this.passwort = passwort;
        this.berechtigung  = berechtigung;
    }

}
