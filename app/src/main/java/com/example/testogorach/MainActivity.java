package com.example.testogorach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pytanie> pytania = new ArrayList<>();
    private TextView textViewPytanie;
    private Button buttonTak;
    private Button buttonNie;
    private Button buttonNastepne;
    private Button buttonPodpowiedz;
    private ImageView imageView;
    private int aktualnePytanie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTak = findViewById(R.id.buttonTak);
        buttonNie = findViewById(R.id.buttonNie);
        buttonNastepne = findViewById(R.id.buttonNastepne);
        buttonPodpowiedz = findViewById(R.id.buttonPodpowiedz);
        imageView = findViewById(R.id.imageView);
        textViewPytanie = findViewById(R.id.textViewPytanie);

        pytania.add(new Pytanie(
                "Czy na obrazie są widoczne Alpy?",
                R.drawable.beskidy,
                false,
                "To są Polskie góry między innymi na Śląsku"));

        pytania.add(new Pytanie(
                "Czy na zdjęciu są widoczne Bieszczady?",
                R.drawable.bieszczady,
                true,
                "To są polskie góry wysunięte najbardziej na wschód Polski"));
        pytania.add(new Pytanie(
                "Czy na zdjęciu są widoczne Himalaje",
                R.drawable.tatry,
                false,
                "Na zdjęciu są widoczne najwyższe góry w Polsce"));

        wyswietlPytanie(0);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnePytanie++;
                        if (aktualnePytanie < pytania.size()) {
                            wyswietlPytanie(aktualnePytanie);
                        } else {
                            wyswietlPodsumowanie();
                        }
                    }
                }
        );
        buttonPodpowiedz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intecja =  new Intent(MainActivity.this, PodpowiedzActivity.class);
                        intecja.putExtra("KTOREPYTANIE",aktualnePytanie);
                        startActivity(intecja);
                    }
                }
        );
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzOdpowiedz(true, aktualnePytanie);
                    }
                }
        );
        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzOdpowiedz(false, aktualnePytanie);
                    }
                }
        );
    }

    private void sprawdzOdpowiedz(boolean odpowiedz, int nrPytania) {
        //TODO przeniesc do klasy pytanie
        if (pytania.get(nrPytania).isOdpowiedz() == odpowiedz) {
            pytania.get(nrPytania).setCzyUdzielonaPoprawnaODpowiedz(true);
            Toast.makeText(this, "Dobra odpowiedz", Toast.LENGTH_SHORT).show();
        } else {
            pytania.get(nrPytania).setCzyUdzielonaPoprawnaODpowiedz(false);
            Toast.makeText(this, "Zła odpowiedz", Toast.LENGTH_SHORT).show();
        }
    }

    private void wyswietlPodsumowanie() {
        //znikanie button
        buttonNastepne.setVisibility(View.INVISIBLE);
        buttonNie.setVisibility(View.INVISIBLE);
        buttonPodpowiedz.setVisibility(View.INVISIBLE);
        buttonTak.setVisibility(View.INVISIBLE);
        //znika grafika
        imageView.setVisibility(View.INVISIBLE);
        //w textview info ze koniec
        textViewPytanie.setText("Koniec testu, otrzymano "+obliczIlePunktowZaTest());

    }

    private void wyswietlPytanie(int numerPytania) {
        textViewPytanie.setText(pytania.get(numerPytania).getTrescPytania());
        imageView.setImageResource(pytania.get(numerPytania).getIdObrazka());
    }

    private int obliczIlePunktowZaTest() {
        int sumaPunktow = 0;
        for (Pytanie pytanko : pytania) {
            if (pytanko.isCzyUdzielonaPoprawnaODpowiedz()) {
                sumaPunktow = sumaPunktow + 1;
            }
        }
        return sumaPunktow;
    }
}