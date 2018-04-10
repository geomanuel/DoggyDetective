package com.gmanuel.doggydetective;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BreedDescription extends AppCompatActivity {
    private Button yes;
    private Button no;
    private Blackboard blackboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_description);

        yes = findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
        no = findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPictureInput();
            }
        });
    }

    public void openHome(){
        Intent yes = new Intent(this, Home.class);
        startActivity(yes);
    }

    public void openPictureInput(){
        Intent no = new Intent(this, PictureInput.class);
        startActivity(no);
    }

}
