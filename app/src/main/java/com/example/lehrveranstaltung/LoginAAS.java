package com.example.lehrveranstaltung;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.awt.font.NumericShaper;


public class LoginAAS  extends AppCompatActivity implements View.OnClickListener {
    private Berechtigung berechtigung = Berechtigung.SACHBEARBEITER;
    RadioGroup berechtigungsAuswahl;

    EditText name;
    EditText passwort;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginaas);

        name = findViewById(R.id.editTextTextPersonName);
        passwort = findViewById(R.id.editTextTextPassword);

        Button okKnopf = (Button) this.findViewById(R.id.sachbearbeiterSOKKnopf);
        berechtigungsAuswahl = (RadioGroup) this.findViewById(R.id.rollenAuswahlRadioGroup);
        okKnopf.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        Context act = this;

        switch (berechtigungsAuswahl.getCheckedRadioButtonId()){
            case R.id.sachbearbeiterRadio:
                berechtigung = Berechtigung.SACHBEARBEITER;
                break;
            case R.id.adminRadio:
                berechtigung = Berechtigung.ADMIN;
                break;
        }

        Log.d("Test ", name.getText().toString() + " " + passwort.getText().toString());

//        if(!SachbearbeiterAuswaehlenK.getInstance().login(name.getText().toString().trim(), passwort.getText().toString().trim(), berechtigung)) return;

        if (berechtigung.equals(Berechtigung.ADMIN)) {
            Intent intent2 =
                    new Intent(act, AdministratorAS.class);
            act.startActivity(intent2);
        } else {
            Intent intent3 = new Intent(act,
                    SachbearbeiterAS.class);
            act.startActivity(intent3);


        }
    }

    /*
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    // If your minSdkVersion is 11 or higher, instead use:
    //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = new Intent(this, LoginAAS.class);
        startActivity(intent);

        finish();
        int layoutID = 1;
        setContentView(layoutID);
        Button okKnopf = (Button)
                this.findViewById(R.id.sachbearbeiterSOKKnopf);
        okKnopf.setOnClickListener(this.okKnopfLauscher);


        } */
}
