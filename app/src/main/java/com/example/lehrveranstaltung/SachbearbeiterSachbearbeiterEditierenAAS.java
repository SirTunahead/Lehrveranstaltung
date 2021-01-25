package com.example.lehrveranstaltung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.awt.font.NumericShaper;

public class SachbearbeiterSachbearbeiterEditierenAAS extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sachbearbeiter_sachbearbeiter_editieren_aas);

        String gewaehlterSachbearbeiter =
                getIntent().getStringExtra(
                        SachbearbeiterAuswaehlenAAS.
                                GEWAEHLTER_SACHBEARBEITER);

        Button okKnopf = (Button) this.findViewById(R.id.sachbearbeiterSOKKnopf);
        okKnopf.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Context act = null;
        NumericShaper berechtigung = null;

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
}
