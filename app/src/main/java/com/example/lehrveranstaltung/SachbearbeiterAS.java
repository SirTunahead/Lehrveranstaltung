package com.example.lehrveranstaltung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SachbearbeiterAS extends AppCompatActivity implements View.OnClickListener {


    Button bearbeitenButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sachbearbeiter_as);
        bearbeitenButton = findViewById(R.id.bearbeiten);
        bearbeitenButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
            Intent intent = new Intent(SachbearbeiterAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NAECHSTE_AKTIVITAET, SachbearbeiterSachbearbeiterEditierenAAS.class);
            startActivity(intent);

    }
}
