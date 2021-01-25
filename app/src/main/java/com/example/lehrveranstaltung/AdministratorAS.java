package com.example.lehrveranstaltung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AdministratorAS extends AppCompatActivity implements View.OnClickListener {

    Button erstellenButton;
    Button bearbeitenButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_as);
        erstellenButton = findViewById(R.id.erstellen);
        bearbeitenButton = findViewById(R.id.bearbeiten);

        erstellenButton.setOnClickListener(this);
        bearbeitenButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == erstellenButton.getId()){
            Intent intent = new Intent(AdministratorAS.this, AdminSachbearbeiterErstellenAAS.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(AdministratorAS.this, SachbearbeiterAuswaehlenAAS.class);
            intent.putExtra(SachbearbeiterS.NAECHSTE_AKTIVITAET, AdminSachbearbeiterEditierenAAS.class);
            startActivity(intent);
        }
    }
}
