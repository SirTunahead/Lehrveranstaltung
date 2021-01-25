package com.example.lehrveranstaltung;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SachbearbeiterAuswaehlenAAS extends AppCompatActivity {
    Intent naechsteAktivitaet;
    public static String GEWAEHLTER_SACHBEARBEITER = "Verklemmung";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sachbearbeiter_auswaehlen_aas);
        Intent aktuellerIntent = this.getIntent();
        naechsteAktivitaet = new Intent(SachbearbeiterAuswaehlenAAS.this, (Class) aktuellerIntent
                .getSerializableExtra(SachbearbeiterS.NAECHSTE_AKTIVITAET));
    }

    protected void onStart() {
        super.onStart();
        final ListView sachbearbeiterListe = (ListView) this
                .findViewById(R.id.sachbearbeiterListe);
        String[] alleSachbearbeiter = SachbearbeiterAuswaehlenK.getInstance().gibAlleSachbearbeiter();

        ArrayAdapter<String> itemsAdapter = new
                ArrayAdapter<String>(this,
                R.layout.simple_item, alleSachbearbeiter);
        sachbearbeiterListe.setAdapter(itemsAdapter);
        sachbearbeiterListe.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent,
                                            View view, int position, long id) {
                        String gewaehlterSachbearbeiter = (String)
                                sachbearbeiterListe.getAdapter()
                                        .getItem(position);
                        Log.d("Test", gewaehlterSachbearbeiter);
                        naechsteAktivitaet.putExtra(GEWAEHLTER_SACHBEARBEITER, gewaehlterSachbearbeiter);
                        startActivity(naechsteAktivitaet);
                    }
                });
    }
}
