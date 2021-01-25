package com.example.lehrveranstaltung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.awt.font.NumericShaper;

public class AdminSachbearbeiterErstellenAAS extends AppCompatActivity implements View.OnClickListener {

    EditText neuerName;
    EditText neuesPasswort;
    RadioGroup berechtigungsGruppe;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_sachbearbeiter_erstellen_aas);

        Button okKnopf = (Button) this.findViewById(R.id.sachbearbeiterSOKKnopf);
        okKnopf.setOnClickListener(this);

        neuerName = findViewById(R.id.editTextTextPersonName);
        neuesPasswort = findViewById(R.id.editTextTextPassword);
        berechtigungsGruppe = findViewById(R.id.rollenAuswahlRadioGroup);
    }

    @Override
    public void onClick(View view) {

        Berechtigung berechtigung = Berechtigung.SACHBEARBEITER;
        switch (berechtigungsGruppe.getCheckedRadioButtonId()){
            case R.id.sachbearbeiterRadio:
                berechtigung = Berechtigung.SACHBEARBEITER;
                break;
            case R.id.adminRadio:
                berechtigung = Berechtigung.ADMIN;
                break;
        }
        Sachbearbeiter sachbearbeiter = new Sachbearbeiter(neuerName.getText().toString(), neuesPasswort.getText().toString(), berechtigung);
        SachbearbeiterAuswaehlenK.getInstance().addSachbearbeiter(sachbearbeiter);

    }
}
