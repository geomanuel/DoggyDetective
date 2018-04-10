package com.gmanuel.doggydetective;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CharacteristicsInput extends AppCompatActivity {
    private Button next;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characteristics_input);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreedDescription();
            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPictureInput();
            }
        });
    }

    public void openBreedDescription(){
        Intent next = new Intent(this, BreedDescription.class);
        startActivity(next);
    }

    public void openPictureInput(){
        Intent back = new Intent(this, PictureInput.class);
        startActivity(back);
    }

}