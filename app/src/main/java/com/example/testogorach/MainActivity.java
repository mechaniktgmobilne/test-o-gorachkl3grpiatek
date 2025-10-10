package com.example.testogorach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pytanie> pytania =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}