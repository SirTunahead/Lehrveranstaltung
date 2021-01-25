package com.example.lehrveranstaltung;

import java.util.HashMap;
import java.util.Map;

public enum Berechtigung {

    ADMIN(0), SACHBEARBEITER(1);
    private int value;

    private static Map map = new HashMap<>();

    private Berechtigung(int value) {
        this.value = value;
    }

    static {
        for (Berechtigung berechtigung: Berechtigung.values()) {
            map.put(berechtigung.value, berechtigung);
        }
    }

    public static Berechtigung valueOf(int berechtigung) {
        return (Berechtigung) map.get(berechtigung);
    }

    public int getValue() {
        return value;
    }
}
